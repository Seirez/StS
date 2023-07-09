import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM characters");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String charName = resultSet.getString("char_name");
                int health = resultSet.getInt("health");
                int cblock = resultSet.getInt("cblock");
                Character character = new Character(charName, health, cblock);
                character.setId(id);
                characters.add(character);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public Character getCharacterById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM characters WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String charName = resultSet.getString("char_name");
                int health = resultSet.getInt("health");
                int cblock = resultSet.getInt("cblock");
                Character character = new Character(charName, health, cblock);
                character.setId(id);
                return character;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int createCharacter(Character character) {
        try {
            resetCharacterIdIncrement();
            PreparedStatement statement = connection.prepareStatement
            ("INSERT INTO characters (char_name, health, cblock) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, character.getCharName());
            statement.setInt(2, character.getHealth());
            statement.setInt(3, character.getCblock());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateCharacter(Character character) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE characters SET char_name = ?, health = ?, cblock = ? WHERE id = ?");
            statement.setString(1, character.getCharName());
            statement.setInt(2, character.getHealth());
            statement.setInt(3, character.getCblock());
            statement.setInt(4, character.getId());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCharacter(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM characters WHERE id = ?");
            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void resetCharacterIdIncrement() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) AS max_id FROM characters");
    
            if (resultSet.next()) {
                int maxId = resultSet.getInt("max_id");
                int newAutoIncrementValue = maxId + 1;
    
                statement.executeUpdate("ALTER TABLE characters AUTO_INCREMENT = " + newAutoIncrementValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
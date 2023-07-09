import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CharacterSelectionUI extends JFrame {

    private JComboBox<Character> characterComboBox;
    private JButton confirmButton;

    public CharacterSelectionUI() {
        API.runAPI();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<Character> characters = API.retrieveCharacters();
                CharacterSelectionUI selectionUI = new CharacterSelectionUI(characters);
                selectionUI.setVisible(true);
            }
        });
    }
    public CharacterSelectionUI(List<Character> characters) {
        setTitle("Slay the Spire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Character Selection");
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Create character selection components
        characterComboBox = new JComboBox<>(characters.toArray(new Character[0]));
        confirmButton = new JButton("Confirm");

        // Create layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add components to the frame
        add(label);
        add(characterComboBox);
        add(confirmButton);

        // Add event listener for the play button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Character selectedCharacter = (Character) characterComboBox.getSelectedItem();
                if (selectedCharacter != null) {
                    playGame(selectedCharacter);
                }
            }
        });
    }

    private void playGame(Character character) {
        // Enemies
        Enemy Enemy1 = new Enemy(null, 0, 0);
        Enemy1.setCharName("Slime");
        Enemy1.setHealth(30);

        // Implement the logic to start the game with the selected character
        new PlayUI(character,Enemy1);
        setVisible(false); // Hide the current frame
    }
}

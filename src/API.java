import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class API {
    public static void runAPI() {

        // Configure Spark port
        Spark.port(8080);

        // Configure Gson for JSON serialization/deserialization
        Gson gson = new GsonBuilder().create();

        // Set up database connection
        DatabaseConnection dbConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/sts", "root", "");

        // API endpoints

        // Get all characters
        Spark.get("/characters", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                List<Character> characters = dbConnection.getAllCharacters();
                return gson.toJson(characters);
            }
        });

        // Get character by ID
        Spark.get("/characters/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                int characterId = Integer.parseInt(request.params("id"));
                Character character = dbConnection.getCharacterById(characterId);
                if (character != null) {
                    return gson.toJson(character);
                } else {
                    response.status(404); // Not Found
                    return "Character not found";
                }
            }
        });

        // Create a new character
        Spark.post("/characters", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                Character character = gson.fromJson(request.body(), Character.class);
                int characterId = dbConnection.createCharacter(character);
                response.status(201); // Created
                return characterId;
            }
        });

        // Update character
        Spark.put("/characters/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                int characterId = Integer.parseInt(request.params("id"));
                Character character = gson.fromJson(request.body(), Character.class);
                character.setId(characterId);
                if (dbConnection.updateCharacter(character)) {
                    return "Character updated successfully";
                } else {
                    response.status(404); // Not Found
                    return "Character not found";
                }
            }
        });

        // Delete character
        Spark.delete("/characters/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                int characterId = Integer.parseInt(request.params("id"));
                if (dbConnection.deleteCharacter(characterId)) {
                    return "Character deleted successfully";
                } else {
                    response.status(404); // Not Found
                    return "Character not found";
                }
            }
        });
    }

        public static List<Character> retrieveCharacters() {
        // Create the HTTP client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Define the API endpoint URL
        String url = "http://localhost:8080/characters";

        // Create the HTTP GET request
        HttpGet request = new HttpGet(url);

        try {
            // Execute the request and retrieve the response
            HttpResponse response = httpClient.execute(request);

            // Read the response content
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            Character[] characters = gson.fromJson(result.toString(), Character[].class);

            return Arrays.asList(characters);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
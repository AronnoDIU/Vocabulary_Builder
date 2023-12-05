import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VocabularyBuilder {
    // API Key for Words API (https://rapidapi.com/dpventures/api/wordsapi)
    private static final String API_KEY = "76365d9909mshc9d2888c9e1fb66p171b69jsn3c0349053687";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a word: ");
            String word = reader.readLine();

            String apiUrl = "https://wordsapiv1.p.rapidapi.com/words/" + word;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", API_KEY);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader apiReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = apiReader.readLine()) != null) {
                    response.append(line);
                }
                apiReader.close();

                // Parse the JSON response and extract word definitions, synonyms, and example sentences
                // You can use a JSON parsing library like Jackson or Gson for this

                // Print the results
                System.out.println("Definitions: ");
                // Print definitions

                System.out.println("\nSynonyms: ");
                // Print synonyms

                System.out.println("\nExample Sentences: ");
                // Print example sentences

            } else {
                System.out.println("Error in API request. Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

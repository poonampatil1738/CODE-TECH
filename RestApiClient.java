import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

/*
 * CODTECH Internship Task - 2
 * REST API Client
 *
 * This program:
 * 1. Sends HTTP GET request to public weather API
 * 2. Receives JSON response
 * 3. Parses JSON
 * 4. Displays structured weather data
 *
 * API Used: Open-Meteo (No API key required)
 */

public class RestApiClient {

    public static void main(String[] args) {

        try {
            // Latitude & Longitude of Mumbai
            String url = "https://api.open-meteo.com/v1/forecast?latitude=19.07&longitude=72.87&current_weather=true";

            // Create HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // Create Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Send Request
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convert response to JSON
            JSONObject json = new JSONObject(response.body());

            JSONObject weather = json.getJSONObject("current_weather");

            // Extract values
            double temperature = weather.getDouble("temperature");
            double windspeed = weather.getDouble("windspeed");
            int weathercode = weather.getInt("weathercode");

            // Display formatted output
            System.out.println("\n===== Weather Report =====");
            System.out.println("Temperature : " + temperature + " °C");
            System.out.println("Wind Speed  : " + windspeed + " km/h");
            System.out.println("Weather Code: " + weathercode);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
          }

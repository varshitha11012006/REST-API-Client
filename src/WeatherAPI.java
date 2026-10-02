import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter latitude: ");
        double lat = sc.nextDouble();

        System.out.print("Enter longitude: ");
        double lon = sc.nextDouble();

        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + lat
                + "&longitude=" + lon
                + "&current=temperature_2m,wind_speed_10m,weather_code";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                JsonObject obj = JsonParser.parseString(response.body()).getAsJsonObject();

                JsonObject current = obj.getAsJsonObject("current");

                String time = current.get("time").getAsString();

                double temp = current.get("temperature_2m").getAsDouble();

                double wind = current.get("wind_speed_10m").getAsDouble();

                int code = current.get("weather_code").getAsInt();

                System.out.println("\n===== WEATHER INFORMATION =====");
                System.out.println("Latitude     : " + lat);
                System.out.println("Longitude    : " + lon);
                System.out.println("Time         : " + time);
                System.out.println("Temperature  : " + temp + " °C");
                System.out.println("Wind Speed   : " + wind + " km/h");
                System.out.println("Weather Code : " + code);
System.out.println("Condition    : " + getWeatherCondition(code));

            } else {

                System.out.println("API request failed.");
                System.out.println("Status Code: " + response.statusCode());
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
    public static String getWeatherCondition(int code) {

    if (code == 0) {
        return "Clear Sky";
    } else if (code == 1 || code == 2) {
        return "Partly Cloudy";
    } else if (code == 3) {
        return "Overcast";
    } else if (code == 45 || code == 48) {
        return "Fog";
    } else if (code >= 51 && code <= 57) {
        return "Drizzle";
    } else if (code >= 61 && code <= 67) {
        return "Rain";
    } else if (code >= 71 && code <= 77) {
        return "Snow";
    } else if (code >= 80 && code <= 82) {
        return "Rain Showers";
    } else if (code >= 95 && code <= 99) {
        return "Thunderstorm";
    }

    return "Unknown";
}
}
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.*;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println(getWeather());
        System.out.println(parseWeather(getWeather()));
    }

    public static JSONArray parseWeather(String response) {
        JSONObject jsonObject = new JSONObject(response);


        return jsonObject.getJSONObject("hourly").getJSONArray("time");
    }

    public static BigDecimal parse(String response, String key) {
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.getBigDecimal(key);
    }

    public static String getAddress() throws MalformedURLException {
        String urlString = "http://checkip.amazonaws.com/";
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCoordinates() throws MalformedURLException {
        String urlString = "https://api.ip2location.io/?key=B5811BEB7619C9F27517161490E01F85&ip=" + getAddress();
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getWeather() throws MalformedURLException {
        String urlString = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + parse(getCoordinates(), "latitude")
                + "&longitude=" + parse(getCoordinates(), "longitude")
                + "&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
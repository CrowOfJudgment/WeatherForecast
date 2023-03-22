import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        //new Interface();
        //parseWeather(getWeather());
    }

    public static void parseWeather(String response) {
        JSONObject jsonObject = new JSONObject(response);
        JSONArray timeInJSON = jsonObject.getJSONObject("hourly").getJSONArray("time");
        JSONArray temperatureInJSON = jsonObject.getJSONObject("hourly").getJSONArray("temperature_2m");

        ArrayList<String> time = new ArrayList<>();
        ArrayList<BigDecimal> temperature = new ArrayList<>();

        for (int i = 0; i < timeInJSON.length(); i++) {
            time.add(timeInJSON.getString(i));
            temperature.add(temperatureInJSON.getBigDecimal(i));
        }

        for (int i = 0; i < time.size(); i++) {
            System.out.println(time.get(i) + ": " + temperature.get(i));
        }

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
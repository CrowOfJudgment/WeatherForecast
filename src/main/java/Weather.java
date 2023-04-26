import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Weather {
    static JSONObject jsonObject;
    public static void parseWeather(String response) {
        jsonObject = new JSONObject(response);
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
    public Object currentWeather(String response, String key){
        jsonObject = new JSONObject(response);
        return jsonObject.getJSONObject("current_weather").get(key);
    }

    public static Object parse(String response, String key) {
        jsonObject = new JSONObject(response);
        return jsonObject.get(key);
    }

    public static String getCoordinates() throws MalformedURLException {
        String urlString = "http://ip-api.com/json?fields=49663" ;
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getWeather() throws MalformedURLException {
        String urlString = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + parse(getCoordinates(), "lat")
                + "&longitude=" + parse(getCoordinates(), "lon")
                + "&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m" ;
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

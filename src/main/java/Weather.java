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
    Coordinates coordinates = Coordinates.getCoordinates();

    // Singleton
    private static final Weather WEATHER = new Weather();
    public static Weather getWeather(){
        return WEATHER;
    }
    private Weather(){

    }

    public static void getHourlyForecast(String response) {
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

    // returns desired key from current weather from open-meteo api
    public Object getCurrent(String key) throws MalformedURLException {
        jsonObject = new JSONObject(getAll());
        return jsonObject.getJSONObject("current_weather").get(key);
    }

    // returns all current weather keys from open-meteo api
    public Object getCurrent() throws MalformedURLException {
        jsonObject = new JSONObject(getAll());
        return jsonObject.getJSONObject("current_weather");
    }

    // returns all keys from open-meteo api
    public String getAll() throws MalformedURLException {
        String urlString = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + coordinates.get("lat")
                + "&longitude=" + coordinates.get("lon")
                + "&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m" ;
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

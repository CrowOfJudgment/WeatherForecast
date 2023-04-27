import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Coordinates {
    static JSONObject jsonObject;

    // Singleton
    private static final Coordinates COORDINATES = new Coordinates();
    public static Coordinates getCoordinates(){
        return COORDINATES;
    }
    private Coordinates(){

    }

    // returns desired key from ip-api
    public Object get(String key) throws MalformedURLException {
        jsonObject = new JSONObject(get());
        return jsonObject.get(key);
    }

    // returns all keys from ip-api
    public String get() throws MalformedURLException {
        String urlString = "http://ip-api.com/json?fields=49663" ;
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

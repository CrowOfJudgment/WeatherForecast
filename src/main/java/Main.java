import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        new Interface();
        Weather weather = Weather.getWeather();
        Coordinates coordinates = Coordinates.getCoordinates();
        System.out.println(weather.getCurrent());
        System.out.println(weather.getCurrent("temperature"));
        System.out.println(weather.getCurrent("windspeed"));
        System.out.println(coordinates.get());
        System.out.println(coordinates.get("city"));
    }
}
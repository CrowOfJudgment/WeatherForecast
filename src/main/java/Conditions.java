import java.net.MalformedURLException;

public class Conditions {
    Weather weather = Weather.getWeather();
    static final private Conditions CONDITIONS = new Conditions();
    private Conditions(){

    }
    public static Conditions getConditions(){
        return CONDITIONS;
    }
    String getWeatherConditions() throws MalformedURLException {

        return switch (weather.getCurrent("weathercode")) {
            case "0" -> "Clear sky";
            case "1" -> "Mainly clear";
            case "2" -> "Partly cloudy";
            case "3" -> "Overcast";
            case "45" -> "Fog";
            case "48" -> "Rime fog";
            case "51" -> "Light drizzle";
            case "53" -> "Moderate drizzle";
            case "55" -> "Dense drizzle";
            case "56" -> "Light freezing drizzle";
            case "57" -> "Dense freezing drizzle";
            case "61" -> "Slight rain";
            case "63" -> "Moderate rain";
            case "65" -> "Heavy rain";
            case "66" -> "Light freezing rain";
            case "67" -> "Heavy freezing rain";
            case "71" -> "Slight snow fall";
            case "73" -> "Moderate snow fall";
            case "75" -> "Heavy snow fall";
            case "77" -> "Snow grains";
            case "80" -> "Slight rain shower";
            case "81" -> "Moderate rain shower";
            case "82" -> "Violent rain shower";
            case "85" -> "Slight snow shower";
            case "86" -> "Heavy snow shower";
            case "95" -> "Thunderstorm";
            case "96" -> "Thunderstorm with slight hail";
            case "99" -> "Thunderstorm with heavy hail";
            default -> "Unable to determine weather conditions";
        };
    }
}

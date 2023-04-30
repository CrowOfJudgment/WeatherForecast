import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class CurrentWeatherPanel extends JPanel {

    Coordinates coordinates = Coordinates.getCoordinates();
    Conditions conditions = Conditions.getConditions();
    Label temperatureLabel = new Label();
    Label cityLabel = new Label();
    Label windSpeedLabel = new Label();
    Label weatherConditionsLabel = new Label();
    Weather weather = Weather.getWeather();
    int temperature = (int)Math.round(Double.parseDouble(weather.getCurrent("temperature")));
    String city = coordinates.get("city");
    String windSpeed = weather.getCurrent("windspeed");
    CurrentWeatherPanel() throws MalformedURLException {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(830, 200));
        setOpaque(false); // set to false makes the background transparent

        cityLabel.setText(city);
        cityLabel.setFont(new Font("", Font.PLAIN, 20));

        temperatureLabel.setText(temperature + "°C");
        temperatureLabel.setFont(new Font("", Font.PLAIN, 60));

        windSpeedLabel.setText("wind: " + windSpeed + " km/h");

        weatherConditionsLabel.setText(conditions.getWeatherConditions());

        add(new JLabel(" "));
        add(cityLabel);
        add(temperatureLabel);
        add(windSpeedLabel);
        add(weatherConditionsLabel);
    }
}

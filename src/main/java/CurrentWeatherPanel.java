import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class CurrentWeatherPanel extends JPanel {

    Coordinates coordinates = Coordinates.getCoordinates();
    JLabel temperatureLabel = new JLabel();
    JLabel cityLabel = new JLabel();
    Weather weather = Weather.getWeather();
    String temperature = weather.getCurrent("temperature").toString();
    String city = coordinates.get("city").toString();
    CurrentWeatherPanel() throws MalformedURLException {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(830, 300));
        setOpaque(false); // set to false makes the background transparent

        cityLabel.setText(city);
        cityLabel.setFont(new Font("", Font.PLAIN, 20));
        cityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cityLabel.setForeground(Color.WHITE);

        temperatureLabel.setText(temperature + "°C");
        temperatureLabel.setFont(new Font("", Font.PLAIN, 35));
        temperatureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        temperatureLabel.setForeground(Color.WHITE);

        add(new JLabel(" "));
        add(cityLabel);
        add(temperatureLabel);
    }
}

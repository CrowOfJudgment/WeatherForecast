import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class CurrentWeatherPanel extends JPanel {
    JLabel temperatureLabel = new JLabel();
    JLabel cityLabel = new JLabel();
    Weather weather = new Weather();
    String temperature = weather.currentWeather(weather.getWeather(), "temperature").toString();
    String city = Weather.parse(Weather.getCoordinates(),"city").toString();
    CurrentWeatherPanel() throws MalformedURLException {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(830, 300));
        setOpaque(false); // set to false makes the background transparent

        cityLabel.setText(city);
        cityLabel.setFont(new Font("", Font.PLAIN, 20));
        cityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        temperatureLabel.setText(temperature + "°C");
        temperatureLabel.setFont(new Font("", Font.PLAIN, 35));
        temperatureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(new JLabel(" "));
        add(cityLabel);
        add(temperatureLabel);
    }
}

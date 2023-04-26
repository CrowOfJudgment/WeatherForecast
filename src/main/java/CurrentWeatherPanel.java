import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class CurrentWeatherPanel extends JPanel {
    JLabel todayTemperature = new JLabel();
    Weather weather = new Weather();
    String currentTemperature = weather.currentWeather(weather.getWeather(), "temperature").toString();
    CurrentWeatherPanel() throws MalformedURLException {
        setPreferredSize(new Dimension(830, 300));
        setOpaque(false); // set to false makes the background transparent

        todayTemperature.setText(currentTemperature);
        add(todayTemperature);

    }
}

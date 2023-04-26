import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class MainPanel extends JPanel {
    MainPanel() throws MalformedURLException {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        ((FlowLayout) getLayout()).setHgap(10);
        ((FlowLayout) getLayout()).setVgap(10);

        setPreferredSize(new Dimension(850, 630));

        setOpaque(false);

        add(new CurrentWeatherPanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
    }
}

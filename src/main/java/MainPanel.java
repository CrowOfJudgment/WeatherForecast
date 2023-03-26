import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    MainPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        ((FlowLayout) getLayout()).setHgap(10);
        ((FlowLayout) getLayout()).setVgap(10);

        setPreferredSize(new Dimension(850, 630));

        setOpaque(false);

        add(new TodayPanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
    }
}

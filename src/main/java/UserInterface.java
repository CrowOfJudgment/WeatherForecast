import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private JPanel mainPanel;
    Image background;

    UserInterface() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Weatheo");
        add(mainPanel);
        background = new ImageIcon("background.jpg").getImage();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 20, null);
    }
}

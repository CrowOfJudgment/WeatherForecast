import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    ImageIcon background;

    Interface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Weatheo");
        background = new ImageIcon("background_test.jpg");

        JLabel backgroundLabel = new JLabel(background);
        setContentPane(backgroundLabel);

        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridwidth = GridBagConstraints.REMAINDER;

        add(new MainPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

}
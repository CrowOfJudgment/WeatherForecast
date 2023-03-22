import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    Interface(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Weatheo");
        add(new mainPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

}

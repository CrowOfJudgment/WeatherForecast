import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    Label(){
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 15));
    }
}

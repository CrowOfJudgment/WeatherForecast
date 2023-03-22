import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    Image background;
    mainPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        ((FlowLayout)getLayout()).setHgap(10);
        ((FlowLayout)getLayout()).setVgap(10);

        setPreferredSize(new Dimension(850,630));

        //setBackground(Color.BLACK);

        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        add(new TilePanel());
        background = new ImageIcon("background.jpg").getImage();
    }

    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}

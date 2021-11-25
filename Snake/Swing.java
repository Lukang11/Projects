import javax.swing.*;
import java.awt.*;

public class Swing extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,600);
        Panel panel=new Panel();
        frame.add(panel);
        frame.setVisible(true);


    }

}

package Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
public class Treefromscratch {
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Recursive Tree Visual");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            frame.setSize(300, 500);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        });// timing added so you can see

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

    

    
}

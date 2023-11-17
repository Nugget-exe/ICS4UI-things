package Swing;

/* Day 37
Copy of S3 to begin
Adding to S3 a red border
Your task when we finish is to change it to
your colour

  */
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
// add import

public class MsHFrameS4 {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Ms. H Frame S4");

        // Set the frame's size
        frame.setSize(400, 300);

        // Set the close operation to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a purple background color
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 128)); // Purple

        // Create a red border for the panel
        

        // Add the panel to the frame
        frame.add(panel);

        // Create a JLabel with lilac text
        JLabel labelLilac = new JLabel("First Label");
        labelLilac.setForeground(new Color(200, 162, 200)); // Lilac

        // Add the lilac label to the panel
        panel.add(labelLilac);

        // Create a JLabel with blue text
        JLabel labelBlue = new JLabel("Blue Label");
        labelBlue.setForeground(Color.BLUE);

        // Add the blue label to the panel
        panel.add(labelBlue);

        panel.setBorder(new LineBorder(Color.BLUE,2));

        // Make the frame visible
        frame.setVisible(true);
    }// end void main
}// end MsHFrameS4

/*  Day 37 Step 2 - add a label
After we add a label to S1, you have  about 30 seconds to change the label colour to match their colour scheme.

  */

package Swing;
import javax.swing.*;
import java.awt.*;

public class MsHFrameS2 {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Ms. H Frame");

        // Set the frame's size
        frame.setSize(400, 300);

        // Set the close operation to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a purple background color
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 0, 128)); // Purple

        // Add the panel to the frame
        frame.add(panel);

        // Create a JLabel with lilac text

         // Lilac

        // Add the label to the panel
        JLabel label= new JLabel("Label");
        label.setForeground(new Color(200,255,200));

        panel.add(label);
        label.setVisible(true);
        

        // Make the frame visible
        frame.setVisible(true);
    }
}// end

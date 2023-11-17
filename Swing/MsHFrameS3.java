/* Day 37
This is a copy of S2 - we are adding a
label.
After we do, you have 30 seconds to change the 2nd label to your colours.

  */

package Swing;
import javax.swing.*;
import java.awt.*;

public class MsHFrameS3 {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Ms. H Frame");

        // Set the frame's size
        frame.setSize(400, 300);

        // Set the close operation to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a purple background color
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 128)); // Purple

        // Add the panel to the frame
        frame.add(panel);

        // Create a JLabel with lilac text
         // Lilac

        // Add the lilac label to the panel
      

        // Create a JLabel with blue text
       

        // Make the frame visible
    

        JLabel label = new JLabel("Label");
        label.setForeground(Color.RED);
        panel.add(label);
         JLabel labelBlue = new JLabel("FIrst Label");
        labelBlue.setForeground(Color.BLUE);

        // Add the blue label to the panel
        panel.add(labelBlue);
        
        
        frame.setVisible(true);
        
    }// end void main
}// end MsHFrame

/* Day 37 

click OK and you will see the Frame again
Add the dialogue box, you want three options, Yes, No, and QUIT.

Afterward, your task:
Change to your colours, you have about 30 sec.
  */
package Swing;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class MsHFrameS5 {

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

        // Create a red border for the panel
        panel.setBorder(new LineBorder(Color.RED, 2));

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

        // Create and show a white dialogue box
        JOptionPane.showMessageDialog(frame, "White dialogue box", "Message", JOptionPane.INFORMATION_MESSAGE);

        

        // Make the frame visible
        frame.setVisible(true);
    }// end void main
}// end MsHFrame S5

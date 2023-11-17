package Swing;

/*  Add a menu this time
THIS IS A BIG STEP.
This is the Code for S5
After we have added the menu, you have 2 minutes
to change menu option # 1

  */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
// add new imports

public class MsHFrameS6 {

  public static void main(String[] args) {
    // Create a new JFrame
    JFrame frame = new JFrame("Ms. H Frame ");

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

    // Create a JMenuBar (menu bar) with a JMenu (menu)
    JMenuBar Menubar = new JMenuBar();
    JMenu Menu = new JMenu("option");

    // Create JMenuItems (menu items)
    JMenuItem items = new JMenuItem("show dialogue box");
    JMenuItem hidItem = new JMenuItem("hide the box");
    JMenuItem quitItem = new JMenuItem("Quit");

    // Add the menu items to the menu
    Menu.add(items);
    Menu.add(hidItem);
    Menu.add(quitItem);

    // Add the menu to the menu bar
    Menubar.add(Menu);


    // Set the menu bar for the frame
    frame.setJMenuBar(Menubar);

    // ActionListener for the "Show Dialogue Box (Visible)" menu item
items.addActionListener(new ActionListener(){
  public void actionPerform(ActionEvent e){
    JOptionPane.showMessageDialog(frame, "This is a White dialogue box", "Message", JOptionPane.INFORMATION_MESSAGE);


  }
});
    // ActionListener for the "Do Not Show Dialogue Box (Invisible)" menu item
    hidItem.addActionListener(new ActionListener(){
      public void actionPerform(ActionEvent e){
        
    
    
      }
    });


    // ActionListener for the "Quit Program" menu item

    quitItem.addActionListener(new ActionListener(){
      public void actionPerform(ActionEvent e){
        JOptionPane.showMessageDialog(frame, "This is a White dialogue box", "Message", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);//exit program
    
      }
    });
    // }
    // });

    // Make the frame visible
    frame.setVisible(true);
  }
}

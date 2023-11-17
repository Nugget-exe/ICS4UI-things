package Swing;

/* Day 34  radio button addition
Your Task: Change the value of the radio button
You have about 2 minutes to do this and also change the colour to your choice

  */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MsHFrameS9 {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Ms. H Frame S9");

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
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Create JMenuItems (menu items)
        JMenuItem showItem = new JMenuItem("Show Dialogue Box (Visible)");
        JMenuItem hideItem = new JMenuItem("Do Not Show Dialogue Box (Invisible)");
        JMenuItem quitItem = new JMenuItem("Quit Program");

        // Add the menu items to the menu
        menu.add(showItem);
        menu.add(hideItem);
        menu.add(quitItem);

        // Add the menu to the menu bar
        menuBar.add(menu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // ActionListener for the "Show Dialogue Box (Visible)" menu item
        showItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show a white dialogue box
                JOptionPane.showMessageDialog(frame, "This is a white dialogue box.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // ActionListener for the "Do Not Show Dialogue Box (Invisible)" menu item
        hideItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Do nothing, as this option is for demonstration purposes.
            }
        });

        // ActionListener for the "Quit Program" menu item
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program
            }
        });

        // Create a JButton with orange text
        JButton buttonOrange = new JButton("Click Me");
        buttonOrange.setBackground(Color.ORANGE);

        // Add the orange button to the panel
        panel.add(buttonOrange);

        // ActionListener for the orange button
        buttonOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show "Hi" on the screen for 10 seconds
                JOptionPane.showMessageDialog(frame, "Hi", "Message", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Thread.sleep(10000); // Sleep for 10 seconds
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Create a yellow checkbox
        JCheckBox yellowCheckBox = new JCheckBox("Click to Disappear");
        yellowCheckBox.setBackground(Color.YELLOW);

        // Add the yellow checkbox to the panel
        panel.add(yellowCheckBox);

        // ItemListener for the yellow checkbox
        yellowCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    yellowCheckBox.setVisible(false);
                    JOptionPane.showMessageDialog(frame, "You checked the box", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Create a ButtonGroup for radio buttons
        ButtonGroup radioButtonGroup = new ButtonGroup();

        // Create a green radio button for "Quit Now"
      JRadioButton quit = new JRadioButton("Click Me to exit");
      quit.setBackground(Color.GREEN);

      // Add the orange button to the panel
      panel.add(quit);

      

        

        // Add the "Quit Now" radio button to the panel
      radioButtonGroup.add(quit);

      

        // Add the "Quit Now" radio button to the ButtonGroup
/*
      quit
       

        // ItemListener for the "Quit Now" radio button
      quit.addItemListener(new ItemListener(){
        
        public void itemStateChange(ItemEvent e) {
          
          if (e.getStateChange() == ItemEvent.SELECTED) {
            System.exit(0);
          }
          
          

        }
      });

*/
      ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
      };

      quit.addActionListener(al);
          // Exit the program


        // Create a green radio button for "Say BYE"

        JRadioButton sayBYE = new JRadioButton("BYEEEE");



        sayBYE.setForeground(Color.GREEN);

        // Add the "Say BYE" radio button to the panel
        panel.add(sayBYE);

        radioButtonGroup.add(sayBYE);


        // Add the "Say BYE" radio button to the ButtonGroup


        // ItemListener for the "Say BYE" radio button

        sayBYE.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sayBYE.setVisible(false);
                    JOptionPane.showMessageDialog(frame, "BYE", "bye", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

                    

        // Make the frame visible
        frame.setVisible(true);
    }
}

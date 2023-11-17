package Swing;

/*
Basic menu - a template of buttons
Starting point for Student Practice with Graphics

Created Week 9 Sem 1 2023 Ms. Harris ICS4UI class

This is optional:
If you need the practice with graphics please do this.
If you do not need the practice and are finding the graphics we've done for the last 2 days repetitive and boring, simple place your name in the next two lines of this block comment, and state "Do Not Need Graphics Practice" and submit.


Your tasks:
1. Change the purposely UGLY colour scheme to something eye pleasing and easy to read.
2. Put the quit button in the lower right hand side of the screen.
3. Change the Question 1 button to run a bacic program - this can be as simple as a math calculation - you choose and put the result on the screen for the user.
4. Change Question 2 button to ask the user something and allow the user to pick "Yes", "No", or "Unsure" as possible answers to the question.
3. Change Question 3 button to show "something" of your choice in the Black frame.
4. Button 4 will collect user input - possibly a sign in username, day of the week (whatever you want.) to ask.

*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicMenuGUI extends JFrame {

    public BasicMenuGUI() {
        setTitle("Basic Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Main panel with a blue background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLUE);
        mainPanel.setLayout(new BorderLayout());

        // Create a label for instructions
        JLabel label = new JLabel("Please choose an option by clicking the corresponding button:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE); // Set the label text color to white
        mainPanel.add(label, BorderLayout.NORTH);

        // Button panel with green rounded buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        // Create "Question" buttons with green background and red border
        for (int i = 1; i <= 4; i++) {
            JButton questionButton = new JButton("Question " + i);
            questionButton.setBackground(Color.GRAY);
            questionButton.setOpaque(true);
            questionButton.setBorder(BorderFactory.createLineBorder(Color.RED)); // Set a red border
            questionButton.setForeground(Color.WHITE); // Set the button text color to white
            questionButton.addActionListener(new QuestionButtonListener(i));
            buttonPanel.add(questionButton);
        }

        // Create "QUIT" button with a grey background and red border
        JButton quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.GRAY);
        quitButton.setOpaque(true);
        quitButton.setBorder(BorderFactory.createLineBorder(Color.RED)); // Set a red border
        quitButton.setForeground(Color.WHITE); // Set the button text color to white
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(quitButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BasicMenuGUI menu = new BasicMenuGUI();
                menu.setVisible(true);
            }
        });
    }

    private class QuestionButtonListener implements ActionListener {
        private int questionNumber;

        public QuestionButtonListener(int questionNumber) {
            this.questionNumber = questionNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (questionNumber == 1) {
                int num = 1;
                int num1 = 2;
                JOptionPane.showMessageDialog(null, num + " + " + num1 + " is equal to " + (num + num1));

            } else if (questionNumber == 2) {
                String[] options = new String[3];
                options[0] = "YES";
                options[1] = "ew cheese";
                options[2] = "what is cheese";
                int reply = JOptionPane.showOptionDialog(null, "DO YOU LIKE CHEESE", "title", 0,
                        JOptionPane.INFORMATION_MESSAGE, null, options, null);
                // https://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window
                if (options[reply] == "Agree") {
                    JOptionPane.showMessageDialog(null, "you are a cool person");

                } else {
                    JOptionPane.showMessageDialog(null, "Uncool");
                }

            } else if (questionNumber == 3) {
                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setSize(400, 400);
                newFrame.setBackground(Color.BLACK);//dont know why its not black background
                JLabel label = new JLabel("new window who dis");
                newFrame.add(label);

            } else if (questionNumber == 4) {//mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
                String message = JOptionPane.showInputDialog("WHat is todays day?");

                JOptionPane.showMessageDialog(null, "wow it is "+ message + "!");


            }else{//probally shouldve used switch case

                JOptionPane.showMessageDialog(null, "You selected Question " + questionNumber);
            }
            
        }
    }
}

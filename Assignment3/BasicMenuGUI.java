package Assignment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class BasicMenuGUI extends JFrame {

    public BasicMenuGUI() {
        // make the title of the menu and set its size
        setTitle("Basic Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
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

        // Button panel
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new GridLayout(2, 2));

        // Create "Question" buttons
        for (int i = 2; i <= 4; i++) {
            JButton questionButton = new JButton("Question " + i);

            questionButton.setBackground(Color.GRAY);
            questionButton.setOpaque(true);

            // questionButton.setBorder(BorderFactory.createLineBorder(Color.black)); // Set
            // a black border
            questionButton.setForeground(Color.WHITE); // Set the button text color to white
            questionButton.addActionListener(new QuestionButtonListener(i));

            buttonPanel.add(questionButton);
        }

        // Create "QUIT" button with a grey background and red border
        JButton quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.GRAY);
        quitButton.setOpaque(true);
        quitButton.setBorder(BorderFactory.createLineBorder(Color.black)); // Set a red border
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
        double moneycacc = 0.0;
        double moneysav = 0.0;
        private int questionNumber;

        public QuestionButtonListener(int questionNumber) {
            this.questionNumber = questionNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (questionNumber == 2) {

                try {

                    cacc thing = new cacc(0);

                    savings t = new savings(0);

                    // new window code
                    JFrame newframe = new JFrame("Your cool results");
                    JButton quit = new JButton("Click to exit screen");

                    JButton addtocacc = new JButton("Add funds to cheuqing account");
                    JButton addtosavings = new JButton("Add funds to savings account");
                    JButton withdrawcacc = new JButton("take funds from cheuqing account");
                    JButton withdrawsavings = new JButton("take funds from savings account");

                    JButton getcaccint = new JButton("get interest for chequing account");
                    JButton getsavings = new JButton("get interest for savings");

                    newframe.setSize(400, 300);

                    JPanel newlayout = new JPanel();
                    JLabel money = new JLabel("Total money in cheuqing account: "+ moneycacc);
                    JLabel savingsmoney = new JLabel("Total money in savings: "+moneysav);

                    newlayout.setLayout(new BoxLayout(newlayout, BoxLayout.LINE_AXIS)); // https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html

                    JPanel buttonLayout = new JPanel();
                    buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.PAGE_AXIS));

                    newlayout.add(money);
                    newlayout.add(savingsmoney);

                    buttonLayout.add(addtocacc);
                    buttonLayout.add(addtosavings);
                    buttonLayout.add(withdrawcacc);
                    buttonLayout.add(withdrawsavings);

                    buttonLayout.add(getcaccint);
                    buttonLayout.add(getsavings);

                    buttonLayout.add(quit);

                    quit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newframe.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                            newframe.dispose();// we destroy the new jFRAMe

                        }
                    });

                    addtocacc.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                String message = JOptionPane.showInputDialog("Enter amount to add to chequing account");

                                if (message != null) {
                                    double amount = Double.parseDouble(message);
                                    thing.addmoney(amount);
                                   

                                    if (amount >= moneycacc) {
                                        moneycacc += amount;
                                        money.setText("total money in C account "+ Double.toString(moneycacc));

                                    }

                                    
                                    
                                    

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cant do that");

                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");

                            }

                        }
                    });
                    addtosavings.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                String input = JOptionPane.showInputDialog("Enter amount to add to savings account");

                                if (input != null) {
                                    double amt = Double.parseDouble(input);
                                    t.addmoney(amt);

                                    

                                    if (amt >= moneysav) {
                                        moneysav += amt;
                                        savingsmoney.setText("total money in S account "+Double.toString(moneysav));

                                    }
                                    

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cant do that");

                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");

                            }

                        }
                    });

                    withdrawsavings.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                String message = JOptionPane
                                        .showInputDialog("Enter amount withdrawl form saving account");

                                if (message != null) {
                                    double amount = Double.parseDouble(message);
                                    t.takemoners(amount);
                                   

                                    if (amount <= moneysav) {
                                        moneysav-=amount;
                                        savingsmoney.setText("total money in S account "+Double.toString(moneysav));

                                    }
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "cant do that");
                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");

                            }

                        }
                    });

                    getcaccint.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {

                                String messae = JOptionPane.showInputDialog("Enter days to wait for interest");

                                if (messae != null) {
                                    int days = Integer.parseInt(messae);
                                    JOptionPane.showMessageDialog(null,
                                            "Your interest after " + days + " days is " + thing.getinterest(days));

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cant do that");

                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");
                            }

                        }
                    });

                    getsavings.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String messae = JOptionPane.showInputDialog("Enter days to wait for interest");

                                if (messae != null) {
                                    int days = Integer.parseInt(messae);
                                    JOptionPane.showMessageDialog(null,
                                            "Your interest after " + days + " days is " + t.getinterest(days));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cant do that");

                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");

                            }
                        }
                    });

                    withdrawcacc.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                String message = JOptionPane
                                        .showInputDialog("Enter amount withdrawl form cheuqing account");
                                if (message != null) {
                                    double amount = Double.parseDouble(message);
                                    thing.takemoners(amount);
                                    

                                    if (amount <= moneycacc) {
                                        moneycacc-=amount;
                                        money.setText("total money in C account "+Double.toString(moneycacc));


                                    }
                                    

                                } else {
                                    JOptionPane.showMessageDialog(null, "Cant do that");

                                }

                            } catch (NumberFormatException g) {
                                JOptionPane.showMessageDialog(null, "Cant do that");
                            }

                        }
                    });

                    

                    
                    newframe.add(newlayout, BorderLayout.PAGE_END);
                    newframe.add(buttonLayout, BorderLayout.CENTER);

                    newframe.setVisible(true);

                } catch (NumberFormatException h) {
                    JOptionPane.showMessageDialog(null, "Can't do that");
                }

                /*
                 * String[] options = new String[3];
                 * options[0] = "YES";
                 * options[1] = "ew cheese";
                 * options[2] = "what is cheese";
                 * int reply = JOptionPane.showOptionDialog(null, "DO YOU LIKE CHEESE", "title",
                 * 0,
                 * JOptionPane.INFORMATION_MESSAGE, null, options, null);
                 * // https://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window
                 * if (options[reply] == "Agree") {
                 * JOptionPane.showMessageDialog(null, "you are a cool person");
                 * 
                 * } else {
                 * JOptionPane.showMessageDialog(null, "Uncool");
                 * }
                 */

            } else if (questionNumber == 3) {
                HashMap<Integer, ArrayList<Integer>> adjj = new HashMap<>();
                try {
                    String startnode = JOptionPane.showInputDialog("Enter start node");
                    int start = Integer.parseInt(startnode);
                    String timesToLoop = JOptionPane.showInputDialog("Enter amount of lines you want to input next");
                    int amtTimes = Integer.parseInt(timesToLoop);

                    for (int i = 0; i < amtTimes; i++) {
                        String node = JOptionPane.showInputDialog("Enter a node");
                        int Node = Integer.parseInt(node);
                        String connectedNode = JOptionPane.showInputDialog("Enter node connected to previous node");
                        int cNode = Integer.parseInt(connectedNode);

                        adjj.putIfAbsent(Node, new ArrayList<>());
                        adjj.get(Node).add(cNode);
                        adjj.putIfAbsent(cNode, new ArrayList<>());
                        adjj.get(cNode).add(Node);
                    }

                    boolean[] Visited = new boolean[adjj.size() + 1];
                    int[] dist = new int[adjj.size() + 1];

                    for (int o = 0; o < Visited.length; o++) {
                        Visited[o] = false;

                    }

                    for (int l = 0; l < dist.length; l++) {
                        dist[l] = -1;

                    }

                    Visited[start] = true;

                    recursion.dfs(start, adjj, Visited, dist);

                    JOptionPane.showMessageDialog(null, Arrays.toString(dist), "Distance", 1);

                    boolean[] vis = new boolean[adjj.size() + 1];

                    for (int node = 1; node < adjj.size() + 1; node++) {
                        if (vis[node] == false) {
                            recursion.findcycle(node, -1, adjj, vis);
                        }

                    }

                    JFrame outputFrame = new JFrame("results");
                    outputFrame.setSize(300, 300);
                    outputFrame.setVisible(true);

                    JButton exit = new JButton("Exit");

                    JLabel info = new JLabel("Nodes traversed: " + recursion.nodestraversed);

                    outputFrame.add(info, BorderLayout.NORTH);
                    outputFrame.add(exit, BorderLayout.PAGE_END); // https://stackoverflow.com/questions/40420669/how-do-i-create-a-new-jframe
                    // and
                    // https://stackoverflow.com/questions/19572390/button-in-java-jframe-will-not-resize
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            outputFrame.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                            outputFrame.dispose();// wedestroy the new jFRAMe
                            recursion.nodestraversed.clear();// clear arraylist
                        }
                    });

                } catch (NumberFormatException h) {
                    JOptionPane.showMessageDialog(null, "you cant do that run question 3 again");

                } catch (ArrayIndexOutOfBoundsException h) {
                    JOptionPane.showMessageDialog(null, h);
                }

                /*
                 * JFrame newFrame = new JFrame();
                 * newFrame.setVisible(true);
                 * newFrame.setSize(400, 400);
                 * newFrame.setBackground(Color.BLACK);//dont know why its not black background
                 * JLabel label = new JLabel("new window who dis");
                 * newFrame.add(label);
                 * 
                 */

            } else if (questionNumber == 4) {// mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
                //things
                try {
                    File file = new File("C:\\Users\\Henry\\.vscode\\ICS4UI things\\Assignment3\\1000record.csv");
                    Scanner filescanner = new Scanner(file);
                    if (filescanner.hasNextLine()) {// skip the header line
                        filescanner.nextLine();
        
                    }
                    
                    filescanner.close();
                    

                } catch (FileNotFoundException f) {
                    f.printStackTrace();

                }

                
                



            } else {// probally shouldve used switch case

                JOptionPane.showMessageDialog(null, "You selected Question " + questionNumber);
            }

        }
    }
}

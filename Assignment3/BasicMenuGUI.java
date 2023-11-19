package Assignment3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
/* 
Problem:
 * Uhhh idk tbh
 * We want to showcase our fancy sorts and how long they take for sorting a 1000 record csv, and along with that, show an example of recursion which accepts user input, and also show an example of poly morphrism(has buttons)
 * 


Given: I forgot  Due: Nov 20, 2023(Given extension)

Testcases:
-tried not putting the csv path in file
- put in a string when it asked for a int
- entered negative numbers in the bank account example
- entered an index that does not exist
-entered null fields
-

Author: Henry Lin
Citations will be in code
*/

public class BasicMenuGUI extends JFrame {

    public BasicMenuGUI() {
        // make the title of the menu and set its size
        setTitle("Basic Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);//set the size
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
                    JLabel money = new JLabel("Total money in cheuqing account: " + moneycacc);
                    JLabel savingsmoney = new JLabel("Total money in savings: " + moneysav);

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
                                        money.setText("total money in C account " + Double.toString(moneycacc));

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
                                        savingsmoney.setText("total money in S account " + Double.toString(moneysav));

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
                                        moneysav -= amount;
                                        savingsmoney.setText("total money in S account " + Double.toString(moneysav));

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
                                        moneycacc -= amount;
                                        money.setText("total money in C account " + Double.toString(moneycacc));

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
                    JLabel moreinfo = new JLabel("Nodes with cycles "+ recursion.cycledetected);

                    outputFrame.add(info, BorderLayout.NORTH);
                    outputFrame.add(moreinfo);
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
                JFrame newFrame = new JFrame("this is a new frame");

                JButton quitbutton = new JButton("Click here to go back to main menu");
                /*
                 * JPanel panel = new JPanel();
                 * panel.setBounds(0, 0, 900, 900);
                 * JTable jtable = new JTable();// use this to display CSV
                 * JScrollPane scroll = new JScrollPane(jtable);
                 * panel.add(scroll);
                 * newFrame.add(panel);
                 */
                String[] row = new String[9];
                newFrame.setSize(800, 800);

                // things
                try {
                    File file = new File("Assignment3\\1000record.csv");
                    Scanner filescanner = new Scanner(file);

                    if (filescanner.hasNextLine()) {
                        filescanner.nextLine();

                    }

                    ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();//make a temp array called array to be converted later on

                    while (filescanner.hasNextLine()) {
                        int i = 0;
                        String line = filescanner.nextLine();
                        String[] parts = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");// https://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split/15905916#15905916

                        if (parts.length == 9) {
                            /*
                             * String Userif = parts[1].trim();
                             * String FName = parts[2].trim();
                             * String LName = parts[3].trim();
                             * String sex = parts[4].trim();
                             * String Email = parts[5].trim();
                             * String Phone = parts[6].trim();
                             * String DoB = parts[7].trim();
                             * String job = parts[8].trim();
                             */
                            ArrayList<String> values = new ArrayList<String>();//temp arraylist to add contents of each line to the arraylist

                            Collections.addAll(values, parts);// do this to add parts to values

                            array.add(values);// no need to explain here


                        }
                    }
                    // converting arraylist to array
                    String[][] newarray = new String[array.size()][9];
                    for (int i = 0; i < array.size(); i++) {
                        for (int j = 0; j < array.get(i).size(); j++) {
                            newarray[i][j] = array.get(i).get(j);
                        }

                    }
                    //column names
                    String[] col = { "index", "UserID", "Fname", "LName", "Sex", "Email", "phone", "DoB", "job" };
                    System.out.println(Arrays.deepToString(newarray));// debugging too lazy to get rid of

                    String[] choices = new String[4];// this is used for JOptionPane choices

                    choices[0] = "mergeSort";
                    choices[1] = "Quicksort";
                    choices[2] = "Bubblesort";
                    choices[3] = "Selectionsort"; 
                    // listed choices

                    int reply = JOptionPane.showOptionDialog(null, "What sort to perform?",
                            "Sort selection(rerun to choose another)", 0,
                            JOptionPane.INFORMATION_MESSAGE, null, choices, null);
                    // Switch case based on the value of button pressed
                    switch (reply) {
                        case 0:
                            try {// put in try catch statment to catch arrayindex out of bounds erro and numberformatexceptions(too lazy to comment other near identical blocks)
                                int message = Integer
                                        .parseInt(JOptionPane.showInputDialog("Enter a column index to sort"));
                                long startTimeMerge = System.nanoTime();
                                Searchandsort.mergesort(newarray, 0, newarray.length - 1, message);
                                long endTimeMerge = System.nanoTime();

                                JOptionPane.showMessageDialog(null,
                                        "your sort took " + (endTimeMerge - startTimeMerge) + " nanoseconds(a small number).");

                            } catch (ArrayIndexOutOfBoundsException h) {
                                JOptionPane.showMessageDialog(null, "Index out of bounds error try again");
                                ;
                            } catch (NumberFormatException h ) {
                                JOptionPane.showMessageDialog(null, "TYPE IN A NUMBER PLEASE I JUST WANT TO GO TO UW AAAAAAAAAAAA");
                                JOptionPane.showMessageDialog(null, "BTW rerun the question again to get the sorted CSV");
                            }
                            break;
                        case 2:
                            try {
                                int message = Integer
                                        .parseInt(JOptionPane.showInputDialog("Enter a column index to sort"));
                                long startTimeB = System.currentTimeMillis();
                                Searchandsort.bubbleSort(newarray, message);
                                long endTimeB = System.currentTimeMillis();

                                JOptionPane.showMessageDialog(null,
                                        "your sort took " + (endTimeB - startTimeB) + " seconds.");

                            } catch (ArrayIndexOutOfBoundsException h) {
                                JOptionPane.showMessageDialog(null, "Index out of bounds error try again");
                                ;
                            } catch (NumberFormatException h ) {
                                JOptionPane.showMessageDialog(null, "TYPE IN A NUMBER PLEASE I JUST WANT TO GO TO UW AAAAAAAAAAAA");
                                JOptionPane.showMessageDialog(null, "BTW rerun the question again to get the sorted CSV");
                            }
                            break;

                        case 1:// out of order cuz i did a funny
                            try {
                                int message = Integer
                                        .parseInt(JOptionPane.showInputDialog("Enter a column index to sort"));
                                long startTimeq = System.nanoTime();
                                Searchandsort.quickSort(newarray, 0, newarray.length - 1, message);
                                long endTimeq = System.nanoTime();

                                JOptionPane.showMessageDialog(null,
                                        "your sort took " + (endTimeq - startTimeq) + " nanoseconds.");

                            } catch (ArrayIndexOutOfBoundsException h) {
                                JOptionPane.showMessageDialog(null, "Index out of bounds error try again");
                                ;
                            } catch (NumberFormatException h ) {
                                
                                JOptionPane.showMessageDialog(null, "TYPE IN A NUMBER PLEASE I JUST WANT TO GO TO UW AAAAAAAAAAAA");
                                JOptionPane.showMessageDialog(null, "BTW rerun the question again to get the sorted CSV");
                            }
                            break;

                        case 3:
                            try {
                                int message = Integer
                                        .parseInt(JOptionPane.showInputDialog("Enter a column index to sort"));
                                long startTimeS = System.currentTimeMillis();
                                Searchandsort.selectionSort(newarray, message);
                                long endTimeS = System.currentTimeMillis();

                                JOptionPane.showMessageDialog(null,
                                        "your sort took " + (endTimeS - startTimeS) + " seconds.");

                            } catch (ArrayIndexOutOfBoundsException h) {
                                JOptionPane.showMessageDialog(null, "Index out of bounds error try again");
                                ;
                            } catch (NumberFormatException h ) {
                                JOptionPane.showMessageDialog(null, "TYPE IN A NUMBER PLEASE I JUST WANT TO GO TO UW AAAAAAAAAAAA");
                                JOptionPane.showMessageDialog(null, "BTW rerun the question again to get the sorted CSV");
                            }
                            break;
    
                        
                        default:
                        JOptionPane.showMessageDialog(null, "exit this JFrame and rerun to rerun the sort");

                    }

                    // JPanel panel = new JPanel();
                    // panel.setBounds(0, 0, 900, 900);
                    JTable jtable = new JTable(newarray, col);// use this to display CSV
                    JScrollPane scroll = new JScrollPane(jtable);// add scrolling

                    // jtable.add(scroll);

                    newFrame.add(quitbutton, BorderLayout.PAGE_END);
                    JButton search = new JButton("Search for a thing");
                    newFrame.add(search, BorderLayout.PAGE_START);

                    quitbutton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newFrame.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                            newFrame.dispose();// wedestroy the new jFRAMe

                        }
                    });

                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String thingToSearch = JOptionPane.showInputDialog("Enter String value to search(in the column you sorted)");
                                String intotparse = JOptionPane.showInputDialog("Enter column index");
                                int cindex = Integer.parseInt(intotparse);

                                int[] theanswer = Searchandsort.Search2D(newarray, thingToSearch, cindex);

                                JOptionPane.showMessageDialog(null, "Item found at " + Arrays.toString(theanswer));

                            } catch (Exception h) {// when ur unsure of exception to throw put an generic exception
                                                   // block
                                JOptionPane.showMessageDialog(null, "Something weird happened please try again");

                            }

                        }
                    });

                    newFrame.add(scroll);
                    newFrame.setVisible(true);

                    // panel.add(scroll);
                    // newFrame.add(panel);

                    filescanner.close();

                } catch (FileNotFoundException f) {
                    JOptionPane.showMessageDialog(null, "cant find file please try again");

                }

            } else {// probally shouldve used switch case

                JOptionPane.showMessageDialog(null, "You selected Question " + questionNumber);
            }

        }
    }
}

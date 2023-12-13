
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


/* 
Problem:
 * Uhhh idk tbh
 * We want to showcase our fancy sorts and how long they take for sorting a 1000 record csv, and along with that, show an example of recursion which accepts user input, and also show an example of poly morphrism(has buttons)
 * and make a GUI to showcase everything.   


Given: I forgot  Due: Nov 20, 2023(Given extension)

Testcases:
-tried not putting the csv path in file: program did not crash, outputted JOptionpane
-put in a string when it asked for a int did nto crash
-entered negative numbers in the bank account example did not add negative money
-entered an index that does not exist for csv/recursion
-entered null fields
-entered invalid numbers
-withdrawn invalid amounts
-searched for a non existant node
-typed in a string for searching nodes

Instructions: follow on screen inctructions lol




Author: Henry Lin
Citations will be in code
*/
public class tester extends JFrame {

    public BasicMenuGUI() {
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
        //buttonPanel.setLayout(new GridLayout(2, 2));
      

        // Create "Question" buttons 
        for (int i = 2; i <= 4; i++) {
            JButton questionButton = new JButton("Question " + i);
    
            questionButton.setBackground(Color.GRAY);
            questionButton.setOpaque(true);
            
            //questionButton.setBorder(BorderFactory.createLineBorder(Color.black)); // Set a black border
            questionButton.setForeground(Color.WHITE); // Set the button text color to white
            questionButton.addActionListener(new QuestionButtonListener(i));

          
          
            buttonPanel.add(questionButton);
        }

        // Create "QUIT" button with a grey background
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
        private int questionNumber;
        double moneycacc = 0.0;
       double moneysav = 0.0;

        public QuestionButtonListener(int questionNumber) {
            this.questionNumber = questionNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

          
            if (questionNumber == 2) {
              try {

                cacc thing = new cacc(0);//make new c and savings account
                savings t = new savings(0);

                //new window code
                JFrame newframe = new JFrame("Your cool results");
                JButton quit = new JButton("Exit to main screen");
                JButton addtocacc = new JButton("Add funds to chequing account");

                JButton addtosavings = new JButton("Add funds to savings account");

                JButton withdrawcacc = new JButton("Take funds from chequing account");

                JButton withdrawsavings = new JButton("Take funds from savings account");

                JButton getcaccint = new JButton("get interest for chequing account");

                JButton getsavings = new JButton("get interest for savings account");

                newframe.setSize(400,300);

                JPanel newlayout = new JPanel();

                //make labels for money in accounts

                JLabel money = new JLabel("Total money in chequing account: ");

                JLabel savingsmoney = new JLabel("Total money in savings: ");

                newlayout.setLayout(new BoxLayout(newlayout, BoxLayout.LINE_AXIS));

                JPanel buttonLayout = new JPanel();
                buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.PAGE_AXIS));

                //add labels to new layout and buttons to button layout

                newlayout.add(money);
                newlayout.add(savingsmoney);

                buttonLayout.add(addtocacc);
                buttonLayout.add(addtosavings);
                buttonLayout.add(withdrawcacc);
                buttonLayout.add(withdrawsavings);
                buttonLayout.add(getcaccint);
                buttonLayout.add(getsavings);
                buttonLayout.add(quit);

                //inplement action listeners to buttons
                quit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newframe.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                        newframe.dispose();// we destroy the new jFRAMe

                    }
                });


                //this applies to most buttons, where button pressed asks user for input and puts it in a try statement that catches errors

                addtocacc.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    try {
                      String Message  = JOptionPane.showInputDialog(null, "Enter amount to add");
                      if (Message != null) {
                        double amount = Double.parseDouble(Message);
                        thing.addmoney(amount);

                        //if number is greater than or equal to current amount in account

                        if (amount >= moneycacc) {
                          moneycacc+=amount;
                          money.setText("Total money in C acc " + Double.toString(moneycacc));
                          
                        }
                        
                      } else {//print error
                        JOptionPane.showMessageDialog(null, "Cannot do that");
                      }
                  
                      
                    }catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");
                      
                    }
                  }
                });


                addtosavings.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    try {
                      String Message  = JOptionPane.showInputDialog(null, "Enter amount to add");
                      if (Message != null) {
                        double amount = Double.parseDouble(Message);
                        t.addmoney(amount);

                        //if number is greater than or equal to current amount in account

                        if (amount >= moneysav) {
                          moneysav+=amount;
                          savingsmoney.setText("Total money in savings acc " + Double.toString(moneysav));

                        }

                      } else {//print error
                        JOptionPane.showMessageDialog(null, "Cannot do that");
                      }


                    }catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");

                    }
                  }
                });
                //almost same logic as above but this time you're removing money
                withdrawcacc.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    try {
                      String Message  = JOptionPane.showInputDialog(null, "Enter amount to take");
                      if (Message != null) {
                        double amount = Double.parseDouble(Message);
                        thing.takemoners(amount);

                      
                        
                        if (amount <= moneycacc && amount >0) {
                          moneycacc-=amount;
                          money.setText("Total money in C acc " + Double.toString(moneycacc));

                        }

                      } else {//print error
                        JOptionPane.showMessageDialog(null, "Cannot do that");
                      }


                    }catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");

                    }
                  }
                });

                withdrawsavings.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    try {
                      String Message  = JOptionPane.showInputDialog(null, "Enter amount to take");
                      if (Message != null) {
                        double amount = Double.parseDouble(Message);
                        t.takemoners(amount);



                        if (amount <= moneysav && amount >0) {
                          moneysav-=amount;
                          savingsmoney.setText("Total money in savings acc " + Double.toString(moneysav));

                        }

                      } else {//print error
                        JOptionPane.showMessageDialog(null, "Cannot do that");
                      }


                    }catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");

                    }
                  }
                });

                getcaccint.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {

                    try {
                      String message = JOptionPane.showInputDialog("Enter days to wait for interest");
                      if (message != null) {
                          int days = Integer.parseInt(message);

                          if (days >= 0) {
                              JOptionPane.showMessageDialog(null,
                                      "Your interest after " + days + " days is " + thing.getinterest(days));

                          }

                          else {
                              JOptionPane.showMessageDialog(null, "Cant do that");

                          }

                      } else {
                          JOptionPane.showMessageDialog(null, "Cant do that");

                      }
                    } catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");
                    } 
                    
                  }
                });

                getsavings.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {

                    try {
                      String message = JOptionPane.showInputDialog("Enter days to wait for interest");
                      if (message != null) {
                          int days = Integer.parseInt(message);

                          if (days >= 0) {
                              JOptionPane.showMessageDialog(null,
                                      "Your interest after " + days + " days is " + t.getinterest(days));

                          }

                          else {
                              JOptionPane.showMessageDialog(null, "Cant do that");

                          }

                      } else {
                          JOptionPane.showMessageDialog(null, "Cant do that");

                      }
                    } catch (NumberFormatException g) {
                      JOptionPane.showMessageDialog(null, "ENTER A NUMBER");
                    } 

                  }
                });

                newframe.add(newlayout, BorderLayout.PAGE_END);
                newframe.add(buttonLayout, BorderLayout.CENTER);
                newframe.setVisible(true);


                

                

                
                
              } catch (NumberFormatException h) {
                JOptionPane.showMessageDialog(null, "dont type a string");
              }
              



            } else if (questionNumber == 3) {
              HashMap<Integer, ArrayList<Integer>> adjj = new HashMap<>();
              try {
                String startnode = JOptionPane.showInputDialog("Enter start node");
                int start = Integer.parseInt(startnode);
                String timesToLoop = JOptionPane.showInputDialog("Enter amount of lines you want to input next");
                int amtTimes = Integer.parseInt(timesToLoop);

                for (int i=0;i<amtTimes;i++) {
                  String node = JOptionPane.showInputDialog("Enter a node");
                  int Node = Integer.parseInt(node);
                  String connectedNode = JOptionPane.showInputDialog("Enter node connected to previous node");
                  int cNode = Integer.parseInt(connectedNode);

                  adjj.putIfAbsent(Node, new ArrayList<>());
                  adjj.get(Node).add(cNode);
                  adjj.putIfAbsent(cNode, new ArrayList<>());
                  adjj.get(cNode).add(Node);            
                }

                boolean[] Visited = new boolean[adjj.size()+1];
                int[] dist = new int[adjj.size()+1];

                for (int o=0; o<Visited.length;o++) {
                  Visited[o] = false;
                  
                }

                for (int l = 0;l<dist.length;l++) {
                  dist[l]=-1;
                  
                }

                Visited[start] = true;

                recursion.dfs(start, adjj, Visited, dist);

                JOptionPane.showMessageDialog(null, Arrays.toString(dist), "Distance",1);

                boolean[] vis = new boolean[adjj.size()+1];

                try {
                  // for each node in the ajacency list
                  for (int node = 1; node < adjj.size() + 1; node++) {
                      // if the current node is not visited and running findcycle func returns true(we
                      // have a cycle)
                      if (!vis[node] && recursion.findcycle(node,-1,adjj,vis)) {

                          // add occurance of cycle detected to the cycle detected public arraylist
                          recursion.cycledetected.add("Cycle detected at: " + node);

                      }

                  }
                  
                } catch (NullPointerException h) {
                  JOptionPane.showMessageDialog(null, "you typed a start node other than 1, try again");

                }

                JFrame outputFrame = new JFrame("results");//make results frame
                outputFrame.setSize(600,300);//set the size of the frame
                outputFrame.setVisible(true);//make frame visible

                JButton exit = new JButton("Exit");//make exit button
                JButton finddist = new JButton("Find distance frmo start node");

                JLabel info = new JLabel("Nodes travered: "+recursion.nodestraversed);//show Info label
                JLabel moreinfo = new JLabel("Nodes with cycle "+ recursion.cycledetected);

                JLabel nodesinfo = new JLabel("Current graph in adj list form: "+ adjj);

                outputFrame.add(finddist, BorderLayout.PAGE_START);//add search button to top of page

                JPanel InfoLayout = new JPanel();//make a new layout

                InfoLayout.setLayout(new BoxLayout(InfoLayout, BoxLayout.PAGE_AXIS));//align info labels to page axis

                InfoLayout.add(info);//add info things to layout

                InfoLayout.add(moreinfo);
                InfoLayout.add(nodesinfo);

                outputFrame.add(InfoLayout);
                outputFrame.add(exit, BorderLayout.PAGE_END);

                exit.addActionListener(new ActionListener() {//add action listener to exit button
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        outputFrame.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                        outputFrame.dispose();// wedestroy the new jFRAMe
                        recursion.nodestraversed.clear();// clear arraylist
                        recursion.cycledetected.clear();
                    }
                });


                //find distance action Listener

                finddist.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) { 
                  try {
                    //user input is parsed
                    int inttosearch = Integer.parseInt(JOptionPane.showInputDialog("Enter number to search, hope you did it in ascending order from 1 to n"));
                    if (inttosearch>1&&inttosearch<=dist.length) {
                      int distance = dist[inttosearch] +1;// distance is equal to dist[index]+1
                      if (distance >= 1) {//if ditance greater than or equal to 1
                        JOptionPane.showMessageDialog(null, "distance from start node to target node is " + distance);
                        
                      } else {//print if distance is -1
                        JOptionPane.showMessageDialog(null,"Node is unreachable i think");
                        
                      }
                    } else {//error 
                      JOptionPane.showMessageDialog(null, "Cannot do that please try again");
                    }
                    
                  }catch (ArrayIndexOutOfBoundsException h) {//you did a funny
                    JOptionPane.showMessageDialog(null, "You tried to do something bad >:(");
                    
                  } catch (NumberFormatException h ) {// you typed a string
                    JOptionPane.showMessageDialog(null, "ENTER A NUMBER");
                    
                  }
                  }   
                });
                


                

                

                

                
                
                
  
                
              }catch (NumberFormatException h){
                JOptionPane.showMessageDialog(null, h);
                
              }catch (ArrayIndexOutOfBoundsException h) {
                JOptionPane.showMessageDialog(null, h);
              }catch (NullPointerException h ){
                JOptionPane.showMessageDialog(null, h);
                
              }

              /*
                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setSize(400, 400);
                newFrame.setBackground(Color.BLACK);//dont know why its not black background
                JLabel label = new JLabel("new window who dis");
                newFrame.add(label);

              */

            } else if (questionNumber == 4) {//mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
                JFrame newframe = new JFrame("Your cool results");
                JButton quit = new JButton("Click to exit screen");

                newframe.setSize(800,800);
                JOptionPane.showMessageDialog(null,
                "If you make a mistake in choosing the col to sort by the csv will appear unsorted(you will be unable to search for anything but the index col)");        
              try {
                File file = new File("GIANTFILE.csv");
                Scanner filescanner = new Scanner(file);
                if (filescanner.hasNextLine()) {
                  filescanner.nextLine();
                  
                }

                ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();// make a temp array called
                while (filescanner.hasNextLine()) {
                String line = filescanner.nextLine();
                String[] parts = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");// https://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split/15905916#15905916

                if (parts.length == 9) {

                  ArrayList<String> values = new ArrayList<String>();

                  Collections.addAll(values, parts);

                  array.add(values);
                  
                }

                
              }

              String[][] newarray = new String[array.size()][9];
              
              for (int i=0; i<array.size(); i++) {
                for (int j =0; j < array.get(i).size(); j++) {
                  newarray[i][j] = array.get(i).get(j);
                  
                }
                
              }

              //column names

              String[] col = {"index", "UserID", "fNAME", "LName", "Sex", "Email", "phone", "DoB", "Job"};
              String[] choices = new String[4];//used for choices in joption

              choices[0] = "mergeSort";  
              choices[1] = "Quicksort";
              choices[2] = "Bubblesort";
              choices[3] = "Selectionsort";


              int reply = JOptionPane.showOptionDialog(null, "What sort to perform", "Sort selection, rerun to select another", 0, JOptionPane.INFORMATION_MESSAGE, null, choices, null);

              //switch case based on value of button pressed

              switch (reply) {
                case 0 :
                  try {
                    //put in try catch statement to catch arrayindexoutof bounds or number format exceptions(too lazy to comment other cases)
                    int message = Integer.parseInt(JOptionPane.showInputDialog("Enter a column to sort(col u sort-1)"));
                    long startTimeMerge = System.nanoTime();//get curr time in nanosecs
                    Searchandsort.mergesort(newarray, 0, newarray.length -1, message);

                    long endTimeMerge = System.nanoTime();//get time after sort in Nano secs

                    //print time
                    JOptionPane.showMessageDialog(null,
                      "your sort took " + (endTimeMerge - startTimeMerge)
                              + " nanoseconds(a small number).");
                    
                  } catch (ArrayIndexOutOfBoundsException h ) {

                    JOptionPane.showMessageDialog(null, "Index out of bounds error try again");
                    
                    
                  } catch (NumberFormatException h){
                    JOptionPane.showMessageDialog(null,
                      "TYPE IN A NUMBER PLEASE");
                    JOptionPane.showMessageDialog(null,
                      "BTW rerun the question again to get the sorted CSV");
                  }break;

                case 1 :
                  try {
                    //put in try catch statement to catch arrayindexoutof bounds or number format exceptions(too lazy to comment other cases)
                    int message = Integer.parseInt(JOptionPane.showInputDialog("Enter a column to sort(col u sort-1)"));
                    long startTimeq = System.nanoTime();//get curr time in nanosecs
                    Searchandsort.quickSort(newarray, 0, newarray.length -1, message);

                    long endTimeq = System.nanoTime();//get time after sort in Nano secs

                    //print time
                    JOptionPane.showMessageDialog(null,
                      "your sort took " + (endTimeq - startTimeq)
                              + " nanoseconds(a small number).");

                  } catch (ArrayIndexOutOfBoundsException h ) {

                    JOptionPane.showMessageDialog(null, "Index out of bounds error try again");


                  } catch (NumberFormatException h){
                    JOptionPane.showMessageDialog(null,
                      "TYPE IN A NUMBER PLEASE");
                    JOptionPane.showMessageDialog(null,
                      "BTW rerun the question again to get the sorted CSV");
                  }break;

                case 2 :
                  try {
                    //put in try catch statement to catch arrayindexoutof bounds or number format exceptions(too lazy to comment other cases)
                    int message = Integer.parseInt(JOptionPane.showInputDialog("Enter a column to sort(col u sort-1)"));
                    long startTimeB = System.nanoTime();//get curr time in nanosecs
                    Searchandsort.bubbleSort(newarray, message);

                    long endTimeB = System.nanoTime();//get time after sort in Nano secs

                    //print time
                    JOptionPane.showMessageDialog(null,
                      "your sort took " + (endTimeB - startTimeB)
                              + " nanoseconds(a small number).");

                  } catch (ArrayIndexOutOfBoundsException h ) {

                    JOptionPane.showMessageDialog(null, "Index out of bounds error try again");


                  } catch (NumberFormatException h){
                    JOptionPane.showMessageDialog(null,
                      "TYPE IN A NUMBER PLEASE");
                    JOptionPane.showMessageDialog(null,
                      "BTW rerun the question again to get the sorted CSV");
                  }break;

                case 3 :
                  try {
                    //put in try catch statement to catch arrayindexoutof bounds or number format exceptions(too lazy to comment other cases)
                    int message = Integer.parseInt(JOptionPane.showInputDialog("Enter a column to sort(col u sort-1)"));
                    long startTimeS = System.nanoTime();//get curr time in nanosecs
                    Searchandsort.selectionSort(newarray, message);

                    long endTimeS = System.nanoTime();//get time after sort in Nano secs

                    //print time
                    JOptionPane.showMessageDialog(null,
                      "your sort took " + (endTimeS - startTimeS)
                              + " nanoseconds(a small number).");

                  } catch (ArrayIndexOutOfBoundsException h ) {

                    JOptionPane.showMessageDialog(null, "Index out of bounds error try again");


                  } catch (NumberFormatException h){
                    JOptionPane.showMessageDialog(null,
                      "TYPE IN A NUMBER PLEASE");
                    JOptionPane.showMessageDialog(null,
                      "BTW rerun the question again to get the sorted CSV");
                  }break;

                default:
                  JOptionPane.showMessageDialog(null, "exit this JFrame and rerun to rerun the sort");

                  



              }


              JTable jtable = new JTable(newarray, col);//do this to display csv

              JScrollPane scroll = new JScrollPane(jtable);//add scrolling to the jtable
              newframe.add(quit, BorderLayout.PAGE_END);
             

              JButton search =new JButton("Search for a thing");
              newframe.add(search, BorderLayout.PAGE_START);

              quit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  newframe.setVisible(false);// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                  newframe.dispose();//destroy jframe
                }
              });

              search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  try {
                    String thingToSearch = JOptionPane.showInputDialog("Enter a String to search");
                    String intoparse=JOptionPane.showInputDialog(null, "Enter column index to search");

                    int cindex = Integer.parseInt(intoparse);//parse col value

                    int[] theanswer = Searchandsort.Search2D(newarray, thingToSearch, cindex);
                    JOptionPane.showMessageDialog(null, "item found at "+Arrays.toString(theanswer));//either you found it or it returns -1,-1(you didnt find it)

                    
                    
                    
                  } catch (Exception h) {
                    //when in doubt put a generic exception catch          
                    JOptionPane.showMessageDialog(null, "Something weird happened try again");
                  }
                }
              });

                newframe.add(scroll);
                newframe.setVisible(true);

                filescanner.close();

                
              
              

                
                
              } catch(FileNotFoundException f) {
                JOptionPane.showMessageDialog(null, "cant find file please try again");

                
              }

              

            }else{//probally shouldve used switch case

                JOptionPane.showMessageDialog(null, "You selected Question " + questionNumber);
            }

        }
    }
}

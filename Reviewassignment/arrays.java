
package Reviewassignment;
/*
 * Problem:
 * 2D Array. Create a problem and solution that uses a multi-dimensional array with
error checking, and at least 5 different results from your array. You must have
at least 15 or more records for your array to make sense, and also our results.


Given: Sep. 25/23 Due: Oct 4/23
Typical results could be sum, average, sorting, rotation, min & max, specific
numbers or results will be determined by what your array is. Use your
discretion. Your user input and results (print to console) must be reasonable with
no errors.
problem: our store is too complex so customers demanded a inventory system using 2d arrays. the arrays will have 5 characteristics with item[0][0] being the first item with a identifier at [0]
Test cases:typed in wrong input
made array contents bad

Author: Henry Lin
Citations will be in code

Sources: https://stackoverflow.com/questions/15855154/two-dimensional-arraylist-set-an-element
 */

import java.util.ArrayList;
//import libarieissssss
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        String[] Itemdescription = { "name", "itempopular?", "Orders", "characteristics", "stock" };// list product list
                                                                                                    // thing(index
                                                                                                    // related)

        String[][] Itemsinstore = {
                { "duck tape", "hot item", "2000", "grey", "25" },
                { "spoons", "unpopular", "1500000", "silver", "1" },
                { "balls", "hot item", "2000000000", "round", "10000000" },
                { "socks", "unpopular", "1", "sock", "0" },
                { "soap", "unpopular", "0", "white", "0" },
                { "mr piche", "hot item", "99999", "gold", "1" },
                { "allen", "hot item", "0", "pink", "34" },
                { "henry lin", "unpopular", "0", "coder", "1" },
                { "sus among us meme", "hot item", "1000000", "red", "0" }
        };

        ArrayList<ArrayList<String>> Itemtobeadded = new ArrayList<ArrayList<String>>();// create a 2d array list that CAN BE CHANGED

        int totalitems = Itemsinstore.length;
        int numOfHitems = 0;// number of popular(hot items)
        int numOfUitems = 0;// number of unpopular items
        int numOfOrders = 0;// nom of ordeers
        int numOfStock = 0;// nom of stock
        try {// start a try statement for reading the array

            for (int i = 0; i < totalitems; i++) {
                if (Itemsinstore[i].length != 5) {
                    throw new IllegalArgumentException("Invalid data format for item " + Itemsinstore[i][0]);//throw invalid lists in list

                }
                if (Itemsinstore[i][1].equals("hot item")) {// increase amount of hot items
                    numOfHitems++;

                } else if (Itemsinstore[i][1].equals("unpopular")) {// using else if for ihot and unpopular items
                    numOfUitems++;

                } else {
                    System.out.println("Invalid discription at line " + (i + 1));//print where error is
                }

                numOfOrders += Integer.parseInt(Itemsinstore[i][2].trim());//find amount of orders by adding it to 0 by parsing
                numOfStock += Integer.parseInt(Itemsinstore[i][4].trim());//find amount of stock by adding it to 0 by parsing

            }
            //print results

            System.out.println(numOfOrders + " total orders");
            System.out.println(numOfHitems + " total hot items");
            System.out.println(numOfUitems + " total unpopular items");
            System.out.println(numOfStock + " total stock");
//make a scanner
            Scanner Input = new Scanner(System.in);

            boolean condition = true;//set boolean condition for while loop so its easier to break out of

            while (condition == true) {
                System.out.println("Would you like to browse our items or request an item to be added? type browse to browse and add to add item. type end to exit");
                String Answer = Input.nextLine().toLowerCase(); // make varible answer take in input next line
                switch (Answer) {//start a switch case for the different types of answers
                    case "browse":// if answer is browse
                        System.out.println("WHat would you like to browse?");
                        System.out.println("Here is a list of our items");
                        for (int j = 0; j < totalitems; j++) {// this code prints out the items in the 2d array by first name
                            System.out.println(Itemsinstore[j][0]);
                        }
                        System.out.println("Type item name to see details");
                        String browse = Input.nextLine().toLowerCase();// take in input
                        for (int k = 0; k < totalitems; k++) {//start a nested for loop to iterate over each element in the lsits, once a list is done it moves on to the next

                            if (browse.equals(Itemsinstore[k][0])) {// if the item you chose matches
                                System.out.println("Item found Here are the characteristics");

                                for (int h = 0; h < 5; h++) {//if the detail index is equal to 2 or 4 print out extra text to make it more understandable
                                    if (h == 2 || h == 4) {
                                        System.out.println(Itemsinstore[k][h] + " " + Itemdescription[h]);

                                    } else {// print details normally
                                        System.out.println(Itemsinstore[k][h]);
                                    }

                                }

                    
                            } 

                        }
                        break;// break out of this case

                    case "end":// set condition to false and break out of main loop 
                        condition = false;
                        break;

                    case "add":
                        System.out.println("Enter information format is : Name, Isitempopular(hot item or unpopular, type 1 for hot and 0 for unpopular), Orders in int, 1 characteristic, # of stock");
                        int numofitemsadded = 0;//keeps track of index to add to the 2d arralist

                        ArrayList<String> Thing = new ArrayList<String>();// make a list that we'll write to and append to the 2d arraylist.
                        // a new version gets created when we run the switch case again in the main loop
                        for (int l = 0; l < 5; l++) {
                            String Thingadd = Input.nextLine().toLowerCase();//add typed responses to the list
                            Thing.add(Thingadd);// we're doing error checking later

                        }

                        Itemtobeadded.add(numofitemsadded, Thing);//this is how you add items to 2d arrays
                        //first index is the LIST row(ie 0 for first row), and thing is the LIST you're appending to

                        numofitemsadded++;
                        System.out.println("Your added product:");
                        for (int parent = 0; parent < Itemtobeadded.size(); parent++) {
                            for (int child = 0; child < 5; child++) {// there will always be 5 itmes in the sublists in
                                                                     // the lists
                                try {
                                    if (child == 2) {// if the 3 and 5th element are integers then parse and print it
                                        int temporder = Integer.parseInt(Itemtobeadded.get(parent).get(child));//this is how you get 1 item in the 2d array: i figured this out by messing around
                                      
                                        // its like python where you do int(2dlist[parent][child])but you need to do .get().get()
                                        System.out.println(temporder + " Orders");//print temp otder
                                        

                                    } else if(child == 4) {
                                        int tempstock = Integer.parseInt(Itemtobeadded.get(parent).get(child));//this is how you get 1 item in the 2d array: i figured this out by messing around
                                      
                                        // its like python where you do int(2dlist[parent][child])but you need to do .get().get()
                                        System.out.println(tempstock + " stock");//print temp otder
                                        
                                
                                
                                    } else if (child == 1) {
                                        int tempvalhot = Integer.parseInt(Itemtobeadded.get(parent).get(child));// make a temp var called tempval hot that gets parsed
                                        if (tempvalhot == 1) {// if its 1 then its a hot item
                                            
                                            System.out.println("hot item");


                                        } else if (tempvalhot == 0) {// if its 0 its unpopular
                                            
                                            System.out.println("unpopular");

                                        } else {// if its neither then print undeterminded
                                            System.out.println("underterminded");
                                        }
                                    

                                        
                                    } else {// print other details normally
                                        System.out.println(Itemtobeadded.get(parent).get(child) + " " + Itemdescription[child]);

                                    }

                                } catch (NumberFormatException e) {//catch number format errors

                                    System.out.println("replacing inccorect value with a default value of 0");
                                    Itemtobeadded.get(parent).set(child, "0");// https://stackoverflow.com/questions/15855154/two-dimensional-arraylist-set-an-element
                                                                              // where i got my answer to

                                } 
                            }

                        }
                        System.out.println(Itemtobeadded);// print out the 2d list,mainly for debugging but also to show that above code works
                        break;

                    default:// default case: what happens if response that does not match the cases above
                        System.out.println("Invalid response");
                        break;
                }
            }

            Input.close();// close scanner

        } catch (IllegalArgumentException e) {// catch the exception we made all the way up in our code
            System.out.println(e);// print the error message if you didnt get that

        }
    }
}

package Reviewassignment;

/*
 * Problem: We're a store with no ordering system. we want a ordering system to take in user input and compile it to a list for the user to read
 * Given: Sep. 25/23 Due: Oct 4/23
 * Results should beask for user input, and user should input information. results confirmation messages, and shows the contents of objects added
 * Author: Henry Lin
 * Test cases: typed in wrong inputs
 * 
 * sources: https://stackoverflow.com/questions/19616972/how-to-add-an-object-to-an-arraylist-in-java
 * 
 */

import java.util.Scanner;//use scanner to read input

import java.util.ArrayList;//lets us use the array list functionj

public class orderapp {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        ArrayList<Order> cart = new ArrayList<Order>();// https://stackoverflow.com/questions/19616972/how-to-add-an-object-to-an-arraylist-in-java

        boolean condition = true;// set condition varible, if its false the loop will break
        while (condition == true) {
            System.out.println( "What would you liikem to do? Type end to exit, add to add item, view to view items");
            String answer = Input.nextLine().toLowerCase();// takes in input in lower case and on the next line
            switch (answer) {// set a switch case that clmpares answer
                case "add":// case for add

                    try {// we use a try statement in case we put a string instead of a number for the second 

                        System.out.println("What item do you want to order? type the name below");
                        String itemname = Input.nextLine().toLowerCase();// tkaes in item name on the next line, turns it into lowercase
                        System.out.println("Amount of items?");
                        String Itemnum = Input.nextLine().toLowerCase();//takes in numbers on the next line
                        int numbers = Integer.parseInt(Itemnum);// parse the answer
                        Order OrderName = new Order(itemname, numbers);//make a new order object withthe values we asked
                        cart.add(OrderName);//add the object to the arraylist

                        System.out.println("Would you like to add more of the item amount?");
                        String choice = Input.nextLine().toLowerCase();//take in user choice
                        if (choice.equals("yes")) {// if answer is yes
                            System.out.println("Enter amount to be added");
                            String Amountadd = Input.nextLine().toLowerCase();// take in answer
                            int addnums = Integer.parseInt(Amountadd);//parse it
                            OrderName.amount(addnums);// use built in function to increase amount

                        } else {
                            System.out.println("ok noted");// handle other answers
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e);// print exception message

                    }
                    break;// break out of the case

                case "end":
                    condition = false;//set condition to false and break out of main loop
                    break;

                case "view":// if answer is equal to view items
                    for (int i = 0; i < cart.size(); i++) {// print objects in the arraylist
                        cart.get(i).Print();
                        System.out.print("Number "+(i+1)+" on cart");
                        System.out.println();

                    }
                    break;

                

                    


                default:
                    System.out.println("Wrong choice buddy");// the default case in case user types in improper answer

            }

        }
        Input.close();// close Scanner
       
    }

}

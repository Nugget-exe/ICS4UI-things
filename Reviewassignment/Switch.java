package Reviewassignment;
import java.util.ArrayList;//import array lists

import java.util.List;//import lists
/*
 * Problem: to make a switch and case example for type of genre of books. add a new genre to unsual genre array list. this program should be able to handle any input and not crash
 * Solution: in the code lol. we ask the user for input, which will be handled by a switch case. it has pre defined book genres
 * but if it meets one that it doesnt know, it asks if the user wants to store it in a arraylist of genres and then print it later
 * Created by Henry Lin for assignment
 *  due OCt 4 2023
 * Test cases:
 * put in bad input
 * 
 */
import java.util.Scanner;//import scanner into the file so it can read input

public class Switch {
    public static void main(String[] args){
        System.out.println("Hi what book genre do you liek type your choice under this message");
        List<String> bookGenre = new ArrayList<String>();// make an arraylist to store new and exciting book genres
        Scanner Input = new Scanner(System.in);//name varible that is getting input is called input
        
        String choice = Input.nextLine().toLowerCase();//make a string varible called choice that takes in the input next line, and format it to lowercase
        String chosenGenre = "";//set an empty varible to be filled in later in the switch case
        switch (choice) {// choice is compared to the different cases in this switch
            case "fantasy":
            
            System.out.println("such a fantasy to be honest");//using sys out print because i want it to sound more like a convo with a librian
            break;//break out of each switch case to run code out of the switch

            case "comedy":
            System.out.println("You seem like a guy who tries to be funny");
            break;

            case "thriller":
            System.out.println("Are you familiar with killer clowns");
            break;

            case "mystery":
            System.out.println("You seem like a mysterious guy");
            break;


            case "fiction":
            System.out.println("get real");
            break;

            

            default://what happens if none of choice values matches above cases
            System.out.println("This seems to be a new genre I am unfamiliar with. would you like me to add it a new genre list? type no to pass");
            
            while (true) {//keep asking user for new genres they thought of and add it to bookgenre
                String answer = Input.nextLine().toLowerCase();
                if (answer.equals("no")) {// use a if statement since there is not alot of cases to go through
                    break;

                }else{
                    bookGenre.add(answer);//add user input to list
                    System.out.println("anything else?");
                }




            }


            

        }

        chosenGenre = choice;

        Input.close();//close Input scanner
        System.out.println("Interesting that you you said you liked "+ chosenGenre);

        if (bookGenre.size() > 0) {//if num of items in bookgenre is greater than 0, then print all of the contents in a for loop
            System.out.println("Heres a list of your socalled new genres. type the prevously typed genre");
            for (int i = 0;i < bookGenre.size();i++) {//make a for loop so that each element in the arraylist gets printed to screen
                System.out.println(bookGenre.get(i));

            }

        }

        
    }
    
}

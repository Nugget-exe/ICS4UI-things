
// a pretty bad example of a switch case when you could've used a for loop to compare each value of the user input to existing values
// by Henry

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;//imports
public class switchexample {
    

    public static void main(String[] args){
        List<String> Fruits = new ArrayList<>(Arrays.asList("melon", "lemon", "apple"));//use array list with predefined values

        String message = "";
        String Fruittype;// whoa

        
        Scanner Input = new Scanner(System.in);//create new scanner by using new Scanner. 
        System.out.println("What fruit do you like?");
        System.out.println("Here are the fruits I know of " + Fruits);
        String choice = Input.nextLine().toLowerCase();//read next line and takes whatever you typed into lowercase
        
        switch (choice) { // make a switch statement using choice as its expression to compare values to in the cases. defualt is used when no matching case happens
            case "melon":
                Fruittype = "Melon";
                message = "This fruit is quite round";
                break;

           
            

            case "lemon":
                Fruittype = "Lemon";
                message = "This fruit is quite sour";
                break;

            case "apple":
                Fruittype = "Apple";
                message = "keeps the doctor and medical bills away";
                break;

            default:// literally just nested if statements, thers probally a better way but i dont feel like using stack overflow

                 // if choice does not exist in arraylist fruits
                System.out.println("Would you like me to add that to the list of fuirts that i know of?");
                String answer = Input.nextLine().toLowerCase();
                 
                if (answer.equals("yes")) {//.equals compares 2 strings and returns true if they match
                    Fruits.add(choice);
                    Fruittype = choice;//set fruittype to choice(could be anything)
                    message = "A very interesting fruit!";


                } else {// the default of defaults: else in a default
                    Fruittype = "Unknown";
                    message = "What the fruit?";
                }



        }
        
        System.out.println("WOW i never knew you liked "+ Fruittype);//print fruit type with a custom message
        System.out.println(message);//print the message

        Input.close();
    }
    
}

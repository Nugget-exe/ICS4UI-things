/*
The second example of Selection sort, both String and double to keep track of...
Created for Day 29

After we finish the code, and then check By Weight,come back here.
Your task will be to add the following fruit and vegetables to the array through user input (not simply typing them into the array!);
Cucumber at 1.69 
Broccoli at 3.99 
"Spy apple" at 2.11 
"Bunch of Green Grapes" at 8.99 
Add another 2 fruit and another 2 vegetables of your choice 
and the price at the grocery store you/your family typically shop at.

Make sure you have no typing errors and your new items sort properly.
*/
// Selection sort by price, is much the same as Selection sort
// by weight, we'll look at that one next.

//make prices look like canadian currency $ and cents with 2 decimals
package Searching;
import java.util.Scanner;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

class FruitVeg {
    String name;
    double price;

    public FruitVeg(String name, double price) {
        this.name = name;
        this.price = price;
    }// end local FruitVeg

    public void getPrice() {
        System.out.print(name + price);
    }

    
}// end FruitVeg

public class SelectionSortByPrice {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        
        FruitVeg fruit = new FruitVeg("Apple", 0.2);
        FruitVeg f = new FruitVeg("Banana", 0.21);
        FruitVeg g = new FruitVeg("Carrot", 9.3);
        FruitVeg bg = new FruitVeg("Zuccchini", 4.2);
        FruitVeg h = new FruitVeg("Orang", 5.2);
        ArrayList<FruitVeg> items = new ArrayList<FruitVeg>(Arrays.asList(fruit,f,g,bg,h));

        for (int i=0;i<6;i++) {
            System.out.println("enter name");
            String name = Input.nextLine().toLowerCase();
            System.out.println("enter double");
            String price = Input.nextLine().toLowerCase();
            double prix = Double.parseDouble(price);

            FruitVeg Name = new FruitVeg(name, prix);
            items.add(Name);

            

        }
        
        

        // Perform selection sort based on prices
        for (int i = 0; i < items.size() - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum price in the unsorted part
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j).price < items.get(minIndex).price) {
                    minIndex = j;
                }
            }

            // swap
            FruitVeg temp = items.get(i);

            items.set(i, items.get(minIndex));
            items.set(minIndex, temp);
            

            // find new minIndex
            // check for the index in unsorted part

            // Swap the item with the minimum price with the first item in the unsorted part

        } // end for loop through array

        Locale locale = new Locale("en", "CA"); // United Kingdom
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        System.out.print("Sorted by Price: [");

        // Print the sorted array
        for (int l = 0; l < items.size(); l++) {
            System.out.print(items.get(l).name);

            
            System.out.print(fmt.format(items.get(l).price));
            if (l < items.size() - 1) {
                System.out.print(", ");

            }
           
            

            // items[l].getPrice();
        }

        System.out.println("]");

        Input.close();

        // not quite what you wanted? Why?

    }// end void main
}// end SelectionSortByPrice

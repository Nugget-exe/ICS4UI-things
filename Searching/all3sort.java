package Searching;

import java.util.Scanner;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.Locale;

class FruitVeg {
    String name;
    double price;
    double weight;

    public FruitVeg(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }// end local FruitVeg

    public void getPrice() {
        System.out.print(name + price + weight);
    }

    public String getName() {
        return name;
    }

}// end FruitVeg

public class all3sort {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        FruitVeg fruit = new FruitVeg("Apple", 0.2, 3);
        FruitVeg f = new FruitVeg("Banana", 0.21, 7);
        FruitVeg g = new FruitVeg("Carrot", 9.3, 8);
        FruitVeg bg = new FruitVeg("Zuccchini", 4.2, 9);
        FruitVeg h = new FruitVeg("Orang", 5.2, 8);
        ArrayList<FruitVeg> items = new ArrayList<FruitVeg>(Arrays.asList(fruit, f, g, bg, h));

        for (int i = 0; i < 6; i++) {
            System.out.println("enter name");
            String name = Input.nextLine().toLowerCase();
            System.out.println("enter double");
            String price = Input.nextLine();
            double prix = Double.parseDouble(price);
            System.out.println("Enter weight");
            String w = Input.nextLine();
            double we = Double.parseDouble(w);

            FruitVeg Name = new FruitVeg(name, prix, we);
            items.add(Name);

        }

        System.out.println("WHat type of sort would you like to do? ");
        String answer = Input.nextLine().toLowerCase();

        switch (answer) {
            case "price":
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

                }
                
                // find new minIndex
                // check for the index in unsorted part

                // Swap the item with the minimum price with the first item in the unsorted part

            case "weight":
                for (int i = 0; i < items.size() - 1; i++) {
                    int minIndex = i;

                    // Find the index of the minimum weight in the unsorted part
                    for (int j = i + 1; j < items.size(); j++) {
                        if (items.get(j).weight < items.get(minIndex).weight) {
                            minIndex = j;
                        } // end if checking for shift
                    } // end for, finding index of min.

                    // Swap the item with the minimum weight with the first item in the unsorted
                    // part
                    FruitVeg temp = items.get(i);

                    items.set(i, items.get(minIndex));
                    items.set(minIndex, temp);

                } // end for sorting array

                // Print the sorted array
                System.out.print("[");
                for (int i = 0; i < items.size(); i++) {

                    System.out.print(items.get(i).name);
                    if (i < items.size() - 1) {
                        System.out.print(", ");

                    }
                }
                System.out.print("]");

            case "name":

            String[] notarraylist = new String[items.size()];
           // Collections.addAll();


        }

        Input.close();
         // Print the sorted array
        System.out.print("[");
        for (int i = 0; i < items.size(); i++) {

                    System.out.print(items.get(i).name);
                    if (i < items.size() - 1) {
                        System.out.print(", ");

                    }
                }
        System.out.print("]");


        // not quite what you wanted? Why?

    }// end void main
}// end SelectionSortByPrice

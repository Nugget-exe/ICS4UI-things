package Searching;

// Day 29 - Selection sort by weight
/*The third example of Selection sort, both String and double to keep track of again ...
Created for Day 29
There is one item at the bottom you should fix, then you can go back to Selection Sort by price and do today's tasks.
  */

import java.util.Arrays;

class SelectionSortWeight {
    String name;
    double weight;

    public SelectionSortWeight (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }// end local SelectionSortWeight
}// end class SelectionSortWeight

public class SelectionSortByWeight {
    public static void main(String[] args) {
        SelectionSortWeight[] items = {
            new SelectionSortWeight("Apple", 0.2),
            new SelectionSortWeight("Banana", 0.15),
            new SelectionSortWeight ("Carrot", 0.1),
            new SelectionSortWeight("Zucchini", 0.3),
            new SelectionSortWeight("Orange", 0.25)};

        // Perform selection sort based on weights
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum weight in the unsorted part
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].weight < items[minIndex].weight) {
                    minIndex = j;
                } // end if checking for shift
            }  // end for, finding index of min.

            // Swap the item with the minimum weight with the first item in the unsorted part
            SelectionSortWeight temp = items[i];
            items[i] = items[minIndex];
            items[minIndex] = temp;
        }// end for sorting array

        // Print the sorted array
         System.out.print("[");
        for (int i =0 ; i < items.length; i++) {
           
            System.out.print(items[i].name);
            if (i < items.length - 1) {
                System.out.print(", ");

            }
        }
         System.out.print("]");

      // not quite what you wanted?  Why?
      
      //Look at Selection sort by Price and fix this.
      // since we are not really needing the location, 
      // you may comment out the above println for the 
      // sorted array.


    } // end void main
}// end class Selection Sort Weight

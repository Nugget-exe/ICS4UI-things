// Selection Sort by Name
package Searching;
import java.util.Arrays;

public class SelectionSortAlpha {
    public static void main(String[] args) {
        String[] items = {"Banana", "Apple", "Carrot", "Zucchini", "Orange"};

        // Perform selection sort based on names
        for (int i=0;i<items.length-1;i++) {
            int minindex = i;
             // Find the index of the minimum element in the unsorted part
            for (int j=i+1;j<items.length;j++) {
                if(items[j].compareTo(items[minindex])< 0) {
                    minindex=j;//if its less than it becomes our lower value
                }
            }

            //swap
            String temp = items[i];
            items[i] = items[minindex];
            items[minindex]=temp;

        }
        

           
                // end if compare
            //end for go through array

            // Swap the minimum element with the first element in the unsorted part




        // find the index of min

        // Print the sorted array
        System.out.println("Sorted by name: " + Arrays.toString(items));
    }// end void main
}// end SelectionSortAlpha

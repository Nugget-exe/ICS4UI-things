
package Searching;
//rewrote radix sort based on geeksfor geeks example because in class one doesnt work
import java.io.*;
import java.util.*;

/*
To perform a Radix Sort on an array of double values, you can follow a similar approach to the given Strings example.
This is using the same array as yesterday and in QuickSortDbl.

See INSTRUCTIONS.md ( click on the eye thing to see a readable version.)
*/
/* Specific notes for this file:
To perform Radix Sort on an array of double values, you would need to adapt the counting sort part of the algorithm to sort doubles based on their digit places. This involves extracting digits and sorting based on each digit's value.

I've therefore given you extensive comments.
  */
public class RadixSortDbl {
    
    // Radix Sort for an array of double values
    public static void radixSort(double[] arr) {
        // Find the maximum value to determine the number of digits
        double max = findMax(arr);

        // Perform Radix Sort for each digit place
        for (int exp = 1; max / exp > 0.1; exp *= 10) {
            countingSort(arr, exp);
        }// end for each digit
    }// end void RadixSort

    // Utility function to find the maximum value in the array
    public static double findMax(double[] arr) {
        double max = arr[0];//varible max is set to first index
        for (double value : arr) {//for each value in the array
            if (value > max) {//if the value is greater than the max value set earlier
                max = value;// set max to value
            }// end if value > max
        } // end for, get values
        return max;//reutnr value
    }// end static double

    // Counting Sort for a specific digit place (exp)
    public static void countingSort(double[] arr, double exp) {
        int n = arr.length;
        double[] output = new double[n];//make output list based on n
        int[] count = new int[10]; // 10 possible digits (0-9)

        // Count the occurrences of each digit at the current place
        for (int i = 0; i < n; i++) {
            int digit = (int)(arr[i] / exp) % 10;//find the digits by doing math or smth
            count[digit]++;//increment count at digit x
        }// end for - counting in place

        // Adjust count[i] to store the actual position of the digit in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }// end standard for loop

        // Build the output array similar to counting occurrences in syntax
        
        for (int i = n - 1; i >= 0; i--) {
            int digit = (int)(arr[i]/exp)%10;//creates output the size of the count
            output[count[digit] - 1] = arr[i];
            count[digit]--;

        }
        

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    } //end counting sort

    public static void main(String[] args) {
        double[] doubles = {3.5, 1.2, 2.8, 5.1, 0.9};

        // Apply Radix Sort to the array of doubles
        radixSort(doubles);

        System.out.println("Sorted Doubles:");
        for (double value : doubles) {
            System.out.println(value);
        }// end for printing
    }// end void main
}// cne Radix sort for doubles


 
    

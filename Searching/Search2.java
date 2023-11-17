package Searching;

/* Day 28 2nd Type Binary Search
NOTE: the Array must be sorted first before you can use a binary search.
Sorting on Day 30, maybe 29?

Day29 - object Search using the stack and maybe sorting.

For today here's a very basic binary search.
A Binary search is way more efficient than a linear search or sequential. Think about your contact list, would you start at "a" is you were looking for somone in "r"?  A Binary search starts in the middle and uses a less than or greater than to split into half.  From the correct half, you split again, and again ...
This is how it operates on an array;
a) Find the middle of the list of data set being search (the Key is what you are matching)
b) If the data matches (you were lucky), return the index.
c) If the data does not match, determine if the key is in the first or second half
Repeat steps a-c for the next half until you find your search item.
The item being search for is called a "Key"
The array of data is usually referred to as "data"
the array index of the first element to search(first), and 
the array index of the last element to search(last)

change to string

Your Task:
1.  Do not hardcode the value, have the user request the item to find.
2. Copy this into a new file, change the integers to Strings.  If you do not have a better idea, change to fruit like apple, banana, figs, grapes,kiwi,... (15 sorted items.)
  */
import java.util.Arrays;
import java.util.Scanner;

public class Search2 {

    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        // Define a sorted array of 15 numbers.
        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 };

        // Number to search for in the array.
        int target = Input.nextInt();

        // Perform binary search and get the index of the target element.
        int index = binarySearch(sortedArray, target);

        if (index != -1) {// still searching
            System.out.println("Element " + target + " found at index " + index);

        } else {
            System.out.println("Element " + target + " not found at index");

        }

        Input.close();

    } // end void main

    // Binary search function
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;// find middle of the array
            if (arr[mid] == target) {// if our element is in the middle of the target return the index
                return mid; // Element found.
            } // end if check found
            if (arr[mid] < target) {// if the array at hte middle is less than the target, then 
                left = mid + 1;// target is right half
            } else {
                right = mid - 1;//target is in left half
            } // end if check which half

        }

        return -1; // Target not found in the array.
    } // end int Binary Search
} // end public class Search

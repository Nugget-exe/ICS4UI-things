package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

import Searching.BubbleSortEx;

public class Searchandsort {
    public static void main(String[] args) {
        System.out.println("Hi");

        String[][] test= { 
            {"test", "e","24"},
            {"test", "c","345"},
            {"cest", "b","2"},
            {"best", "d","1"},
            {"t5est", "a","6"},
            {"test", "f","5"}

        };

        

        quickSort(test, 0, test.length-1, 0);

        int[] theanswer = Search2D(test, "f", 1);


        System.out.println("Element found at index: " + Arrays.toString(theanswer));

        


        System.out.println(Arrays.deepToString(test));

        

        

    }
    //sort array of Strings
    public static void quickSort(String[][] array, int low, int high, int cindex){
        if (low < high) {//if low is indeed less than high
            int pivotind = partition(array, low, high, cindex);// make a pivot index at that point
            quickSort(array, low, pivotind-1, cindex);
            quickSort(array, pivotind+1, high, cindex);

        }

    }

    //https://stackoverflow.com/questions/35127804/sort-a-two-dimensional-array-by-column-using-quick-sort

    // Partition function to select a pivot and partition the array of strings
    public static int partition(String[][] arr, int low, int high, int cindex) {
        String pivot = arr[high][cindex];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j][cindex].compareTo(pivot) < 0) {
                i++;
                // Swap elements at index i and j
                String[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String[] temp = arr[i + 1];//use temp var to swap values
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }// end public method quicksort

// using same logic above to sort 2d arrays using mergesort
    public static void mergesort(String[][] array, int left, int right, int cindex){
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergesort(array, left, middle, cindex);
            mergesort(array, middle + 1, right, cindex);
            merge(array, left, middle, right, cindex);
        } 

        

    }

    static void merge(String[][] array, int left, int middle, int right, int cindex) {
        // Copy data to temporary arrays L[] and R[] using copyofrange(it just copies elements from the speificied range)
        String[][] L = Arrays.copyOfRange(array, left, middle + 1);
        String[][] R = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < L.length && j < R.length) {
            if (L[i][cindex].compareTo(R[j][cindex]) <= 0) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < L.length) {
            array[k++] = L[i++];
        }

        // Copy remaining elements of R[] if any
        while (j < R.length) {
            array[k++] = R[j++];
        }
    }

    // Helper method to print the 2D array
    
/* 
    static void merge(String[][] array, int left, int middle, int right, int cindex) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i][cindex];
        } // end for copy to left and right arrays
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j][cindex];
        } // end for check middle

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j])<0) {// i need help understanding this line    
                array[k][cindex] = L[i];
                i++;
            } else {
                array[k][cindex] = R[j];
                j++;
            } // end if merge temp left and right
            k++;
        } // end while make sure mid OK and merge

        while (i < n1) {
            array[k][cindex] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k][cindex] = R[j];
            j++;
            k++;

        }
    }// end static void merge

    */

    public static void bubbleSort(String[][] arr, int cindex) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j][cindex].compareTo(arr[j+1][cindex]) > 0) {//a slight modification to sort 2darrays where we're comparing arr[j] to the row below it

                    // Swap the rows based on cindex
                    String[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }


    public static void selectionSort(String[][] arr, int cindex) {

        for (int i=0;i<arr.length-1;i++) {
            int minindex = i;
             // Find the index of the minimum element in the unsorted part
            for (int j=i+1;j<arr.length;j++) {
                if(arr[j][cindex].compareTo(arr[minindex][cindex])< 0) {
                    minindex=j;//if its less than it becomes our lower value
                }
            }

            //swap
            String[] temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex]=temp;

        }
    }


    //-------------------Searching----------------//

    //based on https://www.geeksforgeeks.org/searching-algorithms-for-a-2d-arrays-matrix/ 2darray search

    public static int[] Search2D(String[][] arr, String target, int cindex) {
        int r = 0;
        int c = arr[0].length - 1; // Start from the top right corner
    
        while (r < arr.length && c >= 0) {
            
            
            if (arr[r][cindex].equals(target)) {
                return new int[]{r, cindex}; // Element found at row, cindex
            } else if (arr[r][cindex].compareTo(target) > 0) {
                c--; // Move left
            } else {
                r++; // Move down
            }
            
        }
        // Element not found
        return new int[]{-1, -1};
    }

   
    

    
   

    









    




    
    
}

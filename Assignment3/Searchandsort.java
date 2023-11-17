package Assignment3;

import java.util.ArrayList;

public class Searchandsort {
    public static void main(String[] args) {
        System.out.println("Hi");

        

        

    }
    //sort array of Strings
    public static void quickSort(String[] array, int low, int high){
        if (low < high) {//if low is indeed less than high
            int pivotind = partition(array, low, high);// make a pivot index at that point
            quickSort(array, low, pivotind-1);
            quickSort(array, pivotind+1, high);

        }

    }

    // Partition function to select a pivot and partition the array of strings
    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                // Swap elements at index i and j
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];//use temp var to swap values
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }// end public method quicksort


    public static void mergesort(String[] array, int left, int right){
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergesort(array, left, middle);
            mergesort(array, middle + 1, right);
            merge(array, left, middle, right);
        } 

        

    }

    static void merge(String[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        } // end for copy to left and right arrays
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        } // end for check middle

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j])<0) {// i need help understanding this line    
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            } // end if merge temp left and right
            k++;
        } // end while make sure mid OK and merge

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;

        }
    }// end static void merge

    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap the elements
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }


    public static void selectionSort(String[] arr) {

        for (int i=0;i<arr.length-1;i++) {
            int minindex = i;
             // Find the index of the minimum element in the unsorted part
            for (int j=i+1;j<arr.length;j++) {
                if(arr[j].compareTo(arr[minindex])< 0) {
                    minindex=j;//if its less than it becomes our lower value
                }
            }

            //swap
            String temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex]=temp;

        }
    }


    //-------------------Searching----------------//

    public static int binarySearch(String[] list, String target) {
        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list[mid].compareTo(target);
            if (comparison == 0) {
                return mid; // String found.
            } // end if find midpoint
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            } // end if check both halves
        } // end while
        return -1; // Element not found.
    }









    




    
    
}

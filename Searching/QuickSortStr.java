package Searching;
/* Day 34 - String version - same one used previously, 
Thursday last week, Tuesday this week and today.
Full Code is here so we can walk through it.

see Instructions for your tasks.(click on the eye thing to see a readable version.)
    */
public class QuickSortStr {
    // Quick Sort function for sorting an array of strings
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }// end if low less than high
    }// end public static void quickSort

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
            }// end if comparing
        }// end for comparing low j and high j
        // Swap the pivot element with the element at index i+1
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }// end public method quicksort

    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "grape", "date", "cherry","balls", "1-3"};

        // Apply Quick Sort to the array of strings
        int n = strings.length;
        quickSort(strings, 0, n - 1);

        // Print the sorted strings
        System.out.println("Sorted Strings:");
        for (String str : strings) {
            System.out.println(str);
        }// end for to loop through results to print
    }// end public static void main
}// end public class quicksort

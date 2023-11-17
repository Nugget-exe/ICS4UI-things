
package Searching;
/*To perform Quick Sort on an array of double values, you can follow a similar approach to the given Strings example.
This is using the same array as yesterday.

See INSTRUCTIONS.md ( click on the eye thing to see a readable version.)
*/
public class QuickSortDbl {
    // Quick Sort function for sorting an array of doubles
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
            
        
        }// end low < high

        


    }// end public static void quicksort4

    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j]<=pivot) {
                i++;
                // Swap elements at index i and j
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }// end if comparing
        }// end for comparing low j and high j
        // Swap the pivot element with the element at index i+1
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }// end public method quicksort

    // Partition function to select a pivot and partition the array of doubles
   

    public static void main(String[] args) {
        double[] doubles = {3.5, 1.2, 2.8, 5.1, 0.9};

        // Apply Quick Sort to the array of doubles
        int n = doubles.length;
        quickSort(doubles, 0, n - 1);

        // Print the sorted doubles
        System.out.println("Sorted Doubles:");
        for (double value : doubles) {
            System.out.println(value);
        }// end for reading array and printing
    }// end static void main
}// end QuickSort

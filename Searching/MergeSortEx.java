package Searching;

public class MergeSortEx {
    public static void main(String[] args) {
        String[] strings = { "appl", "ape", "grape", "date", "cherry" };

        mergeSort(strings, 0, strings.length - 1);

        System.out.println("Sorted Strings:");
        for (String str : strings) {
            System.out.print(str + " ");
        } // end for Strings
    }// end public void main

    // Merge Sort for Strings
    static void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        } // end if left and right
    }// end mergeSort

    // Merge two subarrays of array[]
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
}// end class MergeSortString

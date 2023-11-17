package Searching;

public class MergeSortDoubleExample {
    public static void main(String[] args) {
        double[] doubles = {3.5, 1.2, 2.8, 5.1, 0.9, 2.5};

        mergeSort(doubles, 0, doubles.length - 1);

        System.out.println("Sorted Doubles: ");
        for (double d : doubles) {
            System.out.print(d + " ");
        } // end for double

    }// end void main.

    // Merge Sort for Doubles
    static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;//find middle of array

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        } // end if compare left and right of split
    }// end void mergeSort

    static void merge(double[] array, int left, int middle, int right) {
        // Same merging logic as in the previous example

        int n1 = middle - left + 1;//varibles used to make size of temp arrays
        int n2 = right - middle;

        // Create temporary arrays
        double[] L = new double[n1];
        double[] R = new double[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];//l at i is equal to array[left(starts at 0) plus i(starts at zero, increments by 1 in the for loop)]
        } 


        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];//r at  is equal to array[middle value +1 plus j which increments by 1]
        } // end for check middle

        int i = 0, j = 0;
        int k = left;
//merge arrays
        while (i < n1 && j < n2) {//while both i is less than n1 and r is less than n2
            if (L[i] <= R[j]) {//if the value of L array is less than or equal to Right array value
                array[k] = L[i]; //if l[i]<r[j] then put it in array first using value of l[i]
                i++;
            } else {// do opposite
                array[k] = R[j];
                j++;
            } // end if merge temp left and right
            k++;
        } // end while make sure mid OK and merge

        //sprt merged array
        while (i<n1) {
            array[k]=L[i];
            i++;
            k++;
        }

        while (j<n2) {
            array[k] = R[j];
            j++;
            k++;

        }


    }// end static void merge

   
}// end class MergeSortDouble
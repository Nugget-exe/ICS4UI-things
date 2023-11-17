package Searching;
public class BubbleSortEx {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "grape", "date", "cherry"};

        int n = strings.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    // Swap the elements
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }// end if compare
            }// end for j value
        }// end for I values

        // Display the sorted array
        for (String str : strings) {
            System.out.print(str + " ");
        }// end for printing out the string entries
    }// end public static void main
}// end class Bubble sort

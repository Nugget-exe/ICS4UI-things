package Searching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Day 32 - Insertion sort
This is a VERY basic, very quick sort, basically to show you how.

There isn't much to an insertion sort, check out today's note for the subtitle differences between Selection, Insertion and Bubble.
Tasks:
1. This is sorted by first name, reverse the sort, sort by last name.
2. Take your array from Assignment 2 and sort it.
3. You have been given a csv file with thousands of records.  Sort this file based on the 10th column, column J if you look at it in Sheets.  This will take you the rest of the class.
*/
public class TwoDInsertionSort {

    public static void main(String[] args) {
        // Sample two-dimensional string array of names
        String[][] names = {
                { "Bev", "Khan" },
                { "Joe", "Lee" },
                { "Adam", "Shearer" },
                { "Ryan", "King" },
                { "Jessica", "Hoedl" }
        };

        String[][] things = { { "duck tape", "hot item", "2000", "grey", "25" },
                { "spoons", "unpopular", "1500000", "silver", "1" },
                { "balls", "hot item", "2000000000", "round", "10000000" },
                { "socks", "unpopular", "1", "sock", "0" },
                { "soap", "unpopular", "0", "white", "0" },
                { "mr piche", "hot item", "99999", "gold", "1" },
                { "allen", "hot item", "0", "pink", "34" },
                { "henry lin", "unpopular", "0", "coder", "1" },
                { "sus among us meme", "hot item", "1000000", "red", "0" } };

        // Sort the array based on the first names (column 0)

        insertionSort(things, 0);

        ArrayList<ArrayList<String>> thingy = new ArrayList<ArrayList<String>>();

        // Print the sorted array
        for (String[] thing : things) {
            System.out.println(thing[0]);
        } // end for names

        File file = new File("C:\\Users\\Henry\\.vscode\\ICS4UI things\\98-401-X2021015CI_English_CSV_dataOnt&Can.csv");

        ArrayList<ArrayList<String>> bruh = new ArrayList<ArrayList<String>>();
        try {
            Scanner filescanner = new Scanner(file);
            if (filescanner.hasNextLine()) {// skip the header line
                filescanner.nextLine();

            }

            while (filescanner.hasNextLine()) {
                String line = filescanner.nextLine();
                String[] parts = line.split(",");
                ArrayList<String> values = new ArrayList<String>();

                

                Collections.addAll(values, parts);

                bruh.add(values);

                
            }
            System.out.println(thingy);

            filescanner.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[][] replitsucksass = new String[bruh.size()][1000];

        for(int i=0;i<bruh.size();i++){

            for(int j =0;j<bruh.get(i).size();j++) {
                System.out.print(bruh.get(i).get(j));

                replitsucksass[i][j]= bruh.get(i).get(j);
                

            }
        }

       


        
    } // end void main

    public static void insertionSort(String[][] array, int columnToSort) {
        for (int i = 1; i < array.length; i++) {
            String[] key = array[i];
            int j = i - 1;

            while (j >= 0 && key[0].compareTo(array[j][columnToSort]) < 0) {
                array[j + 1] = array[j];
                j--;
            } // end while reading key

            array[j + 1] = key;
        } // end for checking names
    } // end void insertion sort

}// end class 2D Insertion sort

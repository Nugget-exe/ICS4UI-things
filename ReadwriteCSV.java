

// and example of making a basic write/read thing in CSV's  using java with no openCSV
//made by Henry L
/*Problem: Create a csv file of useful data (min. 50 – 100 records) on any
topic/subject/theme you are interested in. Create a program that read’s in your
file, uses try/catch error checking for input/output and appropriately reads in the
csv file and perform some basic statistical summaries based on what is
reasonable for your csv file. Must have at least totals, averages, minimum &
maximum values. Your user input and results (print to console) must be
reasonable with no errors.
the actual problem: We want to read and write to a file called Example.csv where we keep data on students name, grade and average. the program should be able to handle invalid inputs and csv files and read and write to the csv file
Instructions: The program will tel lyou want to do, but when it asks for input, you input based on proper formatting. the program will then ask if you want to end, or keep adding. afterwards, the program will read the csv file contents
DUe: Oct4,2023
Testcases: tested with inproper input, and inproper formatting in csv file.
sources:
https://stackoverflow.com/questions/10804286/trouble-with-filewriter-overwriting-files-instead-of-appending-to-the-end
https://docs.oracle.com/javase/6/docs/api/java/io/FileWriter.html#FileWriter%28java.lang.String,%20boolean%29
https://www.programiz.com/java-programming/bufferedwriter#google_vignette
 https://www.geeksforgeeks.org/finding-minimum-element-of-java-arraylist/
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import java.util.Scanner;//include required imports

public class ReadwriteCSV {

    public static void main(String[] args) {

        try {// using try because what if the file is not named correctly or misnamed

            FileWriter writer = new FileWriter("Example.csv", true);// figured this out thanks to
                                                                    // google:https://stackoverflow.com/questions/10804286/trouble-with-filewriter-overwriting-files-instead-of-appending-to-the-end
                                                                    // and
                                                                    // https://docs.oracle.com/javase/6/docs/api/java/io/FileWriter.html#FileWriter%28java.lang.String,%20boolean%29
            BufferedWriter bufferedWriter = new BufferedWriter(writer);// use buffered writer to write to files
            // where i learnt how to use buffered writer:
            // https://www.programiz.com/java-programming/bufferedwriter#google_vignette
            Scanner scanner = new Scanner(System.in);// set up scanner to recieve input

            while (true) {
                System.out.println("Enter student info in form of name, age, grade or 'end' to finish:");
                String input = scanner.nextLine();// read lines after this statement
                if (input.equals("end")) {// use .equals and not ==, found this out after 30 mins smashing my head on a
                                          // wall
                    scanner.close();// close scanner
                    
                    break;
                }

                String[] partss = input.split(",");// since we're using parts in the later half i opted to just add
                                                   // another s to not make everything explode
                if (partss.length == 3) {// check for proper formatting
                    
                    bufferedWriter.write(partss[0].trim() + "," + partss[1].trim() + "," + partss[2].trim());// write to
                                                                                                             // csv file
                                                                                                             // with
                                                                                                             // commas
                                                                                                             // in
                                                                                                             // between
                    bufferedWriter.newLine();// separate next line
                } else {
                    System.out.println("Invalid input format. Please use 'name, age, grade'.");
                }
                
            }

            bufferedWriter.close();
            File file = new File("Example.csv");
            Scanner filescanner = new Scanner(file);
            int averageAge = 0; // Camelcase for the win
            int gradeAvg = 0;// make a varible called average age and grade that will have 0
            int totalStudents = 0;

            List<Integer> MinAgelist = new ArrayList<Integer>();// make arraylists for both grades and ages to find the
                                                                // smallest age and grade
            List<Integer> MinGradelist = new ArrayList<Integer>();

            if (filescanner.hasNextLine()) {// skip the header line
                filescanner.nextLine();

            }
            while (filescanner.hasNextLine()) {// read each line and split it using delimiter ,

                String line = filescanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {// if the line we're currently on has 3 parts(name,age,grade)
                    String Student = parts[0].trim();// I am trimming the first part that comes out, which is name

                    try {// put rest of stuff in a try statement; what if the csv file has wrong values
                         // and has a string in the areas that belong to numbers only
                        int studentAge = Integer.parseInt(parts[1].trim());// get the second part(age)
                        int studentGrade = Integer.parseInt(parts[2].trim());

                        gradeAvg += studentGrade;// add current value of grade to average grade
                        MinAgelist.add(studentAge);// append student age to the list
                        MinGradelist.add(studentGrade);// append student grade to the list
                        averageAge += studentAge;// add the current age to average age

                        totalStudents += 1;// increment the number of students by 1

                        System.out.println(
                                "Student " + Student + " is " + studentAge + " and has a grade of " + studentGrade);// print
                                                                                                                    // the
                                                                                                                    // name
                                                                                                                    // and
                                                                                                                    // age
                                                                                                                    // and
                                                                                                                    // grade
                                                                                                                    // of
                                                                                                                    // student

                    } catch (NumberFormatException e) {
                        System.out.println(e);// PRINT OUT THE WRONG ERROR YEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
                    }

                } else {
                    System.out.println("Invalid line at " + line); // shows where invalid line is
                }

            }
            if (totalStudents > 0) {// show results
                System.out.println("There are " + totalStudents + " students");
                System.out.println("The average grade is " + (gradeAvg / totalStudents));
                System.out.println("The average age is " + (averageAge / totalStudents));
                System.out.println("The smallest age is " + Collections.min(MinAgelist));
                System.out.println("The smallest grade is " + Collections.min(MinGradelist));// print the smallest age
                                                                                             // and grade
                System.out.println("The largest age is " + Collections.max(MinAgelist));// collections.min found at
                                                                                        // https://www.geeksforgeeks.org/finding-minimum-element-of-java-arraylist/
                System.out.println("The largest grade is " + Collections.max(MinGradelist));// print largest age and
                                                                                            // grade using the lists

            }

            filescanner.close();// close scanner

        } catch (FileNotFoundException e) {// file error handling
            e.printStackTrace();
            // print the errors

        } catch (IOException e) {// input error handling
            e.printStackTrace();

        }

    }
}

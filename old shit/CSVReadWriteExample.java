import java.io.*;
import java.util.Scanner;

public class CSVReadWriteExample {
    public static void main(String[] args) {
        try {
            // Write to CSV, using FileWriter("path.csv",true); to add data to the end of a csv file
            FileWriter writer = new FileWriter("Example.csv", true);//figured this out thanks to google:https://stackoverflow.com/questions/10804286/trouble-with-filewriter-overwriting-files-instead-of-appending-to-the-end and https://docs.oracle.com/javase/6/docs/api/java/io/FileWriter.html#FileWriter%28java.lang.String,%20boolean%29
            BufferedWriter bufferedWriter = new BufferedWriter(writer);//use buffered writer to write to the csv file

            Scanner scanner = new Scanner(System.in);//make a scanner called scanner

            while (true) {
                System.out.println("Enter student info (name, age, grade) or 'end' to finish:");
                String input = scanner.nextLine();

                if (input.equals("end")) {//me when .equals("values") is different from x == "value"
                    break;
                }

                String[] parts = input.split(",");
                if (parts.length == 3) {
                    bufferedWriter.write(parts[0].trim() + "," + parts[1].trim() + "," + parts[2].trim());
                    bufferedWriter.newLine();
                } else {
                    System.out.println("Invalid input format. Please use 'name, age, grade'.");
                }
            }

            bufferedWriter.close();

            // Read from CSV
            File file = new File("Example.csv");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {//run this while the csv file has a line
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    int grade = Integer.parseInt(parts[2].trim());

                    System.out.println("Student: " + name + ", Age: " + age + ", Grade: " + grade);
                }
            }

            fileScanner.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

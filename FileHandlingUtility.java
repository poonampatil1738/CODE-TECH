import java.io.*;
import java.util.Scanner;

/*
 * FileHandlingUtility
 * CODTECH Internship Task - 1
 *
 * This program demonstrates:
 * 1. Write to file
 * 2. Read file
 * 3. Modify (append) file
 */

public class FileHandlingUtility {

    static final String FILE_NAME = "sample.txt";

    // Write data to file
    public static void writeFile(String data) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(data);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Read data from file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Modify (append) data
    public static void appendFile(String data) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write("\n" + data);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending file.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== File Handling Utility =====");
            System.out.println("1. Write File");
            System.out.println("2. Read File");
            System.out.println("3. Append File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    writeFile(sc.nextLine());
                    break;

                case 2:
                    readFile();
                    break;

                case 3:
                    System.out.print("Enter text to append: ");
                    appendFile(sc.nextLine());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
              }

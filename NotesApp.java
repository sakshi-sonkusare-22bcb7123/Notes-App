import java.io.*;
import java.util.*;

public class NotesApp {

    static final String FILE_NAME = "notes.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete All Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    deleteAllNotes();
                    break;
                case 4:
                    System.out.println("Thankyou for using Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    // Add note to file
    public static void addNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note added.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // View all notes
    public static void viewNotes() {
        System.out.println("\n----All Notes----");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("[No notes found]");
            }

        } catch (FileNotFoundException e) {
            System.out.println("[No notes found]");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Delete all notes
    public static void deleteAllNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            // overwrite with nothing
            System.out.println("All notes deleted.");
        } catch (IOException e) {
            System.out.println("Error clearing notes.");
        }
    }
}

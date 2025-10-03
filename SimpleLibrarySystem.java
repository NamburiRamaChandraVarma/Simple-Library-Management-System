import java.util.ArrayList;
import java.util.Scanner;
//book class to initialize book as objects using constructor
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // initially available
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + 
               ", Status: " + (isIssued ? "Issued" : "Available");
    }
}

public class SimpleLibrarySystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        Book b = new Book(id, title, author);
        library.add(b);
        System.out.println("Book added successfully!");
    }

    public static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book b : library) {
                System.out.println(b);
            }
        }
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        for (Book b : library) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        for (Book b : library) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid book ID.");
    }

    public static void searchBook() {
        sc.nextLine(); // consume newline
        System.out.print("Enter Book Title to search: ");
        String title = sc.nextLine();
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + b);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: searchBook(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}


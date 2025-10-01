import java.util.ArrayList;
import java.util.Scanner;

// Book class to store book info
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    // Constructor
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // initially book is available
    }

    // Display book info
    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}

// Library class to manage books
class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Add book to library
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Display all books
    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("ID | Title | Author | Status");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Issue book to student
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully.");
                    return;
                } else {
                    System.out.println("Book is already issued.");
                    return;
                }
            }
        }
        System.out.println("Book ID not found.");
    }

    // Return book
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully.");
                    return;
                } else {
                    System.out.println("Book was not issued.");
                    return;
                }
            }
        }
        System.out.println("Book ID not found.");
    }

    // Search book by title
    void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + b);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class SimpleLibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


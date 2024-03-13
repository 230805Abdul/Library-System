import java.io.*;
import java.util.*;

// Book class
class Book implements Serializable {
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;

    // Constructor
    public Book(int bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = true; // Set default availability to true
    }

    // Getters and setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Override toString method for better printing
    @Override
    public String toString() {
        return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + (availability ? "Available" : "Not Available");
    }
}

// User class
class User implements Serializable {
    private int userID;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;

    // Constructor
    public User(int userID, String name, String contactInfo) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Override toString method for better printing
    @Override
    public String toString() {
        return "UserID: " + userID + ", Name: " + name + ", Contact Info: " + contactInfo;
    }
}

// Library class
class Library implements Serializable {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Method to add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Method to check out a book
    public void checkOutBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailability(false);
            user.getBorrowedBooks().add(book);
        }
    }

    // Method to return a book
    public void returnBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);
        if (book != null && user != null && !book.isAvailable()) {
            book.setAvailability(true);
            user.getBorrowedBooks().remove(book);
        }
    }

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for books by author
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to find a book by ID
    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to find a user by ID
    private User findUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null; // User not found
    }

    // Getters for books and users
    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}

// Main class
public class LibraryManagement {
    // Constants for file names
    private static final String BOOKS_FILE = "books.ser";
    private static final String USERS_FILE = "users.ser";

    // Scanner for user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = loadLibrary(); // Load library from file

        int choice;
        do {
            // Display menu options
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Books by Title");
            System.out.println("7. Search Books by Author");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(library);
                    break;
                case 2:
                    addUser(library);
                    break;
                case 3:
                    displayBooks(library);
                    break;
                case 4:
                    borrowBook(library);
                    break;
                case 5:
                    returnBook(library);
                    break;
                case 6:
                    searchBooksByTitle(library);
                    break;
                case 7:
                    searchBooksByAuthor(library);
                    break;
                case 0:
                    saveLibrary(library); // Save library to file before exiting
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Method to add a new book
    private static void addBook(Library library) {
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        Book book = new Book(bookID, title, author, genre);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    // Method to add a new user
    private static void addUser(Library library) {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Information: ");
        String contactInfo = scanner.nextLine();

        User user = new User(userID, name, contactInfo);
        library.addUser(user);
        System.out.println("User added successfully.");
    }

    // Method to display all books in the library
    private static void displayBooks(Library library) {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to borrow a book
    private static void borrowBook(Library library) {
        System.out.print("Enter Book ID to borrow: ");
        int bookID = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();

        library.checkOutBook(bookID, userID);
        System.out.println("Book borrowed successfully.");
    }

    // Method to return a book
    private static void returnBook(Library library) {
        System.out.print("Enter Book ID to return: ");
        int bookID = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();

        library.returnBook(bookID, userID);
        System.out.println("Book returned successfully.");
    }

    // Method to search books by title
    private static void searchBooksByTitle(Library library) {
        System.out.print("Enter Title to search: ");
        String title = scanner.nextLine();

        List<Book> result = library.searchBooksByTitle(title);
        if (result.isEmpty()) {
            System.out.println("No books found with the given title.");
        } else {
            System.out.println("Books found with the given title:");
            for (Book book : result) {
                System.out.println(book);
            }
        }
    }

    // Method to search books by author
    private static void searchBooksByAuthor(Library library) {
        System.out.print("Enter Author to search: ");
        String author = scanner.nextLine();

        List<Book> result = library.searchBooksByAuthor(author);
        if (result.isEmpty()) {
            System.out.println("No books found by the given author.");
        } else {
            System.out.println("Books found by the given author:");
            for (Book book : result) {
                System.out.println(book);
            }
        }
    }

    // Method to load library from file
    private static Library loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKS_FILE))) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            return new Library(); // Return a new library if file not found
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading library data: " + e.getMessage());
            return new Library(); // Return a new library in case of error
        }
    }

    // Method to save library to file
    private static void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKS_FILE))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.err.println("Error saving library data: " + e.getMessage());
        }
    }
}

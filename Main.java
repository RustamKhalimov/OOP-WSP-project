import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("Madina");
        Map<String, User> users = new HashMap<>();

        String booksFile = "books.txt";
        String usersFile = "users.txt";

        File booksFileObj = new File(booksFile);
        File usersFileObj = new File(usersFile);

        if (booksFileObj.exists()) {
            library.loadBooksFromFile(booksFile);
        } else {
            System.out.println("Books file not found. New books can be added.");
        }

        if (usersFileObj.exists()) {
            library.loadUsersFromFile(usersFile);
        } else {
            System.out.println("Users file not found.");
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Show all books");
            System.out.println("4. Add a user");
            System.out.println("5. Borrow a book");
            System.out.println("6. Return a book");
            System.out.println("7. Calculate fine");
            System.out.println("8. Exit");
            System.out.print("Select an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the year of publication: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    librarian.addBook(library, title, author, year);
                }
                case 2 -> {
                    System.out.print("Enter the title of the book to remove: ");
                    String title = scanner.nextLine();
                    librarian.removeBook(library, title);
                }
                case 3 -> librarian.listAllBooks(library);
                case 4 -> {
                    System.out.print("Enter the user type (1 - Student, 2 - Teacher): ");
                    int userType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the user name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty. Try again.");
                        continue;
                    }
                    User user = null;
                    if (userType == 1) {
                        System.out.print("Enter the student's group: ");
                        String group = scanner.nextLine();
                        user = new Student(name, group);
                    } else if (userType == 2) {
                        System.out.print("Enter the teacher's department: ");
                        String department = scanner.nextLine();
                        user = new Teacher(name, department);
                    } else {
                        System.out.println("Invalid user type. Try again.");
                        continue;
                    }
                    users.put(name, user);
                    System.out.println("User added successfully.");
                }
                case 5 -> {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    User user = users.get(name);
                    if (user == null) {
                        System.out.println("User not found. Add the user first.");
                        continue;
                    }
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    library.borrowBook(user, bookTitle);
                }
                case 6 -> {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    User user = users.get(name);
                    if (user == null) {
                        System.out.println("User not found. Add the user first.");
                        continue;
                    }
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    library.returnBook(user, bookTitle);
                }
                case 7 -> {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    User user = users.get(name);
                    if (user == null) {
                        System.out.println("User not found.");
                        continue;
                    }
                    library.calculateFine(user);
                }
                case 8 -> {
                    // Save data before exiting
                    library.saveBooksToFile(booksFile);
                    library.saveUsersToFile(usersFile);
                    System.out.println("Exiting the program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

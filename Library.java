import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Library {
    private List<Book> books;
    private Map<User, List<BorrowedBook>> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.borrowedBooks = new HashMap<>();
    }
    
    
    public void saveBooksToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                if (book.getTitle() != null && !book.getTitle().isEmpty() &&
                    book.getAuthor() != null && !book.getAuthor().isEmpty() &&
                    book.getYear() > 0) {
                    writer.write(book.getTitle() + ";" + book.getAuthor() + ";" + book.getYear() + ";");
                    writer.newLine();
                }
            }
            System.out.println("Books saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }


    
    public void saveUsersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<User, List<BorrowedBook>> entry : borrowedBooks.entrySet()) {
                User user = entry.getKey();
                List<BorrowedBook> borrowedBookList = entry.getValue();
                for (BorrowedBook borrowedBook : borrowedBookList) {
                    writer.write(user.getName() + ";" + borrowedBook.getBook().getTitle() + ";" + borrowedBook.getBorrowDate());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error when saving user data to a file: " + e.getMessage());
        }
    }

   
    public void loadBooksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 4) {
                    System.out.println("Skipping invalid book data: " + line);
                    continue;
                }
                String title = parts[0].trim();
                String author = parts[1].trim();
                int year;
                try {
                    year = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid year in book data: " + line);
                    continue;
                }
                String genre = parts[3].trim();
                addBook(title, author, year);
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    public boolean removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

  
    public void loadUsersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                if (userData.length == 3) {
                    String userName = userData[0];
                    String bookTitle = userData[1];
                    String borrowDateStr = userData[2];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate borrowDate = LocalDate.parse(borrowDateStr, formatter);

                    
                    User user = new Student(userName, "");  
                    Book book = findBookByTitle(bookTitle);
                    if (book != null) {
                        borrowedBooks.putIfAbsent(user, new ArrayList<>());
                        borrowedBooks.get(user).add(new BorrowedBook(book, borrowDate));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error when loading users from a file: " + e.getMessage());
        }
    }

    Book findBookByTitle(String title) {
    
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books available.");
        } else {
            System.out.println("All books in the library:");
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ") ");
            }
        }
    }


    public void borrowBook(User user, String bookTitle) {
        Book book = findBookByTitle(bookTitle);
        if (book != null) {
            if (!isBookBorrowed(book)) {
                List<BorrowedBook> borrowedBookList = borrowedBooks.getOrDefault(user, new ArrayList<>());
                borrowedBookList.add(new BorrowedBook(book, LocalDate.now()));
                borrowedBooks.put(user, borrowedBookList);
                System.out.println(user.getName() + " picked up a book: " + bookTitle);
            } else {
                System.out.println("The book is already taken.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private boolean isBookBorrowed(Book book) {
        for (List<BorrowedBook> borrowedBookList : borrowedBooks.values()) {
            for (BorrowedBook borrowedBook : borrowedBookList) {
                if (borrowedBook.getBook().equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void returnBook(User user, String bookTitle) {
        Book book = findBookByTitle(bookTitle);
        if (book != null) {
            List<BorrowedBook> borrowedBookList = borrowedBooks.get(user);
            if (borrowedBookList != null) {
                BorrowedBook borrowedBookToReturn = null;
                for (BorrowedBook borrowedBook : borrowedBookList) {
                    if (borrowedBook.getBook().equals(book)) {
                        borrowedBookToReturn = borrowedBook;
                        break;
                    }
                }
                if (borrowedBookToReturn != null) {
                    borrowedBookList.remove(borrowedBookToReturn);
                    System.out.println(user.getName() + " returned the book: " + bookTitle);
                } else {
                    System.out.println(user.getName() + " didn't pick up this book.");
                }
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void calculateFine(User user) {
        List<BorrowedBook> borrowedBookList = borrowedBooks.get(user);
        if (borrowedBookList != null) {
            for (BorrowedBook borrowedBook : borrowedBookList) {
                LocalDate borrowDate = borrowedBook.getBorrowDate();
                long daysOverdue = borrowDate.until(LocalDate.now(), java.time.temporal.ChronoUnit.DAYS);
                if (daysOverdue > 180) {
                    long fine = daysOverdue * 5;
                    System.out.println("Penalty for the user" + user.getName() + " constitutes: " + fine + " tenge");
                }
            }
        }
    }
}

public class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Library library, String title, String author, int year) {
        library.addBook(title, author, year);
        System.out.println("Librarian " + name + " added the book: " + title);
    }

    public void removeBook(Library library, String title) {
        boolean removed = library.removeBook(title);
        if (removed) {
            System.out.println("Librarian " + name + " removed the book: " + title);
        } else {
            System.out.println("Book with the title '" + title + "' was not found in the library.");
        }
    }

    public void searchBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book with the title '" + title + "' was not found.");
        }
    }

    public void listAllBooks(Library library) {
        System.out.println("All books in the library:");
        library.listBooks();
    }
}

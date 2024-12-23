import java.time.LocalDate;

class BorrowedBook {
    private Book book;
    private LocalDate borrowDate;

    public BorrowedBook(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}
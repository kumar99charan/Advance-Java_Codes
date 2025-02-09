import java.util.ArrayList;

class Book {
    int bookid;
    String title;
    String author;
    boolean isAvailable;

    public Book(int bookid, String title, String author) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookid + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
           /* System.out.println(title + " has been borrowed.");*/
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        /*System.out.println(title + " has been returned.");*/
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable) {
                book.displayBookInfo();
            }
        }
    }
}

class Student {
    int studentid;
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(int studentid, String name) {
        this.studentid = studentid;
        this.name = name;
    }

    public void borrowBook(Book book,Student borrower) {
        if (borrowedBooks.size() < 3 && book.isAvailable) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println(""+borrower.name+" has successfully  borrowed "+book.title );
        } else {
            System.out.println("Cannot borrow " + book.title);
        }
    }

    public void returnBook(Book book,Student borrower) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println(""+borrower.name+" has successfully  returned "+book.title );
        } else {
            System.out.println("This book was not borrowed.");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book(1, "The Witcher", "Andrzej Sapkowski");
        Book book2 = new Book(2, "The Witcher Swords of Destiny", "George Orwell");

        library.addBook(book1);
        library.addBook(book2);

        Student student = new Student(16, "Charan");

        library.listAvailableBooks();
        student.borrowBook(book1,student);
        student.borrowBook(book2,student);
        student.returnBook(book1,student);
        library.listAvailableBooks();
    }
}

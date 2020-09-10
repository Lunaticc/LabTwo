package LibraryLabb;

import LibraryLabb.Books.AudioBook;
import LibraryLabb.Books.Book;
import LibraryLabb.Books.GeneralBook;
import LibraryLabb.Books.Status;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library("General Library");
        Book book = new AudioBook("Billy's revenge", "Billy grace", 1997, Status.AVAILABLE);
        Book book2 = new AudioBook("Billy's avenge", "Billy grace", 2007, Status.UNAVAILABLE);
        Book book3 = new AudioBook("Hell's fury", "Gregory", 2000, Status.AVAILABLE);


//        System.out.println(book2.bookInformation());

        lib.addBook(book);
        lib.addBook(book2);
        lib.addBook(book);
        lib.addBook(book3);

        System.out.println(book.bookInformation());
        lib.getLibrarian().issueBook(book);
        System.out.println(book.bookInformation());
        lib.getLibrarian().issueBook(book);
        System.out.println(lib.getBookIndex(book2));
        lib.searchBook(book2);
        System.out.println(lib.getBookIndex(book3));
        lib.searchBook(new GeneralBook("Billy's Downfall", "Billy grace" ,2012, Status.AVAILABLE));

    }
}

package LibraryLabb;

public class Main {
    public static void main(String[] args) {
        Book book = new AudioBook("Billy's revenge", "Billy grace", 1997, Status.AVAILABLE);
        Book book2 = new AudioBook("Billy's avenge", "Billy grace", 2007, Status.UNAVAILABLE);

        Library lib = new Library("General Library");
        System.out.println(book.bookInformation());
        System.out.println(book2.bookInformation());

        lib.addBook(book);
        lib.addBook(book2);
        lib.addBook(book);

    }
}

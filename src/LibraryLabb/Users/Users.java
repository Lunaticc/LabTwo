package LibraryLabb.Users;

import LibraryLabb.Books.AudioBook;
import LibraryLabb.Books.Book;
import LibraryLabb.Books.GeneralBook;
import LibraryLabb.Library;

import java.util.ArrayList;
import java.util.List;

public abstract class Users {
    private static int id = 0;
    private int uniqueID;
    private String name;
    private String address;
    private String phoneNr;

    private boolean isFaculty;
    private Library library;

    protected List<Book> borrowedBooks;
    protected int genBooks;
    protected int audioBooks;


    public Users(String name, String address, String phoneNr, Boolean isFaculty, Library library) {
        this.uniqueID = ++id;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.isFaculty = isFaculty;
        this.library = library;

        genBooks = 0;
        audioBooks = 0;
        borrowedBooks = new ArrayList<>();
    }

    public abstract boolean borrowBook(Book book);

    public boolean returnBook(Book book){
        if(book != null){
            for (Book b : borrowedBooks){
                if (b.equals(book)) {
                    getLibrary().getLibrarian().returnBook(book);
                    borrowedBooks.remove(book);
                    if(book instanceof GeneralBook){
                        genBooks--;
                        return true;
                    }else if(book instanceof AudioBook){
                        audioBooks--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean payFine(int fine){
        System.out.println("Paying fine of: $" + fine);
        library.getLibrarian().collectFine(fine);
        return false;
    }

    public static int getId() {
        return id;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public Library getLibrary() {
        return library;
    }

    public boolean isFaculty() {
        return isFaculty;
    }
}

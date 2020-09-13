package LibraryLabb.Users;

import LibraryLabb.Books.Book;
import LibraryLabb.Library;

public abstract class Users {
    private static int id = 0;
    private int uniqueID;
    private String name;
    private String address;
    private String phoneNr;

    private boolean isFaculty;
    private Library library;

    public Users(String name, String address, String phoneNr, Boolean isFaculty, Library library) {
        this.uniqueID = id++;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.isFaculty = isFaculty;
        this.library = library;
    }
    // TODO: Need to fix faculty members, and do some changes to the Student class!

    public abstract String userDescription();

    public abstract boolean borrowBook(Book book);

    public abstract boolean returnBook(Book book);

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

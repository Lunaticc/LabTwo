package LibraryLabb;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Users> users;
    private Librarian librarian;

    public Library(String name) {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.librarian = new Librarian(name, this);
    }

    public boolean addBook(Book book){
        if(book != null){
            for (Book b : books){
                if(book.getUniqueID() == b.getUniqueID()){
                    System.out.println("Already in library");
                    return false;
                }
            }
            System.out.println("Adding " + book.getName() + " to library!");
            books.add(book);
        }

        return false;
    }
}

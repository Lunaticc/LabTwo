package LibraryLabb;

import AttemptOne.User;
import LibraryLabb.Books.Book;
import LibraryLabb.Users.Users;

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

    public boolean removeBook(Book book){
        if(book != null){
            for (Book b : books){
                if(book.equals(b)){
                    System.out.println("Removing " + book.getName() + " from library");
                    books.remove(book);
                    return true;
                }
            }
        }
        System.out.println("Cannot remove something that's not there");
        return false;
    }
    // TODO: Update the book from whos ID this is
    public boolean updateBook(int id){
        return false;
    }

    public boolean searchBook(Book book){
        if(book != null){
            for (Book b : books){
                if (book.getUniqueID() == b.getUniqueID() || book.getName().equalsIgnoreCase(b.getName())) {
                    System.out.println("{"+ book.getName() + "}" + " - Found\n" +
                            "Availability - " + book.getStatus());
                    return true;
                }
            }
        }
        System.out.println("Cannot find " + book.getName());
        return false;
    }

    public boolean addUser(User user){
        if(user != null){
            for (Users u : users){
                if(user.equals(u)){

                    System.out.println("Adding new user: " + user.getName());
                    return false;
                }
            }
        }
        System.out.println("Cannot add something that's not a thing!");
        return false;
    }

    /////GETTERS/////


    public List<Book> getBooks() {
        return books;
    }
    public int getBookIndex(Book book){
        return books.indexOf(book);
    }

    public List<Users> getUsers() {
        return users;
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}

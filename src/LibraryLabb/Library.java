package LibraryLabb;


import LibraryLabb.Books.Book;
import LibraryLabb.Users.Users;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private List<Book> books;
    private List<Users> users;
    private Librarian librarian;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
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
            book.setLibrary(this);
            books.add(book);
        }

        return false;
    }

    public boolean removeBook(int id){
        int i = getBookIndex(id);
        books.remove(i);
        return true;
    }
    public boolean removeBook(Book book){
        if(book != null){
            for (Book b : books){
                if(book.equals(b)){
                    System.out.println("Removing " + book.getName() + " from library");
                    book.setLibrary(null);
                    books.remove(book);
                    return true;
                }
            }
        }
        System.out.println("Cannot remove something that's not there");
        return false;
    }
    // TODO: Update the book from who's ID this is
    public boolean updateBook(int id, String name){
        if(id > 0){
            for (Book b : books){
                if(b.getUniqueID() == id){
                    books.get(getBookIndex(id)).setName(name);
                }
            }
        }
        return false;
    }
    private int getBookIndex(int id){
        for (Book b : books){
            if(b.getUniqueID() == id){
                return books.indexOf(b);
            }
        }
        return -1;
    }

    public boolean searchBook(int id){
        if(id > 0){
            for (Book b : books){
                if(b.getUniqueID() == id){
                    System.out.println("Book found with ID: " + id + "\n" + b.bookInformation());
                    return true;
                }
            }
        }
        System.out.println("Sorry, could not find book: " + id);
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

    public void printBooks(){
        for (Book b : books){
            System.out.println(b.bookInformation());
        }
    }
    public void addUser(Users user){
        users.add(user);
    } // Legit lost everything here. as you can see :D

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

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}

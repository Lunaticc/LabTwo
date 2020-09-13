package LibraryLabb.Users;

import LibraryLabb.Books.*;
import LibraryLabb.Library;

import java.util.ArrayList;
import java.util.List;

public class FacultyMember extends Users{
    private List<Book> borrowedBooks;
    private int genBooks;
    private int audioBooks;

    public FacultyMember(String name, String address, String phoneNr, Boolean isFaculty, Library library) {
        super(name, address, phoneNr, isFaculty, library);
        borrowedBooks = new ArrayList<>();
        genBooks = 0;
        audioBooks = 0;
    }


    public void orderBook(String type, String name, String author, int publishingYeah){
        Book orderedBook = Book.orderBook(type, name, author, publishingYeah);
        getLibrary().addBook(orderedBook);
    }


    /////OVERRIDDEN METHODS/////

    @Override
    public boolean borrowBook(Book book) {
        if (book != null) {
            if(book instanceof GeneralBook && book.getStatus().equals(Status.AVAILABLE) && genBooks < 5){
                genBooks++;
                getLibrary().getLibrarian().issueBook(book);
                borrowedBooks.add(book);
                return true;
            }else if(book instanceof AudioBook && book.getStatus().equals(Status.AVAILABLE) && audioBooks < 2){
                audioBooks++;
                getLibrary().getLibrarian().issueBook(book);
                borrowedBooks.add(book);
                return true;
            }else if(book instanceof ReferenceBooks){
                System.out.println("Cannot borrow this kind of book");
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean returnBook(Book book) {
        if(book != null){
            for (Book b : borrowedBooks){
                if(b.equals(book)){
                    getLibrary().getLibrarian().returnBook(book, this.getUniqueID());
                    borrowedBooks.remove(book);
                    if(book instanceof GeneralBook){
                        genBooks--;
                    } else if (book instanceof AudioBook) {
                        audioBooks--;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String userDescription() {
        return "Faculty Member{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNr='" + this.getPhoneNr() + '\'' +
                ", isFaculty=" + this.isFaculty() +
                ", library=" + this.getLibrary() +
                '}';
    }
}

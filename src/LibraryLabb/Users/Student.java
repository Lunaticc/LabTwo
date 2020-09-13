package LibraryLabb.Users;

import LibraryLabb.Books.*;
import LibraryLabb.Library;

import java.util.ArrayList;
import java.util.List;

public class Student extends Users {
    private List<Book> borrowedBooks;
    private int genBooks;
    private int audioBooks;

    public Student(String name, String address, String phoneNr, Library library) {
        super(name, address, phoneNr, false, library);
        genBooks = 0;
        audioBooks = 0;
        borrowedBooks = new ArrayList<>();
    }

    @Override
    public String userDescription() {
        return "Student{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNr='" + this.getPhoneNr() + '\'' +
                ", isFaculty=" + this.isFaculty() +
                ", library=" + this.getLibrary() +
                '}';
    }

    @Override
    public boolean borrowBook(Book book) {
        if(book != null){
            if(book instanceof GeneralBook && genBooks < 2 && book.getStatus()== Status.AVAILABLE){
                genBooks++;
                getLibrary().getLibrarian().issueBook(book);
                borrowedBooks.add(book);
                return true;
            }else if(book instanceof AudioBook && audioBooks < 1 && book.getStatus()== Status.AVAILABLE){
                audioBooks++;
                getLibrary().getLibrarian().issueBook(book);
                borrowedBooks.add(book);
                return true;
            }else if(book instanceof ReferenceBooks){
                System.out.println("Reference books cannot be borrowed or taken out of the library");
                return false;
            }else {
                System.out.println("Sorry, " + book.getName() + " is currently unavailable!");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        if (book != null) {
            for (Book b : borrowedBooks){
                if(b.equals(book)){
                    getLibrary().getLibrarian().returnBook(book, this.getUniqueID());
                    borrowedBooks.remove(book);
                    genBooks--;
                    return true;
                }
            }
        }
        System.out.println("Cannot return a book you have not borrowed");
        return false;
    }

    /////GETTERS/////
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getGenBooks() {
        return genBooks;
    }

    public int getAudioBooks() {
        return audioBooks;
    }
}

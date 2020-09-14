package LibraryLabb.Users;

import LibraryLabb.Books.*;
import LibraryLabb.Library;

import java.util.List;

public class Student extends Users {


    public Student(String name, String address, String phoneNr, Library library) {
        super(name, address, phoneNr, false, library);
    }


    @Override
    public String toString() {
        return "Student{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNr='" + this.getPhoneNr() + '\'' +
                ", isFaculty=" + this.isFaculty() +
                '}';
    }

    @Override
    public boolean borrowBook(Book book) {
        if(book != null){
            if(book instanceof GeneralBook && this.getGenBooks() < 2 && book.getStatus()== Status.AVAILABLE){
                super.genBooks++;
                getLibrary().getLibrarian().issueBook(book);
                getBorrowedBooks().add(book);
                return true;
            }else if(book instanceof AudioBook && this.getAudioBooks() < 1 && book.getStatus()== Status.AVAILABLE){
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

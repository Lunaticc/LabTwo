package LibraryLabb.Users;

import LibraryLabb.Books.*;
import LibraryLabb.Library;

public class Student extends Users {
    private final int maxGenBooks = 2;
    private final int maxAudBooks = 1;
    private int genBooks;
    private int audioBooks;

    public Student(String name, String address, String phoneNr, Library library) {
        super(name, address, phoneNr, false, library);
        genBooks = 0;
        audioBooks = 0;
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
                return true;
            }else if(book instanceof AudioBook && audioBooks < 1 && book.getStatus()== Status.AVAILABLE){
                audioBooks++;
                getLibrary().getLibrarian().issueBook(book);
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
    public void returnBook(Book book) {

    }

    @Override
    public void payFine(double fine) {

    }
}

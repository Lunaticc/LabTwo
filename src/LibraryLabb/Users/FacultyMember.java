package LibraryLabb.Users;

import LibraryLabb.Books.*;
import LibraryLabb.Library;


public class FacultyMember extends Users{

    public FacultyMember(String name, String address, String phoneNr, Library library) {
        super(name, address, phoneNr, true, library);
    }

    public void orderBook(String type, String name, String author, int publishingYeah){
        Book orderedBook = bookToOrder(type, name, author, publishingYeah);
        getLibrary().addBook(orderedBook);
    }

    private static Book bookToOrder(String type, String name, String author, int publishingYear){
        if (type.equalsIgnoreCase("General")){
            return new GeneralBook(name ,author, publishingYear, Status.ORDERED);
        } else if(type.equalsIgnoreCase("Audio")){
            return new AudioBook(name, author, publishingYear, Status.ORDERED);
        } else if(type.equalsIgnoreCase("Reference")){
            return new ReferenceBooks(name, author, publishingYear, Status.ORDERED);
        }
        return null;
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
    public String toString() {
            return "Faculty Member{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNr='" + this.getPhoneNr() + '\'' +
                ", isFaculty=" + this.isFaculty() +
                '}';
    }
}

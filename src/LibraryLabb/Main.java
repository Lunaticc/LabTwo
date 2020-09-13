package LibraryLabb;

import LibraryLabb.Books.*;
import LibraryLabb.Users.FacultyMember;
import LibraryLabb.Users.Student;
import LibraryLabb.Users.Users;

public class Main {
    public static void main(String[] args) {

        //Library
        Library lib = new Library("General Library");

//        Librarian librarian = new Librarian("Grace", lib);
        //General Books
        Book genBook = new GeneralBook("Billy's revenge", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook2 = new GeneralBook("Billy's Magma", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook3 = new GeneralBook("Billy's Ensyclopedia", "Billy grace", 1997, Status.AVAILABLE);



        Book book2 = new AudioBook("Billy's avenge", "Billy grace", 2007, Status.UNAVAILABLE);
        Book book3 = new ReferenceBooks("Hell's fury", "Gregory", 2000, Status.AVAILABLE);


        //Students
        Users student1 = new Student("David", "Rymdgatan 34c", "0722118808", lib);
        Users student2 = new Student("Mich", "Solstigsgatan 32d", "072218490", lib);



        lib.addUser(student1);
        lib.addUser(student1);
//        System.out.println(book2.bookInformation());
        //Add books to list
        lib.addBook(genBook);
        lib.addBook(book2);
        lib.addBook(genBook);
        lib.addBook(book3);
        lib.addBook(genBook2);
        lib.addBook(genBook3);

//        System.out.println(genBook.bookInformation());
//        lib.getLibrarian().issueBook(genBook);
//        System.out.println(genBook.bookInformation());
//        lib.getLibrarian().issueBook(genBook);
//        System.out.println(lib.getBookIndex(book2));
//        lib.searchBook(book2);
//        System.out.println(lib.getBookIndex(book3));
        lib.searchBook(new GeneralBook("Billy's Downfall", "Billy grace" ,2012, Status.AVAILABLE));
//        lib.searchBook(1);

//        lib.printBooks();

//        lib.removeBook(genBook);
//        lib.printBooks();

//        lib.updateBook(2, "Stephen's vaganza");
//        lib.printBooks();

//        lib.searchBook(1);
//        lib.searchBook(2);


            printBetween();

            lib.printBooks();
            printBetween();
        System.out.println("Book borrowing/returning for student 1");
            student1.borrowBook(genBook);
            student1.borrowBook(genBook2);
            student1.returnBook(genBook);
            student1.borrowBook(genBook3);
            printBetween();
            lib.printBooks();

            printBetween();
        System.out.println("Book testing for student 2");
        student2.borrowBook(genBook);
        student2.borrowBook(book2);
        student2.borrowBook(book3);


            printBetween();

        Users faculty = new FacultyMember("Billy", "Heaven's road 42", "072280038", lib);
        lib.addUser(faculty);
        FacultyMember f = (FacultyMember)faculty; // bad, bad, bad!
        ((FacultyMember) faculty).orderBook("General", "Boris's world", "Boris svensson", 1778);
        lib.printBooks();
        ((FacultyMember) faculty).orderBook("Audio", "How to not do code", "David thiman", 2020);
        lib.printBooks();

        printBetween();

        System.out.println(lib.getUsers());
//        printBetween();
//        lib.getLibrarian().issueBook(genBook);
//        lib.getLibrarian().returnBook(book2);
//        lib.printBooks();
    }

    private static void printBetween(){
        System.out.println("\n==============================\n");
    }
}

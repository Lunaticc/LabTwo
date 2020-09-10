package LibraryLabb;

import AttemptOne.User;
import LibraryLabb.Books.*;
import LibraryLabb.Users.Student;
import LibraryLabb.Users.Users;

public class Main {
    public static void main(String[] args) {

        //Library
        Library lib = new Library("General Library");

        //General Books
        Book genBook = new GeneralBook("Billy's revenge", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook2 = new GeneralBook("Billy's Magma", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook3 = new GeneralBook("Billy's Ensyclopedia", "Billy grace", 1997, Status.AVAILABLE);



        Book book2 = new AudioBook("Billy's avenge", "Billy grace", 2007, Status.UNAVAILABLE);
        Book book3 = new ReferenceBooks("Hell's fury", "Gregory", 2000, Status.AVAILABLE);


        //Students
        Users user = new Student("David", "Rymdgatan 34c", "0722118808", lib);

        lib.addUser(user);
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
//        System.out.println("===============================");
//        lib.printBooks();
//        System.out.println("===============================");
//        lib.removeBook(genBook);
//        lib.printBooks();
//        System.out.println("=======");
//        lib.updateBook(2, "Stephen's vaganza");
//        lib.printBooks();
//        System.out.println("===============================");
//        lib.searchBook(1);
//        lib.searchBook(2);


            printBetween();

            lib.printBooks();
            printBetween();
            user.borrowBook(genBook);
            user.borrowBook(genBook2);
            user.borrowBook(genBook3);
            printBetween();
            lib.printBooks();


//        printBetween();
//        lib.getLibrarian().issueBook(genBook);
//        lib.getLibrarian().returnBook(book2);
//        lib.printBooks();
    }

    private static void printBetween(){
        System.out.println("\n==============================\n");
    }
}

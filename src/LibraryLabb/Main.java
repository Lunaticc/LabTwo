package LibraryLabb;

import LibraryLabb.Books.*;
import LibraryLabb.Users.FacultyMember;
import LibraryLabb.Users.Student;
import LibraryLabb.Users.Users;

public class Main {
    public static void main(String[] args) {
        /*
            Sorry for the mess, I hope it's more comprehensible to you, than it is to me
        */

        //Library
        Library lib = new Library("General Library");

        //Librarian
        Librarian librarian = new Librarian("Grace", lib);
        lib.setLibrarian(librarian);

        //General Books
        Book genBook = new GeneralBook("Billy's revenge", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook2 = new GeneralBook("Billy's Magma", "Billy grace", 1997, Status.AVAILABLE);
        Book genBook3 = new GeneralBook("Billy's Encyclopedia", "Billy grace", 1997, Status.AVAILABLE);

        // Audiobook!
        Book book2 = new AudioBook("Billy's avenge", "Billy grace", 2007, Status.UNAVAILABLE);
        Book book3 = new ReferenceBooks("Hell's fury", "Gregory", 2000, Status.AVAILABLE);


        //Students
        Users student1 = new Student("David", "Rymdgatan 34c", "0722118808", lib);
        Users student2 = new Student("Mich", "Solstigsgatan 32d", "072218490", lib);


        // Adding users to userlist and books to booklist
        lib.addUser(student1);
        lib.addUser(student2);
        lib.addBook(genBook);
        lib.addBook(book2);
        lib.addBook(genBook);
        lib.addBook(book3);
        lib.addBook(genBook2);
        lib.addBook(genBook3);


        //Searching for a book
        lib.searchBook(new GeneralBook("Billy's Downfall", "Billy grace" ,2012, Status.AVAILABLE));


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
        FacultyMember f = (FacultyMember)faculty;
        f.orderBook("General", "Boris's world", "Boris svensson", 1778);
        printBetween();
        ((FacultyMember) faculty).orderBook("Audio", "How to not do code", "David thiman", 2020);
        lib.printBooks();

        printBetween();

        System.out.println(lib.getUsers());
    }

    private static void printBetween(){
        System.out.println("\n==============================\n");
    }
}

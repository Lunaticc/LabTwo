package LibraryLabb;

import LibraryLabb.Books.Book;
import LibraryLabb.Books.Status;

public class Librarian{
    private String name;
    private Library library;
    private double funds;

    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
        this.funds = 0;
    }

    public boolean issueBook(Book book){
        if(book != null){
            for (Book b : library.getBooks()){
                if(book.getStatus().equals(Status.AVAILABLE)){
                    System.out.println("The book is on file and you may borrow it");
                    int x = library.getBookIndex(book);
                    library.getBooks().get(x).setStatus(Status.UNAVAILABLE);
                    return true;
                }else {
                    System.out.println(book.getName() + " is currently " + book.getStatus());
                    return false;
                }
            }
        }
        return false;
    }


    public boolean returnBook(Book book){
        if (book != null) {

                if(book.getStatus().equals(Status.UNAVAILABLE)){
                    System.out.println("Returning book " + book.getName());
                    int x = library.getBookIndex(book);
                    library.getBooks().get(x).setStatus(Status.AVAILABLE);
                }else {
                    System.out.println("The book is already back!");
                }

        }
        return true;

    }

    public void collectFine(int fine){

    }

}

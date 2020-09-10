package LibraryLabb;

import LibraryLabb.Books.Book;
import LibraryLabb.Books.Status;

public class Librarian{
    private String name;
    private Library library;

    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public boolean issueBook(Book book){
        if(book != null){
            for (Book b : library.getBooks()){
                if(b.getStatus().equals(Status.AVAILABLE)){
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

    public Book returnBook(){
        return null;
    }

    public void collectFine(int fine){

    }

}

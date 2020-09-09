package LibraryLabb;

public class Librarian implements SearchFunc{
    private String name;
    private Library library;

    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public void issueBook(Book book){

    }

    public Book returnBook(){
        return null;
    }

    public void collectFine(int fine){

    }

    @Override
    public void findBook(Book book) {
        if(book == null){

        }
    }
}

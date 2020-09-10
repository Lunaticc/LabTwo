package LibraryLabb.Books;

public class GeneralBook extends Book {

    public GeneralBook(String name, String author, int publishingYear, Status status) {
        super(name, author, publishingYear, status);
    }

    @Override
    public String bookInformation() {
        return "General Book{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", publishingYear=" + this.getPublishingYear() +
                ", status=" + this.getStatus() +
                '}';
    }
}

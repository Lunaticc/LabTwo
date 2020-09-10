package LibraryLabb.Books;

public class ReferenceBooks extends Book {

    public ReferenceBooks(String name, String author, int publishingYear, Status status) {
        super(name, author, publishingYear, status);
    }

    @Override
    public String bookInformation() {
        return "Reference Book{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", publishingYear=" + this.getPublishingYear() +
                ", status=" + this.getStatus() +
                '}';
    }
}

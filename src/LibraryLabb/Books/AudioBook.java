package LibraryLabb.Books;

public class AudioBook extends Book {

    public AudioBook(String name, String author, int publishingYear, Status status) {
        super(name, author, publishingYear, status);
    }

    @Override
    public String bookInformation() {
        return "AudioBook{" +
                "uniqueID=" + this.getUniqueID() +
                ", name='" + this.getName() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", publishingYear=" + this.getPublishingYear() +
                ", status=" + this.getStatus() +
                '}';
    }

}

package LibraryLabb.Books;

import LibraryLabb.Library;

public abstract class Book {
    private static int id = 0;
    private int uniqueID;
    private String name;
    private String author;
    private int publishingYear;
    private Status status;

    private Library library;

    public Book(String name, String author, int publishingYear, Status status) {
        this.uniqueID = ++id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.status = status;
    }

    public abstract String bookInformation();

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void setLibrary(Library library) {
        this.library = library;
    }
}

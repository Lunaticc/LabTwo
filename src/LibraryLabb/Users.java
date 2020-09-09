package LibraryLabb;

public abstract class Users {
    private static int id = 0;
    private int uniqueID;
    private String name;
    private String address;
    private String phoneNr;

    private Library library;

    public Users(String name, String address, String phoneNr) {
        this.uniqueID = id++;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
    }

    public void borrowBook(){

    }

    public void returnBook(){

    }

    public void payFine(){

    }
}

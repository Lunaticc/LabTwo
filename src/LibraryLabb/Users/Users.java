package LibraryLabb.Users;

import LibraryLabb.Library;

public abstract class Users {
    private static int id = 0;
    private int uniqueID;
    private String name;
    private String address;
    private String phoneNr;

    private boolean isFaculty;
    private Library library;

    public Users(String name, String address, String phoneNr, Boolean isFaculty) {
        this.uniqueID = id++;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.isFaculty = isFaculty;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uniqueID=" + uniqueID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", isFaculty=" + isFaculty +
                '}';
    }

    public abstract  void borrowBook();

    public abstract void returnBook();

    public abstract void payFine();

    public static int getId() {
        return id;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public Library getLibrary() {
        return library;
    }
}

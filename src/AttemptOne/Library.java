package AttemptOne;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private Librarian lib = new Librarian();
    private List<User> users;

    public Library() {
        this.users = new ArrayList<>();
    }

    public boolean addUser(String name){
        User u = new Student(name);
        return true;
    }

    public Librarian getLib() {
        return lib;
    }

    public void setLib(Librarian lib) {
        this.lib = lib;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

package node;

public class Admin extends User {

    public Admin(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    @Override
    protected String getUsername() {
        return this.username;
    }

    @Override
    protected String getPass() {
        return this.pass;
    }
}
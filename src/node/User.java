package node;

abstract public class User {
    protected String username;
    protected String pass;

    abstract protected String getUsername();
    abstract protected String getPass();
}

package model;

public class User {

    private long id;
    private String login;
    private String password;
    private long roleId;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.roleId = 2;
    }

    public User(long id, String login, String password, long roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getRoleId() {
        return roleId;
    }
}

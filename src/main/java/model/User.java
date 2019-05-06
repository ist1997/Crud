package model;

public class User {

    private long id;
    private String login;
    private String password;
    private Role role;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.USER;
    }

    public User(long id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

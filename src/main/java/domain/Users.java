package domain;

public class Users {
    private String email;
    private String username;
    private String password;
    private String privilege;

    public Users(String email, String username, String password, String privilege) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(String value) {
        this.privilege = value;
    }
}
package domain;

public class Users {
    private int id;
    private String email;
    private String username;
    private String password;
    private int userRoleCode;
    private String profilePicture;

    public Users(int id, String email, String username, String password, int userRoleCode, String profilePicture) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRoleCode = userRoleCode;
        this.profilePicture = profilePicture;
    }

    public Users() {

    }

    public int getId() {
        return this.id;
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

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String value) {
        this.profilePicture = value;
    }

    public int getUserRoleCode() {
        return this.userRoleCode;
    }

    public void setUserRoleCode(int value) {
        this.userRoleCode = value;
    }

}
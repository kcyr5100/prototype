package domain;

public class UserRole {
    private int id;
    private String role;
    public UserRole(int id, String label){
        this.id = id;
        this.role = label;
    }
    public int getId(){
        return this.id;
    }
    public String getLabel(){
        return this.role;
    }
}

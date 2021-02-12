package repository;

import domain.Users;

public class LogIn {
    private String email;
    private String username;
    private String password;

    public LogIn(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public void method() {
        SignUp usersrepo = new SignUp(this.email, this.username, this.password);
        Users[] users = usersrepo.method();

        for (int i = 0; i<users.length; i++){
            if(this.email.equalsIgnoreCase(users[i].getEmail()) || this.password.equalsIgnoreCase(users[i].getPassword())) {
                System.out.println("logged in successfully as " + this.email + " a " + users[i].getPrivilege());
                if(users[i].getPrivilege().equalsIgnoreCase("admin")){
                    System.out.println("you can add archivistes, remove them, add document, read, modidy and delete them");
                } else if(users[i].getPrivilege().equalsIgnoreCase("archiviste")){
                    System.out.println("you can add document, read, modidy and delete them");
                }else{
                    System.out.println("you can only read document");
                }
            }
        }
    }
}

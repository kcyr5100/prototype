package repository;

import domain.Users;

public class SignUp {
    private String email;
    private String username;
    private String password;
    private Boolean error;

    public SignUp(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Users[] method() {
        UsersRepository usersrepo = new UsersRepository();
        Users[] users = usersrepo.getAllUser();

        for (int i = 0; i<users.length; i++){
            if(this.email.equalsIgnoreCase(users[i].getEmail())) {
                error = true;
                System.out.println("email already in use");
            }else if(this.username.equalsIgnoreCase(users[i].getUsername())){
                error = true;
                System.out.println("username already in use");
            }
        }

        Users newUser = new Users(this.email, this.username, this.password, "user");
        Users admin = new Users("daru@gmail.com", "daru", "14456", "admin");
        Users archiviste1 = new Users("xenosama@gmail.com", "akira", "tori77", "archiviste");
        Users archiviste2 = new Users("meliodas@gmail.com", "nanashi", "liz42", "archiviste");

        return new Users[]{
                admin, archiviste1, archiviste2, newUser
        };
    }
}

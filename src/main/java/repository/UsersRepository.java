package repository;

import domain.Users;

public class UsersRepository {

    public Users[] getAllUser(){
        Users admin = new Users("daru@gmail.com", "daru", "14456", "admin");
        Users archiviste1 = new Users("xenosama@gmail.com", "akira", "tori77", "archiviste");
        Users archiviste2 = new Users("meliodas@gmail.com", "nanashi", "liz42", "archiviste");

        return new Users[]{
                admin, archiviste1, archiviste2
        };

    }
}

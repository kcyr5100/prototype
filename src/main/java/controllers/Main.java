/*package controllers;

import domain.Users;
import services.LogIn;
import services.SignUp;
import repository.UsersRepository;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String command = "x";
        String entree;
        do {
            System.out.println("Bienvenue à OceanStore");
            System.out.println("Liste des utilisateur actuels");
            UsersRepository usersrepo = new UsersRepository();
            Users[] users = usersrepo.getAllUser();
            for (int i = 0; i< users.length; i++){
                System.out.println(users[i].getUsername() + ' ' + users[i].getPrivilege());
            }
            System.out.println("Veillez creer un compte");
            System.out.println("email: ");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.next();
            System.out.println("username: ");
            String username = scanner.next();
            System.out.println("mot de pass: ");
            String password = scanner.next();
            SignUp sign = new SignUp(email, username, password);
            Users[] nouveau = sign.method();
            for (int i = 0; i< nouveau.length; i++){
                System.out.println(nouveau[i].getUsername() + ' ' + nouveau[i].getPrivilege());
            }
            LogIn log = new LogIn(email, username, password);
            log.method();
            System.out.println("appuyez sur r pour recommencer, et x pour arreter");
            entree = scanner.next();
        }while (!entree.equalsIgnoreCase(command));
    }
}
*/
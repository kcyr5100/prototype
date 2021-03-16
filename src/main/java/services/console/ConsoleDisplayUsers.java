package services.console;

import java.util.Scanner;
import domain.Users;
import services.IDisplayUser;


public class ConsoleDisplayUsers implements IDisplayUser {
    @Override
    public void displayWelcome() {
        System.out.println("Bienvenue sur OceanStor la platforme pour retrouver tous vos documents. Vous etes administrateur");
    }

    @Override
    public void displayMainMenu() {
        System.out.println("1 lister les utitilisateurs");
        System.out.println("2 ajouter un utitilisateur");
        System.out.println("3 modifier un utitilisateur");
        System.out.println("4 supprimer un utitilisateur");
    }

    @Override
    public void displayUsersList(Users[] users) {
        System.out.println("Les utilisateurs de la platforme sont:");
        for (int i = 0; i < users.length; i++) {
            Users user = users[i];
            System.out.println(String.format("> %s %s %s %s %s", user.getId(), user.getEmail(), user.getUsername(), "privilege: " + user.getUserRoleCode(), user.getProfilePicture()));
        }
    }

    @Override
    public Users createUser() {
        Users user = new Users();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l'addresse email'");
        user.setEmail(sc.nextLine());
        System.out.println("entrer le nom d'utilisateur");
        user.setUsername(sc.nextLine());
        System.out.println("entrer le mot de passe");
        user.setPassword(sc.nextLine());
        System.out.println("entrer l'id du role de l'utilisateur");
        user.setUserRoleCode(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer la photo de profile");
        user.setProfilePicture(sc.nextLine());

        return user;
    }

    @Override
    public void displayUnknown() {
        System.out.println("Menu Introuvable");
    }

    @Override
    public Users updateUser() {
        Users user = new Users();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l'addresse email'");
        user.setEmail(sc.nextLine());
        System.out.println("entrer le nom d'utilisateur");
        user.setUsername(sc.nextLine());
        System.out.println("entrer le mot de passe");
        user.setPassword(sc.nextLine());
        System.out.println("entrer l'id du role de l'utilisateur");
        user.setUserRoleCode(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer la photo de profile");
        user.setProfilePicture(sc.nextLine());

        return user;
    }

    @Override
    public int deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'utilisateur à supprimer");
        return  scanner.nextInt();
    }
}


package services.console;

import domain.Users;
import repository.IUsersRepository;
import services.IDisplayUser;
import services.IMenuUser;

import java.util.Scanner;

public class ScannerMenuUser  implements IMenuUser {
    private final Scanner scanner;
    private IUsersRepository userRepository;
    private IDisplayUser displayUser;

    public ScannerMenuUser(IUsersRepository userRepository, IDisplayUser displayUser) {
        this.userRepository = userRepository;
        this.displayUser = displayUser;
        this.scanner = new Scanner(System.in);
    }
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void displayMenu( int choix) {

        Users[] users = userRepository.getAll();
        switch (choix){
            case 1:
                displayUser.displayUsersList(users);
                break;
            case 2:
                userRepository.create(displayUser.createUser()) ;
                displayUser.displayUsersList(users);
                break;
            case 3:
                userRepository.update(displayUser.updateUser()) ;
                displayUser.displayUsersList(users);
                break;
            case 4:
                userRepository.delete(displayUser.deleteUser()) ;
                displayUser.displayUsersList(users);
                break;

            default:
                displayUser.displayUnknown();
        }

    }

    @Override
    public void displayMenu() {
        int choix = lireChoix();
        displayMenu(choix);
    }
}


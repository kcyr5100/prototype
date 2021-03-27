package controllers;

import repository.DataSource;
import repository.MysqlDataSource;
import repository.IUsersRepository;
import repository.jdbc.JdbcBasedUsersRepository;
import services.IDisplayUser;
import services.console.ConsoleDisplayUsers;
import services.console.ScannerMenuUser;

public class UserController {

    private final IDisplayUser displayUser;
    private final ScannerMenuUser scannerMenuUser;
    public UserController() {
        displayUser = new ConsoleDisplayUsers();
        DataSource dataSource = new MysqlDataSource();
        IUsersRepository userRepository = new JdbcBasedUsersRepository(dataSource) ;
        scannerMenuUser = new ScannerMenuUser(userRepository,displayUser);

    }

    public void process(){

        displayUser.displayWelcome();
        displayUser.displayMainMenu();
        scannerMenuUser.displayMenu();
    }
}
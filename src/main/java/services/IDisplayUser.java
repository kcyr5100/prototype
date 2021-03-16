package services;

import domain.Users;

public interface IDisplayUser {
    void displayWelcome();
    void displayMainMenu();
    void displayUsersList(Users[] users);
    Users createUser();
    void  displayUnknown();
    Users updateUser();
    int deleteUser();
}

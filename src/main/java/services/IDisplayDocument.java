package services;

import domain.Documents;

public interface IDisplayDocument {
    void displayWelcome();
    void displayMainMenu();
    void displayDocumentsList(Documents[] documents);
    Documents createDocument();
    void  displayUnknown();
    Documents updateDocument();
    int deleteDocument();
}

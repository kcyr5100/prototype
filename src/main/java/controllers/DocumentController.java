package controllers;

import repository.DataSource;
import repository.MysqlDataSource;
import repository.IDocumentRepository;
import repository.jdbc.JdbcBasedDocumentRepository;
import services.IDisplayDocument;
import services.console.ConsoleDisplayDocuments;
import services.console.ScannerMenuDocument;

public class DocumentController {

    private final IDisplayDocument displayDocument;
    private final ScannerMenuDocument scannerMenuDocument;
    public DocumentController() {
        displayDocument = new ConsoleDisplayDocuments();
        DataSource dataSource = new MysqlDataSource();
        IDocumentRepository documentRepository = new JdbcBasedDocumentRepository(dataSource) ;
        scannerMenuDocument = new ScannerMenuDocument(documentRepository,displayDocument);

    }

    public void process(){

        displayDocument.displayWelcome();
        displayDocument.displayMainMenu();
        scannerMenuDocument.displayMenu();
    }
}

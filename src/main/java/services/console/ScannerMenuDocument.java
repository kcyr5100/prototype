package services.console;

import java.util.Scanner;
import domain.Documents;
import repository.interfaces.IDocumentRepository;
import services.IDisplayDocument;
import services.IMenuDocument;

public class ScannerMenuDocument  implements IMenuDocument {
    private final Scanner scanner;
    private IDocumentRepository documentRepository;
    private IDisplayDocument displayDocument;

    public ScannerMenuDocument(IDocumentRepository documentRepository, IDisplayDocument displayDocument) {
        this.documentRepository = documentRepository;
        this.displayDocument = displayDocument;
        this.scanner = new Scanner(System.in);
    }
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void displayMenu( int choix) {

        Documents[] documents = documentRepository.getAll();
        switch (choix){
            case 1:
                displayDocument.displayDocumentsList(documents);
                break;
            case 2:
                documentRepository.create(displayDocument.createDocument()) ;
                displayDocument.displayDocumentsList(documents);
                break;
            case 3:
                documentRepository.update(displayDocument.updateDocument()) ;
                displayDocument.displayDocumentsList(documents);
                break;
            case 4:
                documentRepository.delete(displayDocument.deleteDocument()) ;
                displayDocument.displayDocumentsList(documents);
                break;

            default:
                displayDocument.displayUnknown();
        }

    }

    @Override
    public void displayMenu() {
        int choix = lireChoix();
        displayMenu(choix);
    }
}

package services.console;

import java.util.Scanner;
import domain.Documents;
import services.IDisplayDocument;


public class ConsoleDisplayDocuments implements IDisplayDocument {
    @Override
    public void displayWelcome() {
        System.out.println("Bienvenue sur OceanStor la platforme pour retrouver tous vos documents");
    }

    @Override
    public void displayMainMenu() {
        System.out.println("1 lister les documents");
        System.out.println("2 ajouter un document");
        System.out.println("3 modifier un document");
        System.out.println("4 supprimer un document");
    }

    @Override
    public void displayDocumentsList(Documents[] documents) {
        System.out.println("Les documents disponibles sont:");
        for (int i = 0; i < documents.length; i++) {
            Documents document = documents[i];
            System.out.println(String.format("> %s %s %s %s %s %s", "ID: " + document.getId(), "Tile: " + document.getTitle(), document.getFileName(), "format :" + document.getFormat(), "faculté :" + document.getFaculty(), "type de document :" + document.getDocumentType()));
        }
    }

    @Override
    public Documents createDocument() {
        Documents document = new Documents();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le titre");
        document.setTitle(sc.nextLine());
        System.out.println("entrer la nom du fichier");
        document.setFileName(sc.nextLine());
        System.out.println("entrer la date de création du document");
        document.setProductionDate(sc.nextLine());
        System.out.println("entrer l'id du format");
        document.setFormat(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer l'id du type du document");
        document.setDocumentType(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer l'id de la faculté");
        document.setFaculty(Integer.parseInt(sc.nextLine()));

        return document;
    }

    @Override
    public void displayUnknown() {
        System.out.println("Menu Introuvable");
    }

    @Override
    public Documents updateDocument() {
        Documents document = new Documents();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le titre");
        document.setTitle(sc.nextLine());
        System.out.println("entrer la nom du fichier");
        document.setFileName(sc.nextLine());
        System.out.println("entrer la date de création du document");
        document.setProductionDate(sc.nextLine());
        System.out.println("entrer l'id du format");
        document.setFormat(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer l'id du type du document");
        document.setDocumentType(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer l'id de la faculté");
        document.setFaculty(Integer.parseInt(sc.nextLine()));

        return document;
    }

    @Override
    public int deleteDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id du document à supprimer");
        return  scanner.nextInt();
    }
}

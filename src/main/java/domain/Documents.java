package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Documents {
    private int id;
    private String title;
    private String fileName;
    private String productionDate;
    private String createdAt;
    private int format;
    private int documentType;
    private int faculty;

    public Documents(int id, String title, String fileName, String productionDate, int format, int documentType, int faculty){
        this.id = id;
        this.title = title;
        this.fileName = fileName;
        this.productionDate = productionDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        this.createdAt = dateFormat.format(calendar.getTime());
        this.format = format;
        this.documentType = documentType;
        this.faculty = faculty;
    }

    public Documents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        this.createdAt = dateFormat.format(calendar.getTime());
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getFileName(){
        return this.fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getProductionDate(){
        return this.productionDate;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setProductionDate(String productionDate){
        this.productionDate = productionDate;
    }
    public int getFormat(){
        return this.format;
    }
    public void setFormat(int format){
        this.format = format;
    }
    public int getDocumentType(){
        return this.documentType;
    }
    public void setDocumentType(int documentType){
        this.documentType = documentType;
    }
    public int getFaculty(){
        return this.faculty;
    }
    public void setFaculty(int faculty){
        this.faculty = faculty;
    }
}

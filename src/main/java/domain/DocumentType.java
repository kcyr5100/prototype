package domain;

public class DocumentType {
    private int id;
    private String type;
    public DocumentType(int id, String type){
        this.id = id;
        this.type = type;
    }
    public int getId(){
        return this.id;
    }
    public String getType(){
        return this.type;
    }
}

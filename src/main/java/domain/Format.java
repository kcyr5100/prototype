package domain;

public class Format {
    private int id;
    private String format;
    public Format(int id, String format){
        this.id = id;
        this.format = format;
    }
    public String getFormat(){
        return this.format;
    }
    public int getId(){
        return this.id;
    }
}

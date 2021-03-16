package domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Search {
    private int userCode;
    private int documentCode;
    private String createdAt;

    public Search(int userCode, int documentCode, Date createdAt){
        this.userCode = userCode;
        this.documentCode = documentCode;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        this.createdAt = dateFormat.format(calendar.getTime());
    }

    public int getUserCode(){
        return this.userCode;
    }
    public void setUserCode(int userCode){
        this.userCode = userCode;
    }

    public int getDocumentCodeCode(){
        return this.documentCode;
    }
    public void setDocumentCodeCode(int documentCode){
        this.documentCode = documentCode;
    }
}

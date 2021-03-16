package domain;

public class Faculty {
    private int id;
    private String faculty;
    public Faculty(int id, String faculty){
        this.id = id;
        this.faculty = faculty;
    }
    public int getId(){
        return this.id;
    }
    public String getFaculty(){
        return this.faculty;
    }
}

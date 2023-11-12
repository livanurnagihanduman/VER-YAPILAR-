package collect;

public class Student {
    private String Name;
    private int Note;

    public Student(String Name ,int Note){
        this.Name = Name;
        this.Note = Note;
    }

    public String getName(){
        return Name;
    }
    public void Set(String Name){
        this.Name = Name;
    }
    public int getNote(){
        return Note;
    }
    public void setNote(int Note){
        this.Note = Note;
    }
}

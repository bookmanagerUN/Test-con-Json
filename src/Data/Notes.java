package Data;

import util.LinkedList;

public class Notes {

    String date = null;
    int page = 0;
    int paragraph = 0;
    String note = null;

    public Notes() {
        
    }

    public Notes(String date, int page, int paragraph, String note) {
        
        this.date = date;
        this.page = page;
        this.paragraph = paragraph;
        this.note = note;

    }
    
    LinkedList<Object> notes = new LinkedList<>();
    
    public LinkedList<Object> newNote(){
        
        notes.insertEnd(date);
        notes.insertEnd(page);
        notes.insertEnd(paragraph);
        notes.insertEnd(note);
        
        return notes;
        
    }
    public String paintNote(){
        return"{ *"+ this.date + "* , *" + this.page + "* , *" + this.paragraph + "* , *" + this.note + "* }"  ;
    }

}

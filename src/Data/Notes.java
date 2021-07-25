package Data;

import util.LinkedList;

public class Notes implements Comparable<Notes>{

    String date = null;
    int page = 0;
    int paragraph = 0;
    String note = null;

    public Notes() {
        
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getParagraph() {
        return paragraph;
    }

    public void setParagraph(int paragraph) {
        this.paragraph = paragraph;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LinkedList<Object> getNotes() {
        return notes;
    }

    public void setNotes(LinkedList<Object> notes) {
        this.notes = notes;
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
        return"{ Date: *"+ this.date + "* ,Page: *" + this.page + "* ,Paragraph: *" + this.paragraph + "* ,Note: *" + this.note + "* }"  ;
    }

    @Override
    public int compareTo(Notes other) {
        if(this.page>other.page)
            return 1;
        else if(this.page<other.page)
            return-1;
        else{
            if(this.paragraph>=other.paragraph)
                return 1;
            else
                return -1;
        }
            
    }

}
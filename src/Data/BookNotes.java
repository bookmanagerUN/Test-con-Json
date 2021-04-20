package Data;

import util.LinkedList;

public class BookNotes extends Notes {

    private int bookId = 0;
    
    private LinkedList<Notes> bookNotes;
    
    //setters
    public void setId(int newId){
        this.bookId= newId;
    }
    public void setBookNotes  (LinkedList<Notes> bookNotes){
        this.bookNotes= bookNotes;
    }
    //getters
    public int getId(){
        return this.bookId;
    }
    public LinkedList<Notes> getBookNotes(){
        return this.bookNotes;
    }
    
    
    public BookNotes() {
    }

    public BookNotes(int bookId) {
        System.out.println("Data.BookNotes.<init>()");
        bookNotes= new LinkedList<Notes>();
        this.bookId = bookId;
    }
    
    public BookNotes(int bookId,LinkedList<Notes> bookNotes) {
        this.bookNotes= bookNotes;
        this.bookId = bookId;
    }
    
    public void addNote(Notes newNote){
        this.bookNotes.insertEnd(newNote);
    }
    
    public String paintBookNotes(){
        //add note to string into a note
        String s = " {";
        for(int i = 0; i<this.bookNotes.count;i++){
            s= s + " [" + this.bookNotes.elementPosition(i).paintNote()+ "] ";
        }
        s = s+ "} ";
        return " [ *"+ this.bookId+ "* , *"+ s +"* ]";
    }
    
    //

}

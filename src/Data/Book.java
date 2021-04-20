package Data;

import util.LinkedList;

public class Book {

    private int actualPage  = 0;
    private boolean status  = false;
    private BookInformation bookInformation;
    private BookNotes notes ;
    
    //setters
    public void  setActualPage(int newPage){
        this.actualPage = newPage;
        //update txt
    }
    public void setStatus (boolean newStatus){
        this.status = newStatus;
        //update txt
    }
    public void setBookInformation(BookInformation newBookInformation){
        this.bookInformation = newBookInformation;
        
        //Update txt
    }
    public void setNotes(BookNotes newNotes){
        this.notes=newNotes;
        //update txt
    }
    //Getters
    public int getActualPage(){
        return this.actualPage;
    }
    public boolean getStatus(){
        return this.status;
    }
    public BookInformation getBookInformation(){
        return  this.bookInformation;
    }
    public BookNotes getNotes(){
        return this.notes;
    }
    

    //constructors


    //created by user
    public Book(BookInformation bI, MyBooks myBooks) {
        //System.out.println("Information.Book.<init>()");
        
        //book info
        this.bookInformation = bI;
        
        //default values:
        this.actualPage = 0;
        this.notes = new BookNotes(this.bookInformation.getId());
        this.status = false;
        //update list of books:
        myBooks.insertBook(this);
        
        //update txt  
    }
    //created by Json
    public Book(BookInformation bookInformation, BookNotes bookNotes, int actualPage, boolean status) {
        System.out.println("Data.Book.<init>()");
        this.bookInformation = bookInformation;
        this.actualPage = actualPage;
        this.notes = bookNotes;
        this.status = status;
          
    }
    
    

    public Book(int actualPage) {
        this.actualPage = actualPage;
    }
    
    public Book(boolean status) {
        this.status = status;
    }

    public Book(String name, String date, int page, int paragraph, String note) {
        
        //libro con name
        //booknotes
    }
    
    
    // methods
    
    
    public void printBook (){
        System.out.println("Information.Book.printBook()");
        
        String cadena = "[" + this.actualPage + "], "+"[" + this.status + "], "+ this.bookInformation.printBookInformation()+","+ this.notes.paintBookNotes();
        System.out.println(cadena);
    }
    public void /*nameClass*/ toJson(){
        actualPage = this.actualPage;
        status =this.status;
        int id = this.bookInformation.getId();
        //.....
        
        
        //return new nameClass(actualPage.....)
        
    }
    
    
    
}

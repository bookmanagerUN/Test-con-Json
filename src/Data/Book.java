package Data;

import util.LinkedList;

public class Book {
    
    private int actualPage  = 0;
    private boolean status  = false;
    private BookInformation bookInformation;
    private BookNotes notes ;
    private String opinion = "";
    //TODO opinion
    //TODO colocar el ID en esta clase y sacarla de BookInformation
    //metodo para calcular el ID teniendo en cuenta la posición en la que este de la lista
    
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
    public void setOpinion(String opinion){
        this.opinion = opinion;
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
    public String getOpinion (){
        return this.opinion;
    }
    

    //constructors


    //created by user
    public Book(BookInformation bI, MyBooks myBooks) {
        //System.out.println("Information.Book.<init>()");
        
        //book info
        this.bookInformation = bI;
        
        //default values:
        this.actualPage = 0;
        this.notes = new BookNotes();
        this.status = false;
        //update list of books:
        myBooks.insertBook(this);
        
        //update txt  
    }
    //created by Json
    public Book(BookInformation bookInformation, BookNotes bookNotes, int actualPage, boolean status,String opinion) {
        //System.out.println("Data.Book.<init>()");
        this.bookInformation = bookInformation;
        this.actualPage = actualPage;
        this.notes = bookNotes;
        this.status = status;
        this.opinion = opinion;
          
    }
    // if the book do not have opinion
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
        
        String cadena = "actual page:[ " + this.actualPage + " ], "+"status: [" + this.status + "], Book information: "+ this.bookInformation.printBookInformation()+", Book Notes: "+ this.notes.paintBookNotes()+ ", "+"Opinion: [" + this.opinion + "]"; 
        System.out.println(cadena);
    }
    public void /*nameClass*/ toJson(){
        actualPage = this.actualPage;
        status =this.status;
        //int id = this.bookInformation.getId();
        //.....
        
        
        //return new nameClass(actualPage.....)
        
    }
    
    
    
}

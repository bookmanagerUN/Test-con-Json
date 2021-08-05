

package Data;

import util.Graphs;
import util.LinkedList;

/**
 *
 * @author Usuario
 */
public class MyBooks {
    private LinkedList<Book> myBooks;
    private Graphs<String> dependences = new Graphs<>();

    //Setters
    
    // should not be used
    public void setMyBooks(LinkedList<Book> myBooks){
        this.myBooks=myBooks;
    }
    
    // Getters
    public LinkedList<Book> getMyBooks(){
        return this.myBooks;
    }
    
    //Constructors
    
    //new sesion
    public MyBooks() {
        this.myBooks = new LinkedList<Book>();
        defaultGraph();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        
    }
    // read txt
    public MyBooks(LinkedList<Book> myBooks){
        System.out.println("Data.MyBooks.<init>()");
        this.myBooks = myBooks;
        defaultGraph();
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        //updateAllId();
    }
    
    //methods
    public void insertBook(Book book){
        int lastId = this.myBooks.getTail().id;
        book.id = lastId+1;
        getMyBooks().insertEnd(book);
        
        //updateAllId();
        //update txt
     
    }
    public void deleteBook (int bookPosition){
        this.myBooks.deletePosition(bookPosition);
        //updateAllId();
    }
    /*
    public void updateAllId(){
        for (int i = 0; i< this.myBooks.count;i++)
            this.myBooks.elementPosition(i).getBookInformation().setId(i);
    }
    */
    public void printAllBooks(){
        System.out.println("Data.MyBooks.printAllBooks()");
        for(int i= 0; i< this.myBooks.count;i++){
            this.myBooks.elementPosition(i).printBook();
        }

        
    }
    private boolean checkID(Book book, int id){
        if(book.getId() == id){
            return true;
        }
        else{
            return false;
        }
    }
    private void defaultGraph(){
        this.dependences.addVertex("Discretas 1");
        this.dependences.addVertex("Discretas 2");
        this.dependences.addVertex("Discretas 3");
        this.dependences.addVertex("Discretas 4");
        this.dependences.addVertex("Algoritmos 1");
        this.dependences.addVertex("Algoritmos 2");
        this.dependences.addVertex("Algoritmos 3");
        
        this.dependences.addEdge("Discretas 2", "Discretas 1");
        this.dependences.addEdge("Discretas 3", "Discretas 2");
        this.dependences.addEdge("Discretas 4", "Discretas 3");
        this.dependences.addEdge("Discretas 1", "Algoritmos 2");
        this.dependences.addEdge("Algoritmos 2", "Algoritmos 1");
        
        
        System.out.println(dependences.getGraph().toString());
    }
    
    public Book getBookById(int id){
        for(int i = 0; i< this.myBooks.count;i++){
            Book currBook = this.myBooks.elementPosition(i);
            if(checkID(currBook, id)){
                return currBook;
            }
        }
        return null;
        
    }
    public void /*ClassName[]*/ toJason(){
        for(int i =0;i<this.myBooks.count;i++){
            
            //ClassName[this.myBook.count] newArray;
            //newarray.apend(this.myBook.getDato(i).toJason)
            
            
        }
        
        //return newArray
        
    }
    
}

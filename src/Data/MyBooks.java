

package Data;

import util.LinkedList;

/**
 *
 * @author Usuario
 */
public class MyBooks {
    private LinkedList<Book> myBooks;

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
    }
    // read txt
    public MyBooks(LinkedList<Book> myBooks){
        System.out.println("Data.MyBooks.<init>()");
        this.myBooks = myBooks;
    }
    
    //methods
    public void insertBook(Book book){
        
        getMyBooks().insertEnd(book);
        //update txt
     
    }
    public void printAllBooks(){
        System.out.println("Data.MyBooks.printAllBooks()");
        for(int i= 0; i< this.myBooks.count;i++){
            this.myBooks.elementPosition(i).printBook();
        }
        
    }
    public void /*ClassName[]*/ toJason(){
        for(int i =0;i<this.myBooks.count;i++){
            
            //ClassName[this.myBook.count] newArray;
            //newarray.apend(this.myBook.getDato(i).toJason)
            
            
        }
        
        //return newArray
        
    }
    
}

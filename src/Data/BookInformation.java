package Data;

import util.LinkedList;

public class BookInformation {
    
    //el ID debería sacarse de bookInformation y ponerse en Book
    int id = 0;
    String name = null;
    String author = null;
    String category = null;
    String isbn = null;
    
    //Setters
    public void setName(String newName){
        this.name=newName;
    }
    public void setAuthor(String newAuthor){
        this.author= newAuthor;
    }
    public void setCategory(String newCategory){
        this.category=newCategory;
    }
    public void setIsbn(String NewIsbn){
        this.isbn=NewIsbn;
    }
    public void setId(int newId){
        this.id = newId;
    }
    
    // Getters
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getCategory(){
        return this.category;
    }
    public int getId (){
        return this.id;
    }
    public String getIsbn(){
        return this.isbn;
    }
    
    public BookInformation(){
        
    }
    //created by interface
    public BookInformation(int id, String name, String author, String category, String isbn) {
        System.out.println("Information.BookInformation.<init>()");
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        //update txt
        
    } 
    public String printBookInformation(){
        //System.out.println("Information.BookInformation.printBookInformation()");
        
        String cadena = "[ Name: *" +
            this.name     + "* Id: *" +
            this.id       + "* Author: *" +
            this.author   + "* Category: *" +
            this.category + "* ISBN *" +
            this.isbn     + "*]";
        
        return cadena;
    }
    

    //bookinformation[id, name, author, category]
    LinkedList<Object> bookInformation = new LinkedList<>();

    public LinkedList<Object> bookInformation() {

        bookInformation.insertEnd(id);
        bookInformation.insertEnd(name);
        bookInformation.insertEnd(author);
        bookInformation.insertEnd(category);
        bookInformation.insertEnd(isbn);

        return bookInformation;
    }
    

}

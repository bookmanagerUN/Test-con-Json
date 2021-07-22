/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Data.Book;

/**
 *
 * @author Usuario
 */
public class BookFilterName  implements Comparable<BookFilterName>{
    public String name;
    public String author;
    public String category;
    public int page;
    public boolean status;
    
    public BookFilterName(Book book){
        this.author = book.getBookInformation().getAuthor();
        this.category = book.getBookInformation().getCategory();
        this.name = book.getBookInformation().getName();
        this.page = book.getActualPage();
        this.status = book.getStatus();
    }
    
    
    @Override
    public int compareTo(BookFilterName toCompare){
        if (this.name != toCompare.name){
            return this.name.compareTo(toCompare.name);
        }
        else{
            if(this.author != toCompare.author){
                return this.author.compareTo(toCompare.author);
            }
            else{
                if (this.category != toCompare.category){
                    return  this.category.compareTo(toCompare.category);
                }
                else{
                    if(this.page!= toCompare.page){
                        if(this.page < toCompare.page) return -1;
                        else if (this.page > toCompare.page) return 1;
                    }
                }
            }
        }
        return 0;
    }
    
    public String toString(){
        return "{nombre: " + this.name +" autor: "+ this.author + " categoria: "+ this.category + " page: " + this.page + " status: " + this.status +"}";
    }
    
}

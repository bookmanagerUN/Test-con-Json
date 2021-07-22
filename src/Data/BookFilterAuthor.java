/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Usuario
 */
public class BookFilterAuthor extends BookFilterName{
    
    public BookFilterAuthor(Book book) {
        super(book);
    }
    
    public int compareTo(BookFilterAuthor toCompare){
        if (this.author != toCompare.author){
            return this.name.compareTo(toCompare.name);
        }
        else{
            if(this.name != toCompare.name){
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
    
}

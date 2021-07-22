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
public class BookFilterCategory extends  BookFilterAuthor{
    public BookFilterCategory(Book book){
        super(book);
    }
    
    @Override
    public int compareTo(BookFilterAuthor toCompare){
        if (this.category != toCompare.category){
            return this.name.compareTo(toCompare.name);
        }
        else{
            if(this.name != toCompare.name){
                return this.author.compareTo(toCompare.author);
            }
            else{
                if (this.author != toCompare.author){
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

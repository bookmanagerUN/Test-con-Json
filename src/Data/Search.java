/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import util.treeStructures.AVLTree;
import util.LinkedList;
import Data.MyBooks;

/**
 *
 * @author Usuario
 */
public class Search {
    String text;
    MyBooks myBooks;
    AVLTree<BookFilter> booksFilter;
    public Search(String text, MyBooks myBooks){
        this.text = text.toLowerCase();
        this.myBooks = myBooks;
        this.booksFilter = new AVLTree<>();
        findCoincidences();
        booksFilter.inorder();
    }
    public void findCoincidences(){
        for (int i = 0; i < this.myBooks.getMyBooks().count; i++) {
            Book actualBook = this.myBooks.getMyBooks().elementPosition(i);
            if(match(actualBook)){
                this.booksFilter.insert(BookToBookFilter(actualBook));
            }
        }
    }
    boolean match(Book book){
        if(book.getBookInformation().getName().toLowerCase().contains(this.text)){
            return true;
        }
        else{
            return false;
        }
            
    }
    
    public BookFilter BookToBookFilter(Book book){
        return new BookFilter(book);
    }
    
 
}

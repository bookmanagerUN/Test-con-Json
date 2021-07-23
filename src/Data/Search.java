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
    AVLTree<BookFilterName> booksFilter;
    //param  = 0 filter by name ; = 1 filter by Author; other Filter by category
    int param;
    public Search(String text, MyBooks myBooks, int param){
        this.text = text.toLowerCase();
        this.myBooks = myBooks;
        this.booksFilter = new AVLTree<>();
        this.param = param;
        System.out.println(this.text +" "+ this.param);
        findCoincidences();
        System.out.println(toLinkedList().toString());
        booksFilter.inorder();
    }
    public LinkedList<BookFilterName> toLinkedList(){
        return this.booksFilter.inorderToLinkedList();
    }
    public void findCoincidences(){
        for (int i = 0; i < this.myBooks.getMyBooks().count; i++) {
            Book actualBook = this.myBooks.getMyBooks().elementPosition(i);
            
            if(this.param == 0){
                if(matchName(actualBook)){
                    this.booksFilter.insert(BookToBookFilterName(actualBook));
                }
            }
            else if(this.param == 1){
               if(matchAuthor(actualBook)){
                    this.booksFilter.insert(BookToBookFilterAuthor(actualBook));
                }
            }
            else{
                if(matchCategory(actualBook)){
                    this.booksFilter.insert(BookToBookFilterCategory(actualBook));
                }
            }
                
            
        }
    }
    
    boolean matchName(Book book){
        if(book.getBookInformation().getName().toLowerCase().contains(this.text)){
            return true;
        }
        else{
            return false;
        }
            
    }
    boolean matchAuthor(Book book){
        if(book.getBookInformation().getAuthor().toLowerCase().contains(this.text)){
            return true;
        }
        else{
            return false;
        }
            
    }
    boolean matchCategory(Book book){
        if(book.getBookInformation().getCategory().toLowerCase().contains(this.text)){
            return true;
        }
        else{
            return false;
        }
            
    }
    
    public BookFilterName BookToBookFilterName(Book book){
        return new BookFilterName(book);
    }
    public BookFilterAuthor BookToBookFilterAuthor(Book book){
        return new BookFilterAuthor(book);
    }
    public BookFilterCategory BookToBookFilterCategory(Book book){
        return  new BookFilterCategory(book);
    }
    
 
}

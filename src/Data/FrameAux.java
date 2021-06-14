/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Interface.BookInfoFrame;
import Interface.FilterBooksFrame;
import Interface.MainFrame;
import Interface.NewBookFrame;
import Interface.NewNoteFrame;
import Interface.ReportFrame;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class FrameAux {
    
    private int typeOfFrame;
    /*
    typeOfFrame = 1 : MainFrame
    typeOfFrame = 2 : BookInfoFrame
    typeOfFrame = 3 : NewBookFrame
    typeOfFrame = 4 : NewNoteFrame
    typeOfFrame = 5 : FilterBooksFrame
    typeOfFrame = 6 : ReportFrame
    */
    private MyBooks myBooks;
    private Book book;

    public FrameAux(int typeOfFrame, MyBooks mybooks) {
        this.book = null;
        this.myBooks = myBooks;
        this.typeOfFrame = typeOfFrame;
    }

    public FrameAux (int typeOfFrame,MyBooks myBooks, Book book){
        this.book = book;
        this.myBooks = myBooks;
        this.typeOfFrame = typeOfFrame;
    }

    public int getTypeOfFrame() {
        return typeOfFrame;
    }

    public MyBooks getMyBooks() {
        return myBooks;
    }

    public Book getBook() {
        return book;
    }
    
    /*
    typeOfFrame = 1 : MainFrame
    typeOfFrame = 2 : BookInfoFrame
    typeOfFrame = 3 : NewBookFrame
    typeOfFrame = 4 : NewNoteFrame
    typeOfFrame = 5 : FilterBooksFrame
    typeOfFrame = 6 : ReportFrame
    */
    /*
    public JFrame generateFrame (){
        if(typeOfFrame == 1){
            return new MainFrame(this.myBooks);
        }
        else if (typeOfFrame == 2) {
            
            return new BookInfoFrame(this.book, this.myBooks);
        }
        else if (typeOfFrame == 3) {
            
            return new NewBookFrame(this.myBooks);
        }
        else if (typeOfFrame == 4) {
            
            return new NewNoteFrame(this.myBooks, this.book);
        }
        else if (typeOfFrame == 5) {
            
            return new FilterBooksFrame();
        }
        else if (typeOfFrame == 6) {
            
            return new ReportFrame(this.myBooks);
        }
        return null;
        
    }*/
    
    
}

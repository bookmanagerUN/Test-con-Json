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
public class FrameAux {
    
    private int typeOfFrame;
    /*
    typeOfFrame = 1 : MainFrame
    typeOfFrame = 2 : BookInfoFrame
    typeOfFrame = 3 : NewBookFrame
    typeOfFrame = 4 : NewNoteFrame
    typeOfFrame = 5 : AdviceFrame
    typeOfFrame = 6 : FilterFrame
    typeofFrame = 7 : Requirements
    */
    private MyBooks myBooks;
    private Book book;
    private UserFinal user;

    public FrameAux(int typeOfFrame, MyBooks myBooks,UserFinal user) {
        this.user = user;
        this.book = null;
        this.myBooks = myBooks;
        this.typeOfFrame = typeOfFrame;
    }

    public FrameAux (int typeOfFrame,MyBooks myBooks, Book book, UserFinal user){
        this.user = user;
        this.book = book;
        this.myBooks = myBooks;
        this.typeOfFrame = typeOfFrame;
    }

    public int getTypeOfFrame() {
        return this.typeOfFrame;
    }

    public MyBooks getMyBooks() {
        return this.myBooks;
    }

    public Book getBook() {
        return this.book;
    }
    
    public UserFinal getUser(){
        return this.user;
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

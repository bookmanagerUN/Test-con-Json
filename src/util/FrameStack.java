/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import Data.FrameAux;
import Data.MyBooks;
import javax.swing.JFrame;
import Interface.BookInfoFrame;
import Interface.FilterBooksFrame;
import Interface.MainFrame;
import Interface.NewBookFrame;
import Interface.NewNoteFrame;
import Interface.ReportFrame;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class FrameStack {
    Stacks<FrameAux> stackFrame = new Stacks<>();
    
    public FrameStack(MyBooks mybooks){
        // Ventana principal
        FrameAux frame = new FrameAux(1, mybooks);
        stackFrame.push(frame);
        
        
}   

    public Stacks getStackFrame() {
        return stackFrame;
    }
    
    public JFrame generateFrame (){
        if(this.stackFrame.peek().getTypeOfFrame() == 1){
            return new MainFrame(this.stackFrame.peek().getMyBooks(), this);
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 2) {
            return new BookInfoFrame(this.stackFrame.peek().getBook(), this.stackFrame.peek().getMyBooks(),this);
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 3) {
            return  new NewBookFrame(this.stackFrame.peek().getMyBooks(), this);
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 4) {
            return new NewNoteFrame( this.stackFrame.peek().getMyBooks(),this.stackFrame.peek().getBook(),this);
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 5) {
            return  new FilterBooksFrame();
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 6) {
            return  new ReportFrame(this.stackFrame.peek().getMyBooks(), this);
        }
        
        return null;
    }
    
}

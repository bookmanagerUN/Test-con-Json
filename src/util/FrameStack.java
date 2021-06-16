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
    Stacks<FrameAux> stackFrameNext = new Stacks<>();
    
    public FrameStack(MyBooks mybooks){
        
        System.out.println(mybooks.toString());
        // Ventana principal
        FrameAux frame = new FrameAux(1, mybooks);
        System.out.println(frame.getMyBooks().toString());
        
        
        stackFrame.push(frame);
        System.out.println(stackFrame.peek().getMyBooks().toString());

}   
    public void readStack(){
        for(int i=0;i<stackFrame.count;i++){
            System.out.print(stackFrame.elementPosition(i).getTypeOfFrame()+ " ");
        }
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
    public void pop(){
        FrameAux frame = this.stackFrame.pop();
        stackFrameNext.push(frame);
    }
    public void nextToNormal(){
        FrameAux frame = this.stackFrameNext.pop();
        stackFrame.push(frame);
    }
    public void cleanNextStack(){
        this.stackFrameNext.makeEmpty();
    }

    public Stacks<FrameAux> getStackFrameNext() {
        return stackFrameNext;
    }
    
}

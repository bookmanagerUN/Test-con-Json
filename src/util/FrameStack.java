/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import Data.FrameAux;
import Data.MyBooks;
import Data.UserFinal;
import Interface.AdviceFrame;
import javax.swing.JFrame;
import Interface.BookInfoFrame;
import Interface.FilterBooksFrame;
import Interface.FilterFrame;
import Interface.MainFrame;
import Interface.NewBookFrame;
import Interface.NewNoteFrame;
import Interface.ReportFrame;
import Interface.Requirements;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class FrameStack {
    MyStack<FrameAux> stackFrame = new MyStack<>();
    MyStack<FrameAux> stackFrameNext = new MyStack<>();
    
    public FrameStack(MyBooks mybooks, UserFinal user){
        
        System.out.println(mybooks.toString());
        // Ventana principal
        FrameAux frame = new FrameAux(1, mybooks,user);
        System.out.println(frame.getMyBooks().toString());
        
        
        stackFrame.push(frame);
        System.out.println(stackFrame.peek().getMyBooks().toString());

}   
    public void readStack(){
        for(int i=0;i<stackFrame.count;i++){
            System.out.print(stackFrame.elementPosition(i).getTypeOfFrame()+ " ");
        }
    }

    
    public MyStack getStackFrame() {
        return stackFrame;
    }
    
    public JFrame generateFrame (){
        if(this.stackFrame.peek().getTypeOfFrame() == 1){
            return new MainFrame(this.stackFrame.peek().getMyBooks(), this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 2) {
            return new BookInfoFrame(this.stackFrame.peek().getBook(), this.stackFrame.peek().getMyBooks(),this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 3) {
            return  new NewBookFrame(this.stackFrame.peek().getMyBooks(), this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 4) {
            return new NewNoteFrame( this.stackFrame.peek().getMyBooks(),this.stackFrame.peek().getBook(),this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 5) {
            return  new AdviceFrame(this.stackFrame.peek().getMyBooks(),this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 6) {
            return  new FilterFrame(this.stackFrame.peek().getMyBooks(), this,this.stackFrame.peek().getUser());
        }
        else if (this.stackFrame.peek().getTypeOfFrame() == 7) {
            return  new Requirements(this.stackFrame.peek().getMyBooks(), this,this.stackFrame.peek().getUser());
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

    public MyStack<FrameAux> getStackFrameNext() {
        return stackFrameNext;
    }
    
}

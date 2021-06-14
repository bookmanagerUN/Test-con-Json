/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import Data.FrameAux;
import Data.MyBooks;


/**
 *
 * @author admin
 */
public class FrameStack {
    
    public FrameStack(MyBooks mybooks){
        // Ventana principal
        FrameAux frame = new FrameAux(1, mybooks);
        stackFrame.push(frame);
        
}   

    public Stacks getStackFrame() {
        return stackFrame;
    }
    Stacks <FrameAux>stackFrame = new Stacks<>();
    

    
    
}

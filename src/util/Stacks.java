/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author admin
 */
public class Stacks<TypeOfData> extends LinkedList<TypeOfData>{
    
    public void push(TypeOfData data){
        super.insertEnd(data);
    }
    
    public TypeOfData pop(){
        TypeOfData elem = this.tail.data;
        super.deleteEnd();
        return elem;
    }
    public TypeOfData peek(){
        if(this.count ==0){
            return null;
        }else{
            return this.tail.data;
        }
    }
}

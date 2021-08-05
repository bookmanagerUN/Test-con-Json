/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Santiago y Diego
 */
public class UserName {
    private final String name;
    
    public UserName(String name){
        this.name=name;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public int hashCode(){
        char[] arr = this.name.toCharArray();
        int sum=0;
        for(char val : arr)
            sum+=val;
        return Math.abs(sum-6*32)+Math.abs(this.name.toCharArray()[0]-32);
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof UserName){
            UserName other = (UserName) o;
            return this.name.equals(other.name);
        }else
            return false;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}

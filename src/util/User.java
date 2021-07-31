/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


/**
 *
 * @author Diego Quintero
 */
public class User {
    private final String name;
    private final String email;
    private final String password;
    
    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    @Override
    public int hashCode(){
        char[] arr = this.password.toCharArray();
        int sum=0;
        for(char val : arr)
            sum+=val;
        return Math.abs(sum-192)+Math.abs(this.name.toCharArray()[0]-32);
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            User other = (User) o;
            return (this.name.equals(other.name) || this.email.equals(other.email)) 
                    && this.password.equals(other.password);
        }else
            return false;
    }
    
    @Override
    public String toString(){
        return this.name+"-"+this.email+"-"+this.password;
    }
}

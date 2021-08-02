
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class readTxt {
    
    public static void createTxt(String[] content) throws IOException{
        int size= content.length;
        FileWriter file = new FileWriter("users.txt");
   
        for(int i =0; i<content.length;i++ ){
        file.write(content[i]+"\n");
        }
        file.close();
        
        
    }
    public static void updateTxt(String cadena, boolean x) throws IOException{
        FileWriter file = new FileWriter("users.txt",x);
       
        file.write(cadena+"\n");
        file.close();
        
    }
    public static LinkedList<String> ReadTxt() throws FileNotFoundException, IOException{
       
      FileReader f = new FileReader("users.txt");
     
      BufferedReader b = new BufferedReader(f);
     
      LinkedList<String> list = new LinkedList<>();
      String cadena;
      while(( cadena= b.readLine())!=null) {
          list.insertEnd(cadena);
          
      }
      b.close();
      return list;
      
    }
    public static void main(String[] args) throws IOException {
        String[] savedUsers = new String[]{"Daniel,Daniel@user.com,12345,LibrosPrueba.json",
                                           "Jorge,Jorge@user.com,12345,LibrosPrueba.json",
                                           "Cristian,Cristian@user.com,12345,LibrosPrueba.json",
                                           "Brian,Brian@user.com,12345,LibrosPrueba.json",
                                           "Carlos,Carlos@user.com,12345,LibrosPrueba.json",
                                           "Santiago,Santiago@user.com,12345,LibrosPrueba.json"};
        
        readTxt.createTxt(savedUsers);
       readTxt.createTxt(savedUsers);
        LinkedList<String> cadenas = readTxt.ReadTxt();
        System.out.println(cadenas.toString());
        
      
        cadenas = readTxt.ReadTxt();
        System.out.println(cadenas.toString());
        
        
    }
    
    
    
    
}

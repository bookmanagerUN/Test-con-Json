
package util;

import Data.MyBooks;
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
    
    public static void updateTxt(String insertedUser,String insertedEmail,String insertedPassword, boolean x) throws IOException{
        String usuario = insertedUser+","+insertedEmail+","+insertedPassword+","+insertedUser+".json";
        FileWriter file = new FileWriter("users.txt",x);
        file.write(usuario+"\n");
        file.close();
        readTxt.createJson(insertedUser+".json");
        
    }
    
    public static void createJson(String nameFile)throws IOException{
        WriteJson.createNewJson(nameFile);
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
    
    public static void createGraphTxt(String archivo) throws IOException{
        String f = archivo + ".txt";
        Graphs<String> aux = MyBooks.defaultGraph();
        LinkedList<String> hashTableToLL = aux.getGraph().toTxt();
        FileWriter file = new FileWriter("requisitos/"+f);
        for(int i=0; i<hashTableToLL.numberOfElements(); i++){
            String[] toSave = hashTableToLL.elementPosition(i).split("=");
            file.write(toSave[0]+"||"+toSave[1]+"\n");           
        }        
        file.close();       
        
    }
    
    public static void updadeGraphTxt(){
        
    }
    
    public static void readGraphTxt(){
        
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

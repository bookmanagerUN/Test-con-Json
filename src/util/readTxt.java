
package util;

import Data.MyBooks;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

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
        System.out.println(hashTableToLL.toString());
        FileWriter file = new FileWriter("requisitos/"+f);
        System.out.println("pppppppppppppppppppppaaaaaaaaaaaaaaaaaaaaaaaaaa");
        for(int i=0; i<hashTableToLL.numberOfElements(); i++){
            //System.out.println(hashTableToLL.elementPosition(i));
            String[] toSave = hashTableToLL.elementPosition(i).split("=");
            //System.out.println(Arrays.toString(toSave));
            file.write(toSave[0]+"-"+toSave[1]+"\n");           
        }        
        file.close();       
        
    }
    
    public static void updadeGraphTxt(String archivo,Graphs graph) throws IOException{
        
        String f = archivo + ".txt";
        Graphs<String> aux = graph;
        LinkedList<String> hashTableToLL = aux.getGraph().toTxt();
        //System.out.println(hashTableToLL.toString());
        FileWriter file = new FileWriter("requisitos/"+f);
        //System.out.println("pppppppppppppppppppppaaaaaaaaaaaaaaaaaaaaaaaaaa");
        for(int i=0; i<hashTableToLL.numberOfElements(); i++){
            //System.out.println(hashTableToLL.elementPosition(i));
            String[] toSave = hashTableToLL.elementPosition(i).split("=");
            //System.out.println(Arrays.toString(toSave));
            file.write(toSave[0]+"-"+toSave[1]+"\n");           
        }        
        file.close();      
        
    }
    
    public static HashTable<String, LinkedList<String>> readGraphTxt(String nameFile) throws IOException{
        FileReader f = new FileReader(nameFile);

        BufferedReader b = new BufferedReader(f);
        HashTable auxTable = new HashTable<String, LinkedList<String>>();
        
        
        String cadena;
        System.out.println("aaaaaaaaaaaaaaasssssssssssssssddddddddddddddddd");
        while(( cadena= b.readLine())!=null) {
            System.out.println(cadena);
            String[] line = cadena.split("\\-");
            System.out.println(Arrays.toString(line));
            String key = line[0];
            //System.out.println(key);
            LinkedList<String> valueList;
            System.out.println(line[1].length());
            if(line[1].length() == 1){
                System.out.println("nunca esta entrando :(((((((((");
                valueList = new LinkedList<>();
            }
            else{
                String[] valueArr = line[1].split(", ");
                valueList = new LinkedList<>(valueArr);
                //System.out.println(valueList.toString());
            }
            auxTable.insert(key, valueList);
            

        }
        b.close();
        System.out.println(auxTable.toString());
        return auxTable;
        
    }
    public static LinkedList<String> listOfRequirements(String nameFile) throws FileNotFoundException, IOException{
        FileReader f = new FileReader(nameFile);

        BufferedReader b = new BufferedReader(f);
        LinkedList<String> listofVertex = new LinkedList<>();
        
        
        String cadena;
        System.out.println("aaaaaaaaaaaaaaasssssssssssssssddddddddddddddddd");
        while(( cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            String[] line = cadena.split("\\-");
            //System.out.println(Arrays.toString(line));
            String key = line[0];
            listofVertex.insertEnd(key);
        }
        b.close();
        return listofVertex;
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

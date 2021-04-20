package Book;

import java.util.Scanner;

public class Book {
    
    public void MyBooks(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1) Lista de libros");
        System.out.println("2) Añadir nuevo libro");
        
        int option = sc.nextInt();
        //test push branch-santiago
        
              
        switch(option){
            case 1:
                //Show book
                break;
            case 2:
                //New Book
                break;   
        }
        
        //despliega la lista de libros
            //Al selecionar un libro me lleva a ver su informacion
        //A;adir nuevo libro
    }
    
    
    
}

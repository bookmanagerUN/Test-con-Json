package Book;

import java.util.Scanner;

public class NewBook {
    
    public void addBook(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nombre");
        String name = null;
        try{
            name = sc.nextLine();
        }
        catch(Exception e){
            System.err.println("El campo esta vacio");
            while(name == null){
                name = sc.nextLine();
            }                        
        }
        System.out.println("Autor");
        String author = null;
        try{
            author = sc.nextLine();
        }
        catch(Exception e){
            System.err.println("El campo esta vacio");
            while(author == null){
                author = sc.nextLine();
            }                        
        }
        System.out.println("ISBN");
        try{
            int isbn = sc.nextInt();
        }
        catch(Exception e){
            int isbn = -1;
        }   
        System.out.println("Categoria");
        String category = null;
        try{
            category = sc.nextLine();
        }
        catch(Exception e){
            System.err.println("El campo esta vacio");
            while(category == null){
                category = sc.nextLine();
            }                        
        }
        
        //añadir informacion a la lista********
    }
    
}

package util;

import Data.Book;
import Data.BookInformation;
import Data.BookNotes;
import Data.MyBooks;
import Data.Notes;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Test {
    public static void main(String[] args)throws IOException {
        //Creando libros

        BookInformation informacion1 = new BookInformation(1,"Caperucita",
                "anonimo","fabula","222200");
        BookNotes nota1 = new BookNotes(1);
        Book libro1 = new Book(informacion1, nota1, 0, true);
        libro1.getNotes().addNote(new Notes("", 69, 3,""));

        LinkedList<Book> listaLibros = new LinkedList<>();

        BookInformation informacion2 = new BookInformation(2,"Principito",
                "anonimo","Historia","22110");
        BookNotes nota2 = new BookNotes(2);
        Book libro2 = new Book(informacion2, nota2, 32, true);

        BookInformation informacion3 = new BookInformation(3,"La biblia",
                "Diosito","Religion","3335");
        BookNotes nota3 = new BookNotes(3);
        Book libro3 = new Book(informacion3, nota3, 40, false);


        //Insertar libros en linkedlist
        listaLibros.insertEnd(libro1);
        listaLibros.insertEnd(libro2);
        listaLibros.insertEnd(libro3);
        MyBooks biblioteca = new MyBooks(listaLibros);

        WriteJson writejson = new WriteJson();
        try {
            writejson.createAuxBook(biblioteca.getMyBooks());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadJson readJson = new ReadJson();
        try {
            //List<AuxBook> arrBooks = readJson.readJson();
            MyBooks myBooks = readJson.arrAuxToMyBooks(readJson.readJson());
            
            myBooks.printAllBooks();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //PruebaLombok reducir = new PruebaLombok();





    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Usuario
 */
public class ReadJson {
    //Trae un arraylist
    /*public List<AuxBook> readJson() throws FileNotFoundException {
        // LEER JSON
        Reader reader = new FileReader("LibrosPrueba.json");

        Type type = new TypeToken<Collection<AuxBook>>() {
        }.getType();


        List<AuxBook> result = WriteJson.gson.fromJson(reader, type);
        return result;
    }*/
    public MyBooks arrAuxToMyBooks(AuxBook[] auxBooks) {
        //System.out.println("util.ReadJson.arrAuxToMyBooks()");
        //save how many book they are
        int numberOfBooks = auxBooks.length;
        //System.out.println(numberOfBooks);
        //create a new linkedList object from books
        LinkedList<Book> listBooks = new LinkedList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            //insert all the books into the linkedlist
            listBooks.insertEnd(auxToBook(auxBooks[i], i));
        }
        //create a new MyBooks object from the last linked list
        MyBooks myBooks = new MyBooks(listBooks);
        return myBooks;
    }

    public Book auxToBook(AuxBook auxBook, int id) {
        //save the variable information of a book
        int actualPage = auxBook.getActualPage();
        boolean status = auxBook.getStatus();
        String opinion = auxBook.getOpinion();
        // Save the BookInformation object
        System.out.println(Arrays.toString(auxBook.getBookInformation()));
        BookInformation bookInformation = auxToBookInformation(auxBook);
        // Save the BookNotes object
        BookNotes bookNotes = auxToBookNotes(auxBook);
        //create a new Book object by all information of this method
        Book book = new Book(bookInformation, bookNotes, actualPage, status, opinion, id);

        return book;

    }

    // dificil mantenimiento, modificar clase auxBook
    public BookInformation auxToBookInformation(AuxBook auxBook) {
        //save all the book information 
        //double doble = (double) auxBook.getBookInformation()[0];
        //System.out.println();
        //int id = (int) Math.round((double) auxBook.getBookInformation()[0]);
        //em.out.println(id);
        System.out.println(Arrays.toString(auxBook.getBookInformation()));
        String name = (String) auxBook.getBookInformation()[0];
        String author = (String) auxBook.getBookInformation()[1];
        String category = (String) auxBook.getBookInformation()[2];
        String isbn = (String) auxBook.getBookInformation()[3];
        //create a new BookInformation object by the last information
        BookInformation bookInformation = new BookInformation(/*id,*/ name, author, category, isbn);


        return bookInformation;
        /*bookInformation.insertEnd(id);
        bookInformation.insertEnd(name);
        bookInformation.insertEnd(author);
        bookInformation.insertEnd(category);
        bookInformation.insertEnd(isbn);*/
    }


    //create the Book notes by an auxBook object
    public BookNotes auxToBookNotes(AuxBook auxBook) {
        //linked list were we are going to save the notes
        LinkedList<Notes> linkedNotes = new LinkedList<>();
        int numberNotes = Array.getLength(auxBook.getNotes());

        for (int i = 0; i < numberNotes; i++) {
            //add notes into the linked List
            linkedNotes.insertEnd(auxBook.getNotes()[i]);
        }
        //new BookNotes object by the last linked list
        BookNotes newBookNotes = new BookNotes(linkedNotes);
        return newBookNotes;
    }

    //Trae un arr
    public AuxBook[] readJson() throws FileNotFoundException {
        // LEER JSON
        System.out.println("util.ReadJson.readJson() inicio");
        
        Reader reader = new FileReader("LibrosPrueba.json");

        /* Type type = new TypeToken<Collection<AuxBook>>() {
        }.getType();*/
        
        
        AuxBook[] auxBooks = WriteJson.gson.fromJson(reader, AuxBook[].class);
        System.out.println("util.ReadJson.readJson() fin");

        return auxBooks;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.Book;
import Data.MyBooks;
import Data.Notes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class WriteJson {
    private AuxBook[] arrBook;

    private  MyBooks MyBook;


    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void createAuxBook(LinkedList<Book> myBook) throws IOException {
        System.out.println("util.WriteJson.createAuxBook()");
        int actualPage  ;
        boolean status  ;
        Object[] bookInformation;
        Notes[] notes ;
        int size;
        size= myBook.count;
        Node<Book> aux =myBook.head;
        arrBook = new AuxBook[size];

        for(int i=0; i<size;i++){

            actualPage = aux.data.getActualPage();
            status = aux.data.getStatus();
            bookInformation = informationToArr(aux.data.getBookInformation().bookInformation()) ;
            notes = notesToArr(aux.data.getNotes().getBookNotes());

            AuxBook auxBook = new AuxBook(actualPage,status,bookInformation,notes);
            arrBook[i] = auxBook;
            aux = aux.next;
        }
        createJson(arrBook);



    }
    public void createJson(AuxBook[] auxBooks) throws IOException {
        //CREAR JSON

        Writer writer = new FileWriter("LibrosPrueba.json");
        writer.write(gson.toJson(arrBook));
        writer.close();
    }

    public void crearjson(LinkedList<Book> myBook){

    }
    
    //dificil mantenimiento, es posible sacarse del array.
    public Object[] informationToArr(LinkedList<Object> bookInformation){
        Node<Object> aux = bookInformation.head;
        int size2 = bookInformation.count;
        Object[] arr = new Object[size2];
        int i=0;
        while (aux != null){
            arr[i] = aux.data;
            i +=1;
            aux = aux.next;
        }
        return arr;


    }
    public Notes[] notesToArr(LinkedList<Notes> bookNotes){
        Node<Notes> aux = bookNotes.head;
        int size2 = bookNotes.count;
        Notes[] arr = new Notes[size2];
        int i=0;
        while (aux != null){
            arr[i] = aux.data;
            i +=1;
            aux = aux.next;
        }
        return arr;
    }
    
}
/*
class AuxBook {
    private  int actualPage  ;
    private  boolean status  ;
    private  Object[] bookInformation;
    private  Notes[] notes ;

    public AuxBook(int actualPage, boolean status, Object[] bookInformation, Notes[] notes) {
        this.actualPage = actualPage;
        this.status = status;
        this.bookInformation = bookInformation;
        this.notes = notes;
    }

    public int getActualPage() {
        return actualPage;
    }

    public void setActualPage(int actualPage) {
        this.actualPage = actualPage;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object[] getBookInformation() {
        return bookInformation;
    }
    public void setBookInformation(Object[] bookInformation) {
        this.bookInformation = bookInformation;
    }
    public Notes[] getNotes() {
        return notes;
    }

    public void setNotes(Notes[] notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "AuxBook{" +
                "actualPage=" + actualPage +
                ", status=" + status +
                ", bookInformation=" + Arrays.toString(bookInformation) +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
*/
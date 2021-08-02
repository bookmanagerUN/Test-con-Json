/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.Book;
import Data.BookInformation;
import Data.MyBooks;
import Data.Notes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Usuario
 */
public class WriteJson {
    private AuxBook[] arrBook;

    private MyBooks MyBook;


    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void createAuxBook(LinkedList<Book> myBook, String file) throws IOException {
        System.out.println("util.WriteJson.createAuxBook()");
        int actualPage;
        boolean status;
        Object[] bookInformation;
        Notes[] notes;
        String opinion = "";
        int size;
        size = myBook.count;
        Node<Book> aux = myBook.head;
        arrBook = new AuxBook[size];

        for (int i = 0; i < size; i++) {

            actualPage = aux.data.getActualPage();
            status = aux.data.getStatus();
            bookInformation = informationToArr(aux.data.getBookInformation().bookInformation());
            notes = notesToArr(aux.data.getNotes().getBookNotes());
            opinion = aux.data.getOpinion();


            AuxBook auxBook = new AuxBook(actualPage, status, bookInformation, notes, opinion);
            arrBook[i] = auxBook;
            aux = aux.next;
        }
        createJson(arrBook, file);


    }

    public void createJson(AuxBook[] auxBooks, String file) throws IOException {
        //CREAR JSON

        Writer writer = new FileWriter(file);
        writer.write(gson.toJson(arrBook));
        writer.close();
    }
    public static void createNewJson(String nameFile) throws IOException {
        //CREAR JSON
        Writer writer = new FileWriter(nameFile);
        writer.write(gson.toJson(WriteJson.auxBooksArrTest(WriteJson.bookTest())));
        writer.close();
    }
    private static AuxBook[] auxBooksArrTest( Book test){
        System.out.println("||||||||||||");
        test.printBook();
        String bookInfo[] = new String[4];
        bookInfo[0]= test.getBookInformation().getName();
        bookInfo[1]= test.getBookInformation().getAuthor();
        bookInfo[2]= test.getBookInformation().getCategory();
        bookInfo[3]= test.getBookInformation().getIsbn();
        int actualPage = test.getActualPage();
        boolean status = test.getStatus();
        Notes[] notes = new Notes[0];
        String opinion = "este libro contiene las instrucciones para el manejo de la app";
        AuxBook auxBook[] = new AuxBook[1];
        auxBook[0]= new AuxBook(actualPage, status, bookInfo, notes, opinion);
        return auxBook;
    }
    private static MyBooks myBooksTest(){
        MyBooks myBooksTest = new MyBooks();
        myBooksTest.insertBook(WriteJson.bookTest());
        return myBooksTest;
    }
    
    private static Book bookTest(){
        return new Book(new BookInformation("Instructivo", "Servicio técnico Bookmanager", "instrucciones", "123ab54"));
    }
    
    public void crearjson(LinkedList<Book> myBook) {

    }

    //dificil mantenimiento, es posible sacarse del array.
    public Object[] informationToArr(LinkedList<Object> bookInformation) {
        Node<Object> aux = bookInformation.head;
        int size2 = bookInformation.count;
        Object[] arr = new Object[size2];
        int i = 0;
        while (aux != null) {
            arr[i] = aux.data;
            i += 1;
            aux = aux.next;
        }
        return arr;


    }

    public Notes[] notesToArr(LinkedList<Notes> bookNotes) {
        Node<Notes> aux = bookNotes.head;
        int size2 = bookNotes.count;
        Notes[] arr = new Notes[size2];
        int i = 0;
        while (aux != null) {
            arr[i] = aux.data;
            i += 1;
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
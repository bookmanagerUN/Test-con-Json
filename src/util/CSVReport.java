/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.Book;
import Data.Notes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import util.treeStructures.AVLTree;

/**
 *
 * @author Diego Quintero
 */
public class CSVReport {
    private AVLTree<Notes> notes;
    private Book book;
    private File file;
    private Writer writer;
    private FileOutputStream fos;
    private OutputStreamWriter osw;
    
    public CSVReport(Book book, String fileDestination) throws IOException{
        this.file = new File(fileDestination+".csv");
        this.fos = new FileOutputStream(this.file);
        this.osw = new OutputStreamWriter(this.fos);
        this.writer = new BufferedWriter(this.osw);
        
        this.notes=new AVLTree();
        this.book=book;
        this.buildTree();
        this.setReport(fileDestination);
    }
    
    public void buildTree(){
        LinkedList<Notes> notes = book.getNotes().getBookNotes();
        for(int i = 0; i<notes.numberOfElements();i++)
            this.notes.insert(notes.elementPosition(i));
    }
    
    private void setReport(String fileDestination) throws IOException{
        Function function = new Builder(fileDestination);
        writer.write("Book Manager CSV Report");
        writer.write("Name:"+this.book.getBookInformation().getName() + "\n");
        writer.write("Author:"+this.book.getBookInformation().getAuthor() + "\n");
        writer.write("ISBN:"+this.book.getBookInformation().getIsbn() + "\n");
        writer.write("Category:"+this.book.getBookInformation().getCategory() + "\n");
        writer.write("Opinion:"+this.book.getOpinion() + "\n");
        writer.write("\n");
        this.notes.inorder(function);
        writer.flush();
        writer.close();
        System.out.println("The CSV has been created successfully.");
    }


    private class Builder implements Function {
        String fileDestination;
        
        Builder(String fileDestination){
            this.fileDestination=fileDestination;
        }
        @Override
        public void function(Comparable... objects){
            try{
               Notes actualNote = (Notes) objects[0];
                writer.write(actualNote.getPage()+":"+
                                actualNote.getParagraph()+":"+
                                actualNote.getDate()+":"+
                                actualNote.getNote()+"\n");
                
                
            }catch(IOException e){
                throw new RuntimeException();
            }
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Diego Quintero
 */
import Data.Book;
import Data.Notes;
import java.io.IOException;

public class BookManagerReport extends EasyDocument {
    private Book book;
    private int notesNum;

    public BookManagerReport() throws IOException {
        super();
        this.setBlankReport();
    }
    public BookManagerReport(Book book, String fileDestination) throws IOException {
        super();
        this.book=book;
        setReport(fileDestination);
    }

    private void setReport(String fileDestination) throws IOException {
        notesNum = 0;
        this.bookTitle(book.getBookInformation().getName());
        this.author(book.getBookInformation().getAuthor());
        super.smallSkip();
        this.opinion(book.getOpinion() == null ? "" : book.getOpinion());
        for (int j = 0; j < book.getNotes().getBookNotes().numberOfElements(); j++) {
            Notes actualNote = book.getNotes().getBookNotes().elementPosition(j);
            super.smallSkip();
            this.note(actualNote.getNote(), actualNote.getDate(), actualNote.getPage(), actualNote.getParagraph());
        }

        this.setWatermark("src/Media/Watermark.pdf");
        super.export("src/Media/body.pdf");
        this.coverPage(fileDestination);
    }
    private void setBlankReport() throws IOException{
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit " +
                "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia " +
                "deserunt mollit anim id est laborum.";
        String opinion = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua.";

        for(int i=0;i<5;i++){
            notesNum=0;
            this.bookTitle("Lorem Ipsum");
            this.author("Marco Tulio Cicerón");
            super.smallSkip();
            this.opinion(opinion);
            for (int j=0;j<9;j++){
                super.smallSkip();
                this.note(loremIpsum,"00/00/00", 0,0);
            }
            if(i!=4) super.addPage();
        }
        this.setWatermark("src/Media/Watermark.pdf");
        super.export("src/Media/body.pdf");
        this.coverPage("D:/BlankReport.pdf");
    }

    private void setWatermark(String pdfName) throws IOException {
        super.overlay(pdfName,0);
    }
    private void bookTitle(String title) throws IOException {
        centerAligned();
            title(title);
    }
    private void author(String author) throws IOException {
        centerAligned();
            subTitleII(author, false);
    }
    private void opinion(String opinion) throws IOException{
        centerAligned();
            subTitleII("Opinion:", false);
            paragraph(opinion);
    }
    private void note(String note, String date, int page, int paragraph) throws IOException {
        leftAligned();
        setIndentation(0f);
            subTitleII("Note "+ ++notesNum, false);
        setIndentation(40f);
            subTitleIII("> " + date + " - Page: " + page + " - Paragraph: " + paragraph,false);
        setIndentation(15f);
            paragraph(note);
        setIndentation(0f);
    }
    private void coverPage(String fileDestination) throws IOException {
        super.merge(fileDestination,"src/Media/coverPage.pdf","src/Media/Body.pdf");
    }
}

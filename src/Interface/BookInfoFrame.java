/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Data.Book;
import Data.BookInformation;
import Data.FrameAux;
import Data.MyBooks;
import Data.Notes;
import util.WriteJson;
import util.FrameStack;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import util.BookManagerReport;

/**
 *
 * @author Usuario
 */
public class BookInfoFrame extends javax.swing.JFrame {

    private MyBooks myBooks;
    private Book actualBook;
    private String bookName;
    private String author;
    private Boolean estate;
    private String isbn;
    private Integer lastPage;
    private String category;
    private String opinion;
    //private int bookId;
    private int idNota = 0;
    private FrameStack frameStack;

    /**
     * Creates new form CopyFrame
     */
    public BookInfoFrame(Book book, MyBooks myBooks, FrameStack frameStack) {
        this.myBooks = myBooks;
        this.actualBook = book;
        this.bookName = this.actualBook.getBookInformation().getName();
        this.author = this.actualBook.getBookInformation().getAuthor();
        this.estate = this.actualBook.getStatus();
        this.isbn = this.actualBook.getBookInformation().getIsbn();
        this.lastPage = this.actualBook.getActualPage();
        this.category = this.actualBook.getBookInformation().getCategory();
        //this.bookId = this.actualBook.getBookInformation().getId();
        this.opinion = this.actualBook.getOpinion();
        System.out.println("new line:");
        this.myBooks.printAllBooks();
        this.frameStack = frameStack;
        
        
        
        
        

        System.out.println("esta es la pila de book info frame: ");
        FrameAux s = (FrameAux) frameStack.getStackFrame().peek();
        System.out.println(s.getTypeOfFrame());

        //this.notes.getNotes();
        initComponents();
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        
        if(frameAux2.getTypeOfFrame()!= 2){
            FrameAux frameAux = new FrameAux(2, this.myBooks, this.actualBook);
            this.frameStack.getStackFrame().push(frameAux);
        }
        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }
        //print logo
        System.out.println(this.JLProyectIcon2.getWidth());
        System.out.println(this.JLProyectIcon2.getHeight());
        UtilInterface.printImage(this.JLProyectIcon2, "src/Interface/MediaFiles/LogoOriginal.png", this);
        //escribe el nombre del libro en el JPanel
        UtilInterface.setPanelText(this.bookName, this.jPNewBook2);
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();
        System.out.println("Interface.BookInfoFrame.<init>()");
        //this.myBooks.printAllBooks();
        fillTableNotes();
        //this.JPNewBook1.setVisible(false);
        this.jPNote.setVisible(false);
    }

    public BookInfoFrame() {
        //this.actualBook = book;
        initComponents();
        //print logo
        UtilInterface.printImage(JLProyectIcon2, "src/Interface/MediaFiles/LogoOriginal.png", this);
        //escribe el nombre del libro en el JPanel
        UtilInterface.setPanelText(bookName, this.jPNewBook2);
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();

    }

    private void fillTableNotes() {
        UtilInterface.cleanJTable(jTMyNotes);
        for (int i = 0; i < this.actualBook.getNotes().getBookNotes().count; i++) {

            String id = String.valueOf(i + 1);
            String date = this.actualBook.getNotes().getBookNotes().elementPosition(i).getDate();
            String page = String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(i).getPage());
            String paragraph = String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(i).getParagraph());
            String note = this.actualBook.getNotes().getBookNotes().elementPosition(i).getNote();

            String[] tbData = {id, page, paragraph, date, note};
            DefaultTableModel tblModel = (DefaultTableModel) jTMyNotes.getModel();
            tblModel.addRow(tbData);

        }

    }

    private void completeLabels() {
        this.jLbookName.setText("Libro: ");
        jTbookName.setText(this.bookName);
        this.jLAuthor.setText("Autor: ");
        jTauthor.setText(this.author);
        this.jLCategory.setText("Categoría: ");
        jTcategory.setText(this.category);
        this.jLEstate.setText("Estado: ");
        jCheckStatus.setSelected(this.estate);
        this.jLLastPage.setText("Ultima página: " + this.lastPage);
        this.jLOpinion.setText("Opinión: ");

        if (this.opinion.length() == 0) {
            jBnewOpinion.setVisible(true);
            jTAopinion.setVisible(false);
            jBmodifyOpinion.setVisible(false);
            jBdeleteOpinion.setVisible(false);

        } else {

            jBnewOpinion.setVisible(false);
            jBmodifyOpinion.setVisible(true);
            jTAopinion.setText(opinion);
            jBsaveOpinion.setVisible(false);
            jBdeleteOpinion.setVisible(true);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        JLProyectIcon2 = new javax.swing.JLabel();
        jPNewBook2 = new javax.swing.JPanel();
        jBactualPage2 = new javax.swing.JButton();
        jLCategory = new javax.swing.JLabel();
        jBAddBook = new javax.swing.JButton();
        jLbookName = new javax.swing.JLabel();
        JPNewBook1 = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyNotes = new javax.swing.JTable();
        jLEstate = new javax.swing.JLabel();
        jTactualPage = new javax.swing.JTextField();
        jLLastPage = new javax.swing.JLabel();
        jBnewOpinion = new javax.swing.JButton();
        jBmodifyOpinion = new javax.swing.JButton();
        jCheckStatus = new javax.swing.JCheckBox();
        modifyInfo = new javax.swing.JButton();
        jTcategory = new javax.swing.JTextField();
        jTauthor = new javax.swing.JTextField();
        jLAuthor = new javax.swing.JLabel();
        jTbookName = new javax.swing.JTextField();
        jLOpinion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAopinion = new javax.swing.JTextArea();
        jBsaveOpinion = new javax.swing.JButton();
        jBdeleteOpinion = new javax.swing.JButton();
        jLnotificationModifyOpinion = new javax.swing.JLabel();
        jTFEditNote = new javax.swing.JTextField();
        jBEditNote = new javax.swing.JButton();
        jPNote = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTANote = new javax.swing.JTextArea();
        jBSaveNote = new javax.swing.JButton();
        jTFNoteDate = new javax.swing.JTextField();
        jTFNotePage = new javax.swing.JTextField();
        jTFNoteParagraph = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBcancelNote = new javax.swing.JButton();
        jBdeleteNote = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jBForward = new javax.swing.JButton();
        JBMyBooks = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon2.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPNewBook2.setBackground(new java.awt.Color(255, 255, 255));
        jPNewBook2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(título del libro)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jBactualPage2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBactualPage2.setText("Actualizar página");
        jBactualPage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualPage2ActionPerformed(evt);
            }
        });

        jLCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCategory.setText("Categoría: ");

        jBAddBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBAddBook.setText("Añadir nota");
        jBAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBookActionPerformed(evt);
            }
        });

        jLbookName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLbookName.setText("Libro:");

        JPNewBook1.setBackground(new java.awt.Color(255, 255, 255));
        JPNewBook1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jTMyNotes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyNotes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTMyNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID","Página", "Parrafo", "Fecha", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMyNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTMyNotes.setGridColor(new java.awt.Color(255, 255, 255));
        jTMyNotes.setInheritsPopupMenu(true);
        jTMyNotes.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyNotes);

        javax.swing.GroupLayout JPNewBook1Layout = new javax.swing.GroupLayout(JPNewBook1);
        JPNewBook1.setLayout(JPNewBook1Layout);
        JPNewBook1Layout.setHorizontalGroup(
            JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPNewBook1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        JPNewBook1Layout.setVerticalGroup(
            JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNewBook1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jLEstate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLEstate.setText("Estado:");

        jTactualPage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTactualPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTactualPageActionPerformed(evt);
            }
        });

        jLLastPage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLLastPage.setText("Ultima página: (pagina)");

        jBnewOpinion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBnewOpinion.setText("crear opinion");
        jBnewOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnewOpinionActionPerformed(evt);
            }
        });

        jBmodifyOpinion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBmodifyOpinion.setText("Modificar opinion");
        jBmodifyOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodifyOpinionActionPerformed(evt);
            }
        });

        jCheckStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckStatusActionPerformed(evt);
            }
        });

        modifyInfo.setText("Modificar Información");
        modifyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyInfoActionPerformed(evt);
            }
        });

        jTcategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcategoryActionPerformed(evt);
            }
        });

        jTauthor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTauthorActionPerformed(evt);
            }
        });

        jLAuthor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLAuthor.setText("Autor:");

        jTbookName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTbookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTbookNameActionPerformed(evt);
            }
        });

        jLOpinion.setText("Opinión");

        jTAopinion.setColumns(20);
        jTAopinion.setRows(5);
        jScrollPane1.setViewportView(jTAopinion);

        jBsaveOpinion.setText("Guardar opinion");
        jBsaveOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsaveOpinionActionPerformed(evt);
            }
        });

        jBdeleteOpinion.setText("Eliminar opinion");
        jBdeleteOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdeleteOpinionActionPerformed(evt);
            }
        });

        jTFEditNote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEditNoteActionPerformed(evt);
            }
        });

        jBEditNote.setText("Cambiar nota");
        jBEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditNoteActionPerformed(evt);
            }
        });

        jTANote.setColumns(20);
        jTANote.setRows(5);
        jTANote.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota"));
        jScrollPane2.setViewportView(jTANote);

        jBSaveNote.setText("Guardar");
        jBSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveNoteActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha:");

        jLabel2.setText("Página:");

        jLabel3.setText("párrafo:");

        jBcancelNote.setText("Cancelar");
        jBcancelNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelNoteActionPerformed(evt);
            }
        });

        jBdeleteNote.setText("eliminar nota");
        jBdeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdeleteNoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPNoteLayout = new javax.swing.GroupLayout(jPNote);
        jPNote.setLayout(jPNoteLayout);
        jPNoteLayout.setHorizontalGroup(
            jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNoteLayout.createSequentialGroup()
                .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBdeleteNote)
                            .addComponent(jBcancelNote)
                            .addComponent(jBSaveNote))
                        .addGap(77, 77, 77))
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNoteDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNotePage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNoteParagraph, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPNoteLayout.setVerticalGroup(
            jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNoteDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNotePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNoteParagraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addComponent(jBcancelNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSaveNote)
                        .addGap(12, 12, 12)
                        .addComponent(jBdeleteNote))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jBBack.setText("atras");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jBForward.setText("adelante");
        jBForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPNewBook2Layout = new javax.swing.GroupLayout(jPNewBook2);
        jPNewBook2.setLayout(jPNewBook2Layout);
        jPNewBook2Layout.setHorizontalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JPNewBook1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLOpinion)
                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                        .addComponent(jLbookName)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                        .addComponent(jLAuthor)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                        .addComponent(jLCategory)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                .addComponent(jLEstate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckStatus))
                                            .addComponent(jLLastPage)
                                            .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBactualPage2)))
                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(jTFEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBForward, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jPNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBnewOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBsaveOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addComponent(jBmodifyOpinion)
                                .addGap(18, 18, 18)
                                .addComponent(jBdeleteOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLnotificationModifyOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPNewBook2Layout.setVerticalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLEstate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAuthor)
                    .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLastPage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCategory)
                    .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addComponent(jBactualPage2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addComponent(jLOpinion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addComponent(jBnewOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBsaveOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBmodifyOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jBdeleteOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLnotificationModifyOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(JPNewBook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBEditNote, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jTFEditNote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAddBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBBack)
                            .addComponent(jBForward))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        JBMyBooks.setText("Página principal");
        JBMyBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMyBooksActionPerformed(evt);
            }
        });

        jBFilter.setText("Filtrar");

        jBNewInform.setText("Generar  informe");
        jBNewInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNewInformActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBMyBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLProyectIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jBFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBNewInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPNewBook2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JLProyectIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBNewInform, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 353, Short.MAX_VALUE))
                    .addComponent(jPNewBook2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPNewBook2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBactualPage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBactualPage2ActionPerformed

        int actualPage = Integer.parseInt(jTactualPage.getText());

        this.actualBook.setActualPage(actualPage);

        this.lastPage = actualPage;

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_jBactualPage2ActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        NewNoteFrame newNoteFrame = new NewNoteFrame(this.myBooks, this.actualBook, this.frameStack);
        newNoteFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAddBookActionPerformed

    private void jTactualPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTactualPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTactualPageActionPerformed

    private void jBnewOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnewOpinionActionPerformed
        // TODO add your handling code here:

        jTAopinion.setText("");

        jTAopinion.setVisible(true);

        jBnewOpinion.setVisible(false);

        jBsaveOpinion.setVisible(true);
    }//GEN-LAST:event_jBnewOpinionActionPerformed

    private void jBmodifyOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodifyOpinionActionPerformed
        // TODO add your handling code here:

        String newOpinion = jTAopinion.getText();

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        JOptionPane popUp = new JOptionPane();

        JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_jBmodifyOpinionActionPerformed

    private void jCheckStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckStatusActionPerformed
        // TODO add your handling code here:

        if (jCheckStatus.isSelected()) {

            this.estate = true;
            this.actualBook.setStatus(true);

        } else {
            this.estate = false;
            this.actualBook.setStatus(false);
        }

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

    }//GEN-LAST:event_jCheckStatusActionPerformed

    private void modifyInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyInfoActionPerformed
        // TODO add your handling code here:
        String newBookName = jTbookName.getText();

        String newAuthor = jTauthor.getText();

        String newCategory = jTcategory.getText();

        BookInformation newBookInformation = new BookInformation(/*bookId,¨*/newBookName, newAuthor, newCategory, isbn);

        this.bookName = newBookName;

        this.author = newAuthor;

        this.category = newCategory;

        this.actualBook.setBookInformation(newBookInformation);

        UtilInterface.setPanelText(bookName, this.jPNewBook2);
        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_modifyInfoActionPerformed

    private void jTcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTcategoryActionPerformed

    private void jTauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTauthorActionPerformed

    private void jTbookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTbookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTbookNameActionPerformed

    private void jBsaveOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsaveOpinionActionPerformed
        // TODO add your handling code here:

        String newOpinion = jTAopinion.getText();

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_jBsaveOpinionActionPerformed

    private void jBdeleteOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdeleteOpinionActionPerformed
        // TODO add your handling code here:

        String newOpinion = "";

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_jBdeleteOpinionActionPerformed

    private void jTFEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEditNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEditNoteActionPerformed

    private void jBEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditNoteActionPerformed
        // TODO add your handling code here:

        if (this.jTFEditNote.getText().length() > 0) {
            this.idNota = Integer.parseInt(this.jTFEditNote.getText());
            this.jTANote.setText(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getNote());
            this.jPNote.setVisible(true);
            this.jTFEditNote.setEditable(false);
            this.JPNewBook1.setVisible(false);
            this.jBEditNote.setVisible(false);
            this.jTFNoteDate.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getDate()));
            this.jTFNotePage.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getPage()));
            this.jTFNoteParagraph.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getParagraph()));

        }

        //System.out.println("se presiono el boton");
    }//GEN-LAST:event_jBEditNoteActionPerformed

    private void jBSaveNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveNoteActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
        if (option == 0) {
            String note = this.jTANote.getText();
            String date = this.jTFNoteDate.getText();
            int page = Integer.parseInt(this.jTFNotePage.getText());
            int paragraph = Integer.parseInt(this.jTFNoteParagraph.getText());
            this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).setDate(date);
            this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).setNote(note);
            this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).setPage(page);
            this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).setParagraph(paragraph);
            WriteJson writeJson = new WriteJson();
            try {
                writeJson.createAuxBook(this.myBooks.getMyBooks());

            } catch (IOException e) {
                System.err.println("no se pudo guardar");
            }
            this.jPNote.setVisible(false);
            this.jTFEditNote.setEditable(true);
            this.jTFEditNote.setText("");
            this.JPNewBook1.setVisible(true);
            this.jBEditNote.setVisible(true);
            fillTableNotes();
        }
    }//GEN-LAST:event_jBSaveNoteActionPerformed

    private void jBcancelNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelNoteActionPerformed
        // TODO add your handling code here:
        this.jPNote.setVisible(false);
        this.jTFEditNote.setEditable(true);
        this.jTFEditNote.setText("");
        this.JPNewBook1.setVisible(true);
        this.jBEditNote.setVisible(true);
        fillTableNotes();
    }//GEN-LAST:event_jBcancelNoteActionPerformed

    private void jBdeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdeleteNoteActionPerformed
        // TODO add your handling code here:

        int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
        if (option == 0) {

            //System.out.println(this.actualBook.getNotes().paintBookNotes());
            this.actualBook.getNotes().deleteNote(this.idNota - 1);
            //System.out.println(this.actualBook.getNotes().paintBookNotes());

            WriteJson writeJson = new WriteJson();
            try {
                writeJson.createAuxBook(this.myBooks.getMyBooks());

            } catch (IOException e) {
                System.err.println("no se pudo guardar");
            }

            this.jPNote.setVisible(false);
            this.jTFEditNote.setEditable(true);
            this.jTFEditNote.setText("");
            this.JPNewBook1.setVisible(true);
            this.jBEditNote.setVisible(true);
            fillTableNotes();
        }
        {

        }
    }//GEN-LAST:event_jBdeleteNoteActionPerformed

    private void JBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMyBooksActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        MainFrame mainFrame = new MainFrame(this.myBooks, this.frameStack);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBMyBooksActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        // TODO add your handling code here:

        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        System.out.println(frameas.getTypeOfFrame());
        frameStack.readStack();
        System.out.println("");
        frameStack.pop();
        frameStack.readStack();

        frameas = (FrameAux) frameStack.getStackFrame().peek();
        
        
        System.out.println(frameas.getTypeOfFrame());
        JFrame frame = this.frameStack.generateFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBForwardActionPerformed
        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        System.out.println(frameas.getTypeOfFrame());
        frameStack.readStack();
        System.out.println("");
        frameStack.nextToNormal();
        frameStack.readStack();

        frameas = (FrameAux) frameStack.getStackFrame().peek();
        
        
        System.out.println(frameas.getTypeOfFrame());
        JFrame frame = this.frameStack.generateFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBForwardActionPerformed

    private void jBNewInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewInformActionPerformed
        try{
            BookManagerReport report = new BookManagerReport(this.actualBook, actualBook.getBookInformation().getName()+".pdf");
            

        JOptionPane.showMessageDialog(null, "SE HA GENERADO EL INFORME CORRECTAMENTE.");

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Cierre el PDF antes de continuar.");
        }

    }//GEN-LAST:event_jBNewInformActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookInfoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBMyBooks;
    private javax.swing.JLabel JLProyectIcon2;
    private javax.swing.JPanel JPNewBook1;
    private javax.swing.JButton jBAddBook;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBEditNote;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JButton jBSaveNote;
    private javax.swing.JButton jBactualPage2;
    private javax.swing.JButton jBcancelNote;
    private javax.swing.JButton jBdeleteNote;
    private javax.swing.JButton jBdeleteOpinion;
    private javax.swing.JButton jBmodifyOpinion;
    private javax.swing.JButton jBnewOpinion;
    private javax.swing.JButton jBsaveOpinion;
    private javax.swing.JCheckBox jCheckStatus;
    private javax.swing.JLabel jLAuthor;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLEstate;
    private javax.swing.JLabel jLLastPage;
    private javax.swing.JLabel jLOpinion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbookName;
    private javax.swing.JLabel jLnotificationModifyOpinion;
    private javax.swing.JPanel jPNewBook2;
    private javax.swing.JPanel jPNote;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTANote;
    private javax.swing.JTextArea jTAopinion;
    private javax.swing.JTextField jTFEditNote;
    private javax.swing.JTextField jTFNoteDate;
    private javax.swing.JTextField jTFNotePage;
    private javax.swing.JTextField jTFNoteParagraph;
    private javax.swing.JTable jTMyNotes;
    private javax.swing.JTextField jTactualPage;
    private javax.swing.JTextField jTauthor;
    private javax.swing.JTextField jTbookName;
    private javax.swing.JTextField jTcategory;
    private javax.swing.JButton modifyInfo;
    // End of variables declaration//GEN-END:variables
}

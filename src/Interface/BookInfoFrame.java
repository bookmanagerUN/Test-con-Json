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
            jTAopinion.setText(opinion);
            jTAopinion.setVisible(true);
            jBnewOpinion.setVisible(false);
            jBmodifyOpinion.setVisible(true);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
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
        jPNote1 = new javax.swing.JPanel();
        jLID = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAopinion = new javax.swing.JTextArea();
        JBMyBooks = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon2.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPNewBook2.setBackground(new java.awt.Color(255, 255, 255));
        jPNewBook2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "(título del libro)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(31, 78, 121))); // NOI18N

        jBactualPage2.setBackground(new java.awt.Color(31, 78, 121));
        jBactualPage2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBactualPage2.setForeground(new java.awt.Color(255, 255, 255));
        jBactualPage2.setText("Actualizar página");
        jBactualPage2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBactualPage2.setBorderPainted(false);
        jBactualPage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualPage2ActionPerformed(evt);
            }
        });

        jLCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCategory.setText("Categoría");

        jBAddBook.setBackground(new java.awt.Color(31, 78, 121));
        jBAddBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBAddBook.setForeground(new java.awt.Color(255, 255, 255));
        jBAddBook.setText("Añadir nota");
        jBAddBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBAddBook.setBorderPainted(false);
        jBAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBookActionPerformed(evt);
            }
        });

        jLbookName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLbookName.setText("Libro");

        JPNewBook1.setBackground(new java.awt.Color(255, 255, 255));
        JPNewBook1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "Notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(31, 78, 121))); // NOI18N

        jTMyNotes.setBackground(new java.awt.Color(255, 255, 255));
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
            .addGroup(JPNewBook1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPMyBooks)
                .addContainerGap())
        );
        JPNewBook1Layout.setVerticalGroup(
            JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNewBook1Layout.createSequentialGroup()
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLEstate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLEstate.setText("Estado:");

        jTactualPage.setBackground(new java.awt.Color(255, 255, 255));
        jTactualPage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTactualPage.setForeground(new java.awt.Color(0, 0, 0));
        jTactualPage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTactualPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTactualPageActionPerformed(evt);
            }
        });

        jLLastPage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLLastPage.setText("Ultima página: (pagina)");

        jBnewOpinion.setBackground(new java.awt.Color(31, 78, 121));
        jBnewOpinion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBnewOpinion.setForeground(new java.awt.Color(255, 255, 255));
        jBnewOpinion.setText("Crear opinión");
        jBnewOpinion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBnewOpinion.setBorderPainted(false);
        jBnewOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnewOpinionActionPerformed(evt);
            }
        });

        jBmodifyOpinion.setBackground(new java.awt.Color(31, 78, 121));
        jBmodifyOpinion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBmodifyOpinion.setForeground(new java.awt.Color(255, 255, 255));
        jBmodifyOpinion.setText("Modificar opinión");
        jBmodifyOpinion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBmodifyOpinion.setBorderPainted(false);
        jBmodifyOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodifyOpinionActionPerformed(evt);
            }
        });

        jCheckStatus.setBackground(new java.awt.Color(255, 255, 255));
        jCheckStatus.setForeground(new java.awt.Color(31, 78, 121));
        jCheckStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 1, true));
        jCheckStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckStatusActionPerformed(evt);
            }
        });

        modifyInfo.setBackground(new java.awt.Color(31, 78, 121));
        modifyInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modifyInfo.setForeground(new java.awt.Color(255, 255, 255));
        modifyInfo.setText("Modificar Información");
        modifyInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        modifyInfo.setBorderPainted(false);
        modifyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyInfoActionPerformed(evt);
            }
        });

        jTcategory.setBackground(new java.awt.Color(255, 255, 255));
        jTcategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTcategory.setForeground(new java.awt.Color(0, 0, 0));
        jTcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcategoryActionPerformed(evt);
            }
        });

        jTauthor.setBackground(new java.awt.Color(255, 255, 255));
        jTauthor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTauthor.setForeground(new java.awt.Color(0, 0, 0));
        jTauthor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTauthorActionPerformed(evt);
            }
        });

        jLAuthor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLAuthor.setText("Autor");

        jTbookName.setBackground(new java.awt.Color(255, 255, 255));
        jTbookName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTbookName.setForeground(new java.awt.Color(0, 0, 0));
        jTbookName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTbookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTbookNameActionPerformed(evt);
            }
        });

        jLOpinion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLOpinion.setForeground(new java.awt.Color(31, 78, 121));
        jLOpinion.setText("Opinión");

        jBsaveOpinion.setBackground(new java.awt.Color(31, 78, 121));
        jBsaveOpinion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBsaveOpinion.setForeground(new java.awt.Color(255, 255, 255));
        jBsaveOpinion.setText("Guardar opinión");
        jBsaveOpinion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBsaveOpinion.setBorderPainted(false);
        jBsaveOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsaveOpinionActionPerformed(evt);
            }
        });

        jBdeleteOpinion.setBackground(new java.awt.Color(31, 78, 121));
        jBdeleteOpinion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBdeleteOpinion.setForeground(new java.awt.Color(255, 255, 255));
        jBdeleteOpinion.setText("Eliminar opinión");
        jBdeleteOpinion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBdeleteOpinion.setBorderPainted(false);
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

        jBEditNote.setBackground(new java.awt.Color(31, 78, 121));
        jBEditNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBEditNote.setForeground(new java.awt.Color(255, 255, 255));
        jBEditNote.setText("Cambiar nota");
        jBEditNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBEditNote.setBorderPainted(false);
        jBEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditNoteActionPerformed(evt);
            }
        });

        jTANote.setColumns(20);
        jTANote.setRows(5);
        jTANote.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota"));
        jScrollPane2.setViewportView(jTANote);

        jBSaveNote.setBackground(new java.awt.Color(31, 78, 121));
        jBSaveNote.setForeground(new java.awt.Color(255, 255, 255));
        jBSaveNote.setText("Guardar");
        jBSaveNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBSaveNote.setBorderPainted(false);
        jBSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveNoteActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha:");

        jLabel2.setText("Página:");

        jLabel3.setText("Párrafo:");

        jBcancelNote.setBackground(new java.awt.Color(31, 78, 121));
        jBcancelNote.setForeground(new java.awt.Color(255, 255, 255));
        jBcancelNote.setText("Cancelar");
        jBcancelNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBcancelNote.setBorderPainted(false);
        jBcancelNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelNoteActionPerformed(evt);
            }
        });

        jBdeleteNote.setBackground(new java.awt.Color(31, 78, 121));
        jBdeleteNote.setForeground(new java.awt.Color(255, 255, 255));
        jBdeleteNote.setText("Eliminar Nota");
        jBdeleteNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBdeleteNote.setBorderPainted(false);
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
                .addContainerGap()
                .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(23, 23, 23)
                        .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBSaveNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBcancelNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBdeleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNoteDate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNotePage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNoteParagraph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPNoteLayout.createSequentialGroup()
                        .addComponent(jBSaveNote)
                        .addGap(18, 18, 18)
                        .addComponent(jBcancelNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBdeleteNote))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jBBack.setBackground(new java.awt.Color(255, 255, 255));
        jBBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/atras.png"))); // NOI18N
        jBBack.setBorderPainted(false);
        jBBack.setContentAreaFilled(false);
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jBForward.setBackground(new java.awt.Color(255, 255, 255));
        jBForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/adelante.png"))); // NOI18N
        jBForward.setBorderPainted(false);
        jBForward.setContentAreaFilled(false);
        jBForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForwardActionPerformed(evt);
            }
        });

        jPNote1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPNote1Layout = new javax.swing.GroupLayout(jPNote1);
        jPNote1.setLayout(jPNote1Layout);
        jPNote1Layout.setHorizontalGroup(
            jPNote1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPNote1Layout.setVerticalGroup(
            jPNote1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        jLID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLID.setForeground(new java.awt.Color(31, 78, 121));
        jLID.setText("ID");

        jTAopinion.setColumns(20);
        jTAopinion.setRows(5);
        jTAopinion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane3.setViewportView(jTAopinion);

        javax.swing.GroupLayout jPNewBook2Layout = new javax.swing.GroupLayout(jPNewBook2);
        jPNewBook2.setLayout(jPNewBook2Layout);
        jPNewBook2Layout.setHorizontalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLOpinion)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLbookName)
                                                    .addComponent(jLAuthor))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jLCategory, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(79, 79, 79))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNewBook2Layout.createSequentialGroup()
                                        .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)))
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                        .addComponent(jLEstate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckStatus))
                                    .addComponent(jLLastPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBactualPage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addComponent(jBBack)
                                .addGap(825, 825, 825)
                                .addComponent(jBForward)
                                .addGap(32, 32, 32))
                            .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPNewBook2Layout.createSequentialGroup()
                                    .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)
                                    .addComponent(jLID)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(JPNewBook1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPNewBook2Layout.createSequentialGroup()
                                    .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBsaveOpinion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBnewOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jBmodifyOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBdeleteOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(28, 28, 28)
                        .addComponent(jPNote1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLnotificationModifyOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPNewBook2Layout.setVerticalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEstate)
                    .addComponent(jCheckStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAuthor)
                    .addComponent(jLLastPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCategory)
                    .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBactualPage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLOpinion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPNote1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPNewBook2Layout.createSequentialGroup()
                            .addComponent(jBnewOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBsaveOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNewBook2Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBdeleteOpinion)
                                .addComponent(jBmodifyOpinion)))))
                .addGap(12, 12, 12)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLnotificationModifyOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPNewBook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBEditNote, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(jTFEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jBAddBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBack)
                    .addComponent(jBForward))
                .addContainerGap())
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
                .addComponent(jPNewBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(0, 366, Short.MAX_VALUE))
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

    private void JBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMyBooksActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        MainFrame mainFrame = new MainFrame(this.myBooks, this.frameStack);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBMyBooksActionPerformed

    private void jBNewInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewInformActionPerformed
        try{
            BookManagerReport report = new BookManagerReport(this.actualBook, actualBook.getBookInformation().getName()+".pdf");
            

        JOptionPane.showMessageDialog(null, "SE HA GENERADO EL INFORME CORRECTAMENTE.");

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Cierre el PDF antes de continuar.");
        }

    }//GEN-LAST:event_jBNewInformActionPerformed

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

    private void jBcancelNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelNoteActionPerformed
        // TODO add your handling code here:
        this.jPNote.setVisible(false);
        this.jTFEditNote.setEditable(true);
        this.jTFEditNote.setText("");
        this.JPNewBook1.setVisible(true);
        this.jBEditNote.setVisible(true);
        fillTableNotes();
    }//GEN-LAST:event_jBcancelNoteActionPerformed

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

    private void jBEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditNoteActionPerformed
        // TODO add your handling code here:

        if (this.jTFEditNote.getText().length() > 0) {
            this.idNota = Integer.parseInt(this.jTFEditNote.getText());
            this.jTANote.setText(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getNote());
            this.jPNote.setVisible(true);
            this.jTFEditNote.setEditable(false);
            this.JPNewBook1.setVisible(false);
            this.jBEditNote.setVisible(true);
            this.jTFNoteDate.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getDate()));
            this.jTFNotePage.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getPage()));
            this.jTFNoteParagraph.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getParagraph()));

        }

        //System.out.println("se presiono el boton");
    }//GEN-LAST:event_jBEditNoteActionPerformed

    private void jTFEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEditNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEditNoteActionPerformed

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

    private void jBsaveOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsaveOpinionActionPerformed
        // TODO add your handling code here:

        String newOpinion = jTAopinion.getText();

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }
        
        this.completeLabels();

        jTactualPage.setText("");
    }//GEN-LAST:event_jBsaveOpinionActionPerformed

    private void jTbookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTbookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTbookNameActionPerformed

    private void jTauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTauthorActionPerformed

    private void jTcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTcategoryActionPerformed

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

    private void jBnewOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnewOpinionActionPerformed
        // TODO add your handling code here:

        jTAopinion.setText("");

        jTAopinion.setVisible(true);

        jBnewOpinion.setVisible(false);

        jBsaveOpinion.setVisible(true);
    }//GEN-LAST:event_jBnewOpinionActionPerformed

    private void jTactualPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTactualPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTactualPageActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        NewNoteFrame newNoteFrame = new NewNoteFrame(this.myBooks, this.actualBook, this.frameStack);
        newNoteFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAddBookActionPerformed

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
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLLastPage;
    private javax.swing.JLabel jLOpinion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbookName;
    private javax.swing.JLabel jLnotificationModifyOpinion;
    private javax.swing.JPanel jPNewBook2;
    private javax.swing.JPanel jPNote;
    private javax.swing.JPanel jPNote1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTree jTree1;
    private javax.swing.JButton modifyInfo;
    // End of variables declaration//GEN-END:variables
}

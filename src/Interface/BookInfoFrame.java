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
import Data.UserFinal;
import util.WriteJson;
import util.FrameStack;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import util.BookManagerReport;
import util.CSVReport;

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
    private UserFinal user;

    /**
     * Creates new form CopyFrame
     */
    public BookInfoFrame(Book book, MyBooks myBooks, FrameStack frameStack, UserFinal user) {
        this.user = user;
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
            FrameAux frameAux = new FrameAux(2, this.myBooks, this.actualBook,this.user);
            this.frameStack.getStackFrame().push(frameAux);
        }
        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack1.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }

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
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();

    }

    private void fillTableNotes() {
        UtilInterface.cleanJTable(jTMyNotes);
        this.jTMyNotes.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
            this.jTMyNotes.getTableHeader().setForeground(new Color(204,204,204));
            this.jTMyNotes.getTableHeader().setBackground(new Color(31,78,121));
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            jTMyNotes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
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
        jTbookName.setText(this.bookName);
        jTauthor.setText(this.author);
        jTcategory.setText(this.category);
        this.jLEstate.setText("Estado: ");
        jCheckStatus.setSelected(this.estate);
        this.jLLastPage.setText("Current Reading Page: " + this.lastPage);
        this.jLabel5.setText("User/Library/" + this.bookName);
        this.jLabel8.setText(this.bookName);

        if (this.opinion.length() == 0) {
            kButton7.setVisible(true);
            jTAopinion.setVisible(false);
            kButton8.setVisible(false);
            kButton5.setVisible(false);

        } else {
            jTAopinion.setText(opinion);
            jTAopinion.setVisible(true);
            kButton7.setVisible(false);
            kButton8.setVisible(true);
            kButton4.setVisible(false);
            kButton5.setVisible(true);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.+
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
        jPNewBook2 = new javax.swing.JPanel();
        jBAddBook = new javax.swing.JButton();
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
        jLID = new javax.swing.JLabel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyNotes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        modifyInfo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jTcategory = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTauthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTbookName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBactualPage2 = new javax.swing.JButton();
        jTactualPage = new javax.swing.JTextField();
        jLLastPage = new javax.swing.JLabel();
        jCheckStatus = new javax.swing.JCheckBox();
        jLEstate = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton5 = new com.k33ptoo.components.KButton();
        kButton7 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAopinion = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jBForward = new javax.swing.JButton();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jBBack1 = new javax.swing.JButton();
        jBForward2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jRadioButton1.setText("jRadioButton1");

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(31, 78, 121));

        jPNewBook2.setBackground(new java.awt.Color(204, 204, 204));
        jPNewBook2.setPreferredSize(new java.awt.Dimension(1000, 1141));

        jBAddBook.setBackground(new java.awt.Color(31, 78, 121));
        jBAddBook.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jBAddBook.setForeground(new java.awt.Color(204, 204, 204));
        jBAddBook.setText("Add Note");
        jBAddBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBAddBook.setBorderPainted(false);
        jBAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBookActionPerformed(evt);
            }
        });

        jTFEditNote.setBackground(new java.awt.Color(204, 204, 204));
        jTFEditNote.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTFEditNote.setForeground(new java.awt.Color(31, 78, 121));
        jTFEditNote.setBorder(null);
        jTFEditNote.setCaretColor(new java.awt.Color(31, 78, 121));
        jTFEditNote.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTFEditNote.setSelectedTextColor(new java.awt.Color(31, 78, 121));
        jTFEditNote.setSelectionColor(new java.awt.Color(204, 204, 204));
        jTFEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEditNoteActionPerformed(evt);
            }
        });

        jBEditNote.setBackground(new java.awt.Color(31, 78, 121));
        jBEditNote.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jBEditNote.setForeground(new java.awt.Color(204, 204, 204));
        jBEditNote.setText("Edit Note");
        jBEditNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBEditNote.setBorderPainted(false);
        jBEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditNoteActionPerformed(evt);
            }
        });

        jPNote.setBackground(new java.awt.Color(31, 78, 121));

        jTANote.setBackground(new java.awt.Color(31, 78, 121));
        jTANote.setColumns(20);
        jTANote.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTANote.setForeground(new java.awt.Color(204, 204, 204));
        jTANote.setRows(5);
        jTANote.setBorder(null);
        jTANote.setCaretColor(new java.awt.Color(31, 78, 121));
        jTANote.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(jTANote);

        jBSaveNote.setBackground(new java.awt.Color(204, 204, 204));
        jBSaveNote.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jBSaveNote.setForeground(new java.awt.Color(255, 255, 255));
        jBSaveNote.setText("Save");
        jBSaveNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBSaveNote.setBorderPainted(false);
        jBSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveNoteActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(31, 78, 121));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Fecha:");

        jLabel2.setBackground(new java.awt.Color(31, 78, 121));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Página:");

        jLabel3.setBackground(new java.awt.Color(31, 78, 121));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Párrafo:");

        jBcancelNote.setBackground(new java.awt.Color(204, 204, 204));
        jBcancelNote.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jBcancelNote.setForeground(new java.awt.Color(255, 255, 255));
        jBcancelNote.setText("Cancel");
        jBcancelNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBcancelNote.setBorderPainted(false);
        jBcancelNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelNoteActionPerformed(evt);
            }
        });

        jBdeleteNote.setBackground(new java.awt.Color(204, 204, 204));
        jBdeleteNote.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jBdeleteNote.setForeground(new java.awt.Color(255, 255, 255));
        jBdeleteNote.setText("Delete");
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
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addGroup(jPNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBSaveNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBcancelNote, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jBdeleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jScrollPane2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLID.setForeground(new java.awt.Color(31, 78, 121));
        jLID.setText("ID");

        jTMyNotes.setBackground(new java.awt.Color(204, 204, 204));
        jTMyNotes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTMyNotes.setForeground(new java.awt.Color(31, 78, 121));
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
        jTMyNotes.setGridColor(new java.awt.Color(204, 204, 204));
        jTMyNotes.setInheritsPopupMenu(true);
        jTMyNotes.setSelectionBackground(new java.awt.Color(31, 78, 121));
        jTMyNotes.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTMyNotes.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyNotes);

        jPanel1.setBackground(new java.awt.Color(31, 78, 121));

        modifyInfo.setBackground(new java.awt.Color(204, 204, 204));
        modifyInfo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        modifyInfo.setForeground(new java.awt.Color(31, 78, 121));
        modifyInfo.setText("Modify Information");
        modifyInfo.setBorder(null);
        modifyInfo.setBorderPainted(false);
        modifyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyInfoActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jTcategory.setBackground(new java.awt.Color(31, 78, 121));
        jTcategory.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTcategory.setForeground(new java.awt.Color(204, 204, 204));
        jTcategory.setBorder(null);
        jTcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcategoryActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Category");

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jTauthor.setBackground(new java.awt.Color(31, 78, 121));
        jTauthor.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTauthor.setForeground(new java.awt.Color(204, 204, 204));
        jTauthor.setBorder(null);
        jTauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTauthorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Author");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jTbookName.setBackground(new java.awt.Color(31, 78, 121));
        jTbookName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTbookName.setForeground(new java.awt.Color(204, 204, 204));
        jTbookName.setBorder(null);
        jTbookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTbookNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Name");

        jBactualPage2.setBackground(new java.awt.Color(31, 78, 121));
        jBactualPage2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBactualPage2.setForeground(new java.awt.Color(204, 204, 204));
        jBactualPage2.setText("Update Reading Page");
        jBactualPage2.setBorder(null);
        jBactualPage2.setBorderPainted(false);
        jBactualPage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualPage2ActionPerformed(evt);
            }
        });

        jTactualPage.setBackground(new java.awt.Color(31, 78, 121));
        jTactualPage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTactualPage.setForeground(new java.awt.Color(204, 204, 204));
        jTactualPage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTactualPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTactualPageActionPerformed(evt);
            }
        });

        jLLastPage.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLLastPage.setText("Current Reading Page: (pagina)");

        jCheckStatus.setBackground(new java.awt.Color(31, 78, 121));
        jCheckStatus.setForeground(new java.awt.Color(31, 78, 121));
        jCheckStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 1, true));
        jCheckStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckStatusActionPerformed(evt);
            }
        });

        jLEstate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLEstate.setText("Finished");

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTactualPage, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jSeparator6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBactualPage2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jLLastPage)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jCheckStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLEstate)))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLLastPage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBactualPage2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLEstate))
                .addGap(15, 15, 15)
                .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(31, 78, 121));

        kButton4.setBorder(null);
        kButton4.setText("Save Opinion");
        kButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton4.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton4.setkBorderRadius(0);
        kButton4.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton4.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton4.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton4.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton4.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton4.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setBorder(null);
        kButton5.setText("Delete Opinion");
        kButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton5.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton5.setkBorderRadius(0);
        kButton5.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton5.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton5.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton5.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton5.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton5.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        kButton7.setBorder(null);
        kButton7.setText("Make Opinión");
        kButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton7.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton7.setkBorderRadius(0);
        kButton7.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton7.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton7.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton7.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton7.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton7.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton8.setBorder(null);
        kButton8.setText("Modify Opinion");
        kButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton8.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton8.setkBorderRadius(0);
        kButton8.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton8.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton8.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton8.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton8.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton8.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton8.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton8.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton8.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        jTAopinion.setBackground(new java.awt.Color(31, 78, 121));
        jTAopinion.setColumns(20);
        jTAopinion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTAopinion.setForeground(new java.awt.Color(204, 204, 204));
        jTAopinion.setRows(5);
        jTAopinion.setBorder(null);
        jTAopinion.setCaretColor(new java.awt.Color(31, 78, 121));
        jTAopinion.setDisabledTextColor(new java.awt.Color(31, 78, 121));
        jTAopinion.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(jTAopinion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(45, 117, 182));
        jPanel4.setForeground(new java.awt.Color(45, 117, 182));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("User/Library/ActualBook");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("ACTUAL BOOK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jSeparator5.setBackground(new java.awt.Color(31, 78, 121));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPNewBook2Layout = new javax.swing.GroupLayout(jPNewBook2);
        jPNewBook2.setLayout(jPNewBook2Layout);
        jPNewBook2Layout.setHorizontalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSPMyBooks)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addComponent(jLID)
                                .addGap(18, 18, 18)
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                                        .addComponent(jTFEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jBEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPNewBook2Layout.setVerticalGroup(
            jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBook2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBook2Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPNewBook2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPNewBook2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLID))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNewBook2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEditNote, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );

        jBForward.setBackground(new java.awt.Color(31, 78, 121));
        jBForward.setForeground(new java.awt.Color(31, 78, 121));
        jBForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-adelante-96.png"))); // NOI18N
        jBForward.setBorder(null);
        jBForward.setBorderPainted(false);
        jBForward.setContentAreaFilled(false);
        jBForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForwardActionPerformed(evt);
            }
        });

        kButton6.setBorder(null);
        kButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-cierre-de-sesión-redondeado-32.png"))); // NOI18N
        kButton6.setText("Log Out");
        kButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton6.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton6.setkBorderRadius(0);
        kButton6.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton6.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton6.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton6.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton6.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton6.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        kButton3.setBorder(null);
        kButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-documento-32.png"))); // NOI18N
        kButton3.setText("Make Report");
        kButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton3.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton3.setkBorderRadius(0);
        kButton3.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton3.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton3.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton3.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton3.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton2.setBorder(null);
        kButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-filtrar-32.png"))); // NOI18N
        kButton2.setText("Filter");
        kButton2.setAlignmentX(0.5F);
        kButton2.setBorderPainted(false);
        kButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        kButton2.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton2.setkBorderRadius(0);
        kButton2.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton2.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton2.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton2.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton2.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton2.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        jBBack1.setBackground(new java.awt.Color(255, 255, 255));
        jBBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-volver-96.png"))); // NOI18N
        jBBack1.setBorder(null);
        jBBack1.setBorderPainted(false);
        jBBack1.setContentAreaFilled(false);
        jBBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBack1ActionPerformed(evt);
            }
        });

        jBForward2.setBackground(new java.awt.Color(255, 255, 255));
        jBForward2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-casa-prefabricada-32.png"))); // NOI18N
        jBForward2.setBorder(null);
        jBForward2.setBorderPainted(false);
        jBForward2.setContentAreaFilled(false);
        jBForward2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForward2ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jBForward2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jBBack1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBForward))
                            .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPNewBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBForward2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBBack1)
                    .addComponent(jBForward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPNewBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPNewBook2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jBdeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdeleteNoteActionPerformed
        // TODO add your handling code here:

        int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
        if (option == 0) {

            //System.out.println(this.actualBook.getNotes().paintBookNotes());
            this.actualBook.getNotes().deleteNote(this.idNota - 1);
            //System.out.println(this.actualBook.getNotes().paintBookNotes());

            WriteJson writeJson = new WriteJson();
            try {
                writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

            } catch (IOException e) {
                System.err.println("no se pudo guardar");
            }

            this.jPNote.setVisible(false);
            this.jTFEditNote.setEditable(true);
            this.jTFEditNote.setText("");
            this.jBEditNote.setVisible(true);
            fillTableNotes();
        }
        
    }//GEN-LAST:event_jBdeleteNoteActionPerformed

    private void jBcancelNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelNoteActionPerformed
        // TODO add your handling code here:
        this.jPNote.setVisible(false);
        this.jTFEditNote.setEditable(true);
        this.jTFEditNote.setText("");
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
                writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

            } catch (IOException e) {
                System.err.println("no se pudo guardar");
            }
            this.jPNote.setVisible(false);
            this.jTFEditNote.setEditable(true);
            this.jTFEditNote.setText("");
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
            this.jBEditNote.setVisible(true);
            this.jTFNoteDate.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getDate()));
            this.jTFNotePage.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getPage()));
            this.jTFNoteParagraph.setText(String.valueOf(this.actualBook.getNotes().getBookNotes().elementPosition(this.idNota - 1).getParagraph()));

        }

        //System.out.println("se presiono el boton");
    }//GEN-LAST:event_jBEditNoteActionPerformed

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

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

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
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }
    }//GEN-LAST:event_jCheckStatusActionPerformed

    private void jTactualPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTactualPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTactualPageActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        NewNoteFrame newNoteFrame = new NewNoteFrame(this.myBooks, this.actualBook, this.frameStack,this.user);
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
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_jBactualPage2ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        LogInFrame login;
        try {
            login = new LogInFrame();
            login.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        try{
            BookManagerReport report = new BookManagerReport(this.actualBook, this.actualBook.getBookInformation().getName()+".pdf");
            JOptionPane.showMessageDialog(null, "SE HA GENERADO EL INFORME PDF CORRECTAMENTE.");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Close the PDF before continue.");
            JOptionPane.showMessageDialog(null, "CIERRE EL PDF ANTES DE CONTINUAR.");
        }
        
        try{
            CSVReport report = new CSVReport(this.actualBook, this.actualBook.getBookInformation().getName());
            JOptionPane.showMessageDialog(null, "SE HA GENERADO EL INFORME CSV CORRECTAMENTE.");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Close the CSV before continue.");
            JOptionPane.showMessageDialog(null, "CIERRE EL CSV ANTES DE CONTINUAR.");
        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        FilterFrame filter = new FilterFrame(this.myBooks, this.frameStack,this.user);
        filter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jBBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBack1ActionPerformed
        // TODO add your handling code here:
        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        //System.out.println(frameas.getMyBooks().toString());
        //System.out.println(frameas.getTypeOfFrame());

        frameStack.pop();

        frameas = (FrameAux) frameStack.getStackFrame().peek();

        //System.out.println(frameas.getMyBooks().toString());
        JFrame frame = this.frameStack.generateFrame();
        frame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jBBack1ActionPerformed

    private void jBForward2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBForward2ActionPerformed
        this.frameStack.cleanNextStack();
        MainFrame mainFrame = new MainFrame(this.myBooks, this.frameStack, this.user);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBForward2ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        String newOpinion = jTAopinion.getText();

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }
        
        this.completeLabels();

        jTactualPage.setText("");
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        String newOpinion = "";

        this.actualBook.setOpinion(newOpinion);

        this.opinion = newOpinion;

        this.completeLabels();

        // Update Json
        WriteJson writeJson = new WriteJson();
        try {
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:

        jTAopinion.setText("");

        jTAopinion.setVisible(true);

        kButton7.setVisible(false);

        kButton4.setVisible(true);
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
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
            writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

        } catch (IOException e) {
            System.err.println("no se pudo guardar");
        }

        jTactualPage.setText("");
    }//GEN-LAST:event_kButton8ActionPerformed

    private void jTFEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEditNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEditNoteActionPerformed

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
    private javax.swing.JButton jBAddBook;
    private javax.swing.JButton jBBack1;
    private javax.swing.JButton jBEditNote;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBForward2;
    private javax.swing.JButton jBSaveNote;
    private javax.swing.JButton jBactualPage2;
    private javax.swing.JButton jBcancelNote;
    private javax.swing.JButton jBdeleteNote;
    private javax.swing.JCheckBox jCheckStatus;
    private javax.swing.JLabel jLEstate;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLLastPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPNewBook2;
    private javax.swing.JPanel jPNote;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
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
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    private javax.swing.JButton modifyInfo;
    // End of variables declaration//GEN-END:variables
}

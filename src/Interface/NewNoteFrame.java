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

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FrameStack;

/**
 * @author Usuario
 */
public class NewNoteFrame extends javax.swing.JFrame {

    private MyBooks myBooks;
    private Book actualBook ;
    private int bookId;
    private FrameStack frameStack;
    private UserFinal user;

    /**
     * Creates new form NewNoteFrame
     */
    public NewNoteFrame(/*Book book*/) {
        //this.actualBook = book
        this.myBooks = new MyBooks();
        this.actualBook = new Book(new BookInformation(/*1,*/ "100 años de soledad", "GABO", "realismo", "isbn"), this.myBooks);
        findBookId();
        //System.out.println(this.bookId);

        initComponents();
    }

    public NewNoteFrame(MyBooks myBooks, Book book, FrameStack frameStack, UserFinal user) {
        this.user = user;
        this.myBooks = myBooks;
        this.actualBook = book;
        this.frameStack = frameStack;
        
        
        //findBookId();
        //System.out.println(this.bookId);
        initComponents();
        
        this.jTFDate.setText(ActualDate());
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        
        if(frameAux2.getTypeOfFrame()!= 4){
            FrameAux frameAux = new FrameAux(4, this.myBooks, this.actualBook, this.user);
            this.frameStack.getStackFrame().push(frameAux);
        }
        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }
        
        UtilInterface.setPanelText(this.actualBook.getBookInformation().getName(), this.JPNewNote);
        //this.JPNewNote.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JPNewNote = new javax.swing.JPanel();
        jTFPage = new javax.swing.JTextField();
        jTFParagraph = new javax.swing.JTextField();
        jTFDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTANote = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        kButton4 = new com.k33ptoo.components.KButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBForward1 = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jBForward = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 78, 121));

        JPNewNote.setBackground(new java.awt.Color(204, 204, 204));

        jTFPage.setBackground(new java.awt.Color(204, 204, 204));
        jTFPage.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTFPage.setForeground(new java.awt.Color(31, 78, 121));
        jTFPage.setBorder(null);
        jTFPage.setCaretColor(new java.awt.Color(31, 78, 121));

        jTFParagraph.setBackground(new java.awt.Color(204, 204, 204));
        jTFParagraph.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTFParagraph.setForeground(new java.awt.Color(31, 78, 121));
        jTFParagraph.setBorder(null);
        jTFParagraph.setCaretColor(new java.awt.Color(31, 78, 121));

        jTFDate.setBackground(new java.awt.Color(204, 204, 204));
        jTFDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTFDate.setForeground(new java.awt.Color(31, 78, 121));
        jTFDate.setBorder(null);
        jTFDate.setCaretColor(new java.awt.Color(31, 78, 121));
        jTFDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDateActionPerformed(evt);
            }
        });

        jTANote.setBackground(new java.awt.Color(204, 204, 204));
        jTANote.setColumns(20);
        jTANote.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTANote.setForeground(new java.awt.Color(31, 78, 121));
        jTANote.setLineWrap(true);
        jTANote.setRows(5);
        jTANote.setBorder(null);
        jTANote.setCaretColor(new java.awt.Color(31, 78, 121));
        jScrollPane1.setViewportView(jTANote);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 78, 121));
        jLabel5.setText("Date*");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(31, 78, 121));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 78, 121));
        jLabel6.setText("Page");

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(31, 78, 121));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 78, 121));
        jLabel7.setText("Paragraph");

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(31, 78, 121));

        kButton4.setBorder(null);
        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-agregar-propiedad-32.png"))); // NOI18N
        kButton4.setText("Add Note");
        kButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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

        jPanel4.setBackground(new java.awt.Color(45, 117, 182));
        jPanel4.setForeground(new java.awt.Color(45, 117, 182));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("User/Library/Book/newNote");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("NEW NOTE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPNewNoteLayout = new javax.swing.GroupLayout(JPNewNote);
        JPNewNote.setLayout(JPNewNoteLayout);
        JPNewNoteLayout.setHorizontalGroup(
            JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNewNoteLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JPNewNoteLayout.createSequentialGroup()
                .addGroup(JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNewNoteLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPNewNoteLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(JPNewNoteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFParagraph, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFPage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPNewNoteLayout.setVerticalGroup(
            JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNewNoteLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPNewNoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPNewNoteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFParagraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jBForward1.setBackground(new java.awt.Color(255, 255, 255));
        jBForward1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-casa-prefabricada-32.png"))); // NOI18N
        jBForward1.setBorder(null);
        jBForward1.setBorderPainted(false);
        jBForward1.setContentAreaFilled(false);
        jBForward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForward1ActionPerformed(evt);
            }
        });

        jBBack.setBackground(new java.awt.Color(255, 255, 255));
        jBBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-volver-96.png"))); // NOI18N
        jBBack.setBorder(null);
        jBBack.setBorderPainted(false);
        jBBack.setContentAreaFilled(false);
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jBForward.setBackground(new java.awt.Color(255, 255, 255));
        jBForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-adelante-96.png"))); // NOI18N
        jBForward.setBorder(null);
        jBForward.setBorderPainted(false);
        jBForward.setContentAreaFilled(false);
        jBForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForwardActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

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

        kButton3.setBorder(null);
        kButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-libro-de-cuentos-32.png"))); // NOI18N
        kButton3.setText("Recomendations");
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

        kButton1.setBorder(null);
        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-añadir-libro-32.png"))); // NOI18N
        kButton1.setText("Add Book");
        kButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        kButton1.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton1.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton1.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton1.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton1.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton1.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jBBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBForward)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward1)
                        .addGap(91, 91, 91)))
                .addComponent(JPNewNote, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNewNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jBForward1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBForward)
                    .addComponent(jBBack))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String ActualDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        return format.format(date);
    }

    private void jTFDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTFDateActionPerformed

    private void jBForward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBForward1ActionPerformed
        this.frameStack.cleanNextStack();
        MainFrame mainFrame = new MainFrame(this.myBooks, this.frameStack, this.user);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBForward1ActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBForwardActionPerformed
        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        System.out.println(frameas.getTypeOfFrame());

        frameStack.nextToNormal();

        frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        JFrame frame = this.frameStack.generateFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBForwardActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        FilterFrame filter = new FilterFrame(this.myBooks, this.frameStack, this.user);
        filter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        this.frameStack.cleanNextStack();
        AdviceFrame AdviceFrame = new AdviceFrame(this.myBooks, this.frameStack, this.user);
        AdviceFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        this.frameStack.cleanNextStack();

        NewBookFrame newBookFrame = new NewBookFrame(this.myBooks, this.frameStack,this.user);
        newBookFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

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

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO generar check frame
        //  leer los campos de escritura
        //System.out.println("Interface.NewBookFrame.jBAddBookActionPerformed()");
        
        if(jTFPage.getText().length() == 0){
            
            JOptionPane.showMessageDialog(null, "Ingrese una pagina");
            
        }
        if(jTFParagraph.getText().length() == 0){
            
            JOptionPane.showMessageDialog(null, "Ingrese un parrafo");
            
        }
        else{
            String text = this.jTANote.getText();
            int page = Integer.parseInt(this.jTFPage.getText());
            int paragraph = Integer.parseInt(this.jTFParagraph.getText());

            String date = this.jTFDate.getText();

            int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
            //System.out.println(option);
            if (option == 0) {
                Notes note = new Notes(date, page, paragraph, text);
                this.actualBook.getNotes().addNote(note);
                //this.actualBook.getNotes().
                this.actualBook.printBook();
                this.myBooks.printAllBooks();

                // Update Json
                WriteJson writeJson = new WriteJson();
                try {
                    writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

                } catch (IOException e) {
                    System.err.println("no se pudo guardar");
                }

                cleanTextBox();
            } else if (option == 1) {

            } else {
                cleanTextBox();
            }
        }
        /*String author = this.jTFDate.getText();
        String name = this.jTFPage.getText();
        String isbn = this.jTFParagraph.getText();
        String category = this.jTFCategory.getText();

        int id = this.ComputeId();//ejemplo

        BookInformation newBookInformation = new BookInformation(id, name, author, category, isbn);
        Book newBook = new Book(newBookInformation);
        newBook.printBook();
         */
    }//GEN-LAST:event_kButton4ActionPerformed

    private void cleanTextBox() {
        UtilInterface.cleanTextBox(this.jTFDate);
        UtilInterface.cleanTextBox(this.jTFPage);
        UtilInterface.cleanTextBox(this.jTFParagraph);
        UtilInterface.cleanTextArea(this.jTANote);
    }

    //this metod should be in a util class or something like that
    private int findBookId(/*here should enter a boock class*/) {
        //TODO get te book id by an book object

        return 1;//example
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
            java.util.logging.Logger.getLogger(NewNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewNoteFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPNewNote;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBForward1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTANote;
    private javax.swing.JTextField jTFDate;
    private javax.swing.JTextField jTFPage;
    private javax.swing.JTextField jTFParagraph;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton6;
    // End of variables declaration//GEN-END:variables
}

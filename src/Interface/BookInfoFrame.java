/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Data.Book;
import Data.BookInformation;
import Data.MyBooks;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.WriteJson;

/**
 *
 * @author Usuario
 */
public class BookInfoFrame extends javax.swing.JFrame {
    // TODO  eliminar nota
    // revisar si hay una opinion para modificar el estado de los botones
    // rellenar tabla con las notas
    // 

    private MyBooks myBooks;
    private Book actualBook;
    private String bookName;
    private String author;
    private Boolean estate;
    private String isbn;
    private Integer lastPage;
    private String category;
    private int bookId;

    /**
     * Creates new form NewBookFrame
     */
    public BookInfoFrame(Book book, MyBooks myBooks) {
        this.myBooks = myBooks;
        this.actualBook = book;
        this.bookName = this.actualBook.getBookInformation().getName();
        this.author = this.actualBook.getBookInformation().getAuthor();
        this.estate = this.actualBook.getStatus();
        this.isbn = this.actualBook.getBookInformation().getIsbn();
        this.lastPage = this.actualBook.getActualPage();
        this.category = this.actualBook.getBookInformation().getCategory();
        this.bookId = this.actualBook.getBookInformation().getId();
        initComponents();
        //print logo
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png", this);
        //escribe el nombre del libro en el JPanel
        UtilInterface.setPanelText(bookName, this.jPNewBook);
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();
        System.out.println("Interface.BookInfoFrame.<init>()");
        this.myBooks.printAllBooks();

    }

    public BookInfoFrame() {
        //this.actualBook = book;
        initComponents();
        //print logo
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png", this);
        //escribe el nombre del libro en el JPanel
        UtilInterface.setPanelText(bookName, this.jPNewBook);
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();

    }

    private void completeLabels() {
        this.jLbookName.setText("Libro: ");
        jTbookName.setText(this.bookName);
        this.jLAuthor.setText("Autor: ");
        jTauthor.setText(this.author);
        this.jLCategory.setText("Categoría: "); 
        jTcategory.setText(this.category);
        this.jLEstate.setText("Estado: ");  
        if(this.estate){
            jCheckStatus.setSelected(true);
        }
        else jCheckStatus.setSelected(false);
        this.jLLastPage.setText("Ultima página: " + this.lastPage);

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
        JLProyectIcon = new javax.swing.JLabel();
        jPNewBook = new javax.swing.JPanel();
        jBactualPage = new javax.swing.JButton();
        jLCategory = new javax.swing.JLabel();
        jBAddBook = new javax.swing.JButton();
        jLbookName = new javax.swing.JLabel();
        JPNewBook1 = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooks = new javax.swing.JTable();
        jLEstate = new javax.swing.JLabel();
        jTactualPage = new javax.swing.JTextField();
        jLLastPage = new javax.swing.JLabel();
        jBAddBook1 = new javax.swing.JButton();
        jBAddBook2 = new javax.swing.JButton();
        jCheckStatus = new javax.swing.JCheckBox();
        modifyInfo = new javax.swing.JButton();
        jTcategory = new javax.swing.JTextField();
        jTauthor = new javax.swing.JTextField();
        jLAuthor = new javax.swing.JLabel();
        jTbookName = new javax.swing.JTextField();
        JBMyBooks = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPNewBook.setBackground(new java.awt.Color(255, 255, 255));
        jPNewBook.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(título del libro)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jBactualPage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBactualPage.setText("Actualizar página");
        jBactualPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualPageActionPerformed(evt);
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

        jTMyBooks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyBooks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTMyBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "14", "17/08/2021", "asdfasdfasdfasdfklasdfa asdf asdlf asdf  asdfa sldfas df"},
                {"1", "50", "19/08/2021", "asdfasdf   dsf sadf as asf asd "},
                {"2", "79", "01/09/2021", "ad fasdf asdf  wea awe fwef awew  awefaewf"}
            },
            new String [] {
                "ID", "Página", "Fecha", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMyBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTMyBooks.setGridColor(new java.awt.Color(255, 255, 255));
        jTMyBooks.setInheritsPopupMenu(true);
        jTMyBooks.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyBooks);

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
            .addGap(0, 193, Short.MAX_VALUE)
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

        jBAddBook1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBAddBook1.setText("crear opinion");
        jBAddBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBook1ActionPerformed(evt);
            }
        });

        jBAddBook2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBAddBook2.setText("revisar opinion");
        jBAddBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBook2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPNewBookLayout = new javax.swing.GroupLayout(jPNewBook);
        jPNewBook.setLayout(jPNewBookLayout);
        jPNewBookLayout.setHorizontalGroup(
            jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPNewBook1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPNewBookLayout.createSequentialGroup()
                        .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPNewBookLayout.createSequentialGroup()
                                .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBAddBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAddBook2))
                            .addGroup(jPNewBookLayout.createSequentialGroup()
                                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPNewBookLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPNewBookLayout.createSequentialGroup()
                                                .addComponent(jLbookName)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPNewBookLayout.createSequentialGroup()
                                                .addComponent(jLAuthor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPNewBookLayout.createSequentialGroup()
                                                .addComponent(jLCategory)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPNewBookLayout.createSequentialGroup()
                                        .addComponent(jLEstate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckStatus))
                                    .addComponent(jLLastPage)
                                    .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBactualPage))))
                        .addGap(0, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPNewBookLayout.setVerticalGroup(
            jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBookLayout.createSequentialGroup()
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLEstate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTbookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLbookName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAuthor)
                    .addComponent(jTauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLastPage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCategory)
                    .addComponent(jTcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTactualPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modifyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPNewBookLayout.createSequentialGroup()
                        .addComponent(jBactualPage, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPNewBook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAddBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAddBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBMyBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLProyectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jBFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBNewInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBNewInform, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
            .addComponent(jPNewBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBactualPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBactualPageActionPerformed

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

    }//GEN-LAST:event_jBactualPageActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
        // TODO add your handling code here:
        NewNoteFrame newNoteFrame = new NewNoteFrame(this.myBooks, this.actualBook);
        newNoteFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAddBookActionPerformed

    private void jBAddBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBook1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAddBook1ActionPerformed

    private void jBAddBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBook2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAddBook2ActionPerformed

    private void JBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMyBooksActionPerformed
        // TODO add your handling code here:
        MainFrame mainFrame = new MainFrame(this.myBooks);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBMyBooksActionPerformed

    private void jTactualPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTactualPageActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTactualPageActionPerformed

    private void jCheckStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckStatusActionPerformed
        // TODO add your handling code here:
        
        if(jCheckStatus.isSelected()){
            
            this.estate = true;
            this.actualBook.setStatus(true);
            
        }
        else{
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

        BookInformation newBookInformation = new BookInformation(bookId, newBookName, newAuthor, newCategory, isbn);
        
        this.bookName = newBookName;

        this.author = newAuthor;
        
        this.category = newCategory;
        
        this.actualBook.setBookInformation(newBookInformation);
        
        UtilInterface.setPanelText(bookName, this.jPNewBook);
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
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JPanel JPNewBook1;
    private javax.swing.JButton jBAddBook;
    private javax.swing.JButton jBAddBook1;
    private javax.swing.JButton jBAddBook2;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JButton jBactualPage;
    private javax.swing.JCheckBox jCheckStatus;
    private javax.swing.JLabel jLAuthor;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLEstate;
    private javax.swing.JLabel jLLastPage;
    private javax.swing.JLabel jLbookName;
    private javax.swing.JPanel jPNewBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JTable jTMyBooks;
    private javax.swing.JTextField jTactualPage;
    private javax.swing.JTextField jTauthor;
    private javax.swing.JTextField jTbookName;
    private javax.swing.JTextField jTcategory;
    private javax.swing.JButton modifyInfo;
    // End of variables declaration//GEN-END:variables
}
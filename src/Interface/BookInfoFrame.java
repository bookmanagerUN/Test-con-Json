/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Data.Book;
import Data.MyBooks;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png",this);
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
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png",this);
        //escribe el nombre del libro en el JPanel
        UtilInterface.setPanelText(bookName, this.jPNewBook);
        //escribe el resto de la información del libro en los jtextfield
        this.completeLabels();
        
    }
    
    private void completeLabels(){
        this.jLAuthor.setText("Por: "+ this.author);
        this.jLCategory.setText("Categoría: "+ this.category);
        this.jLEstate.setText("Estado: "+ this.estate);
        this.jLIsbn.setText("ISBN: "+this.isbn);
        this.jLLastPage.setText("Ultima página: "+ this.lastPage);
    
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
        jBCancel = new javax.swing.JButton();
        jLCategory = new javax.swing.JLabel();
        jBAddBook = new javax.swing.JButton();
        jLAuthor = new javax.swing.JLabel();
        jLIsbn = new javax.swing.JLabel();
        JPNewBook1 = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooks = new javax.swing.JTable();
        jLEstate = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLLastPage = new javax.swing.JLabel();
        jBAddBook1 = new javax.swing.JButton();
        jBAddBook2 = new javax.swing.JButton();
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

        jBCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBCancel.setText("Actualizar página");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jLCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCategory.setText("Categoría: (categoria)");

        jBAddBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBAddBook.setText("Añadir nota");
        jBAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBookActionPerformed(evt);
            }
        });

        jLAuthor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLAuthor.setText("por: (Nombre del autor)");

        jLIsbn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLIsbn.setText("ISBN: (ISBN)");

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
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(JPNewBook1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPNewBook1Layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jLEstate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLEstate.setText("Estado: (estado)");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout jPNewBookLayout = new javax.swing.GroupLayout(jPNewBook);
        jPNewBook.setLayout(jPNewBookLayout);
        jPNewBookLayout.setHorizontalGroup(
            jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPNewBook1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPNewBookLayout.createSequentialGroup()
                        .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAddBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAddBook2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPNewBookLayout.createSequentialGroup()
                        .addComponent(jLAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLCategory)
                        .addGap(18, 18, 18)
                        .addComponent(jLIsbn))
                    .addGroup(jPNewBookLayout.createSequentialGroup()
                        .addComponent(jLEstate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLLastPage)))
                .addContainerGap())
        );
        jPNewBookLayout.setVerticalGroup(
            jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNewBookLayout.createSequentialGroup()
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPNewBook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLastPage, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAddBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAddBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBNewInform, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        // input (aún no se ha hecho): la justificación(string), tipo de solicitud(string)
        /*int com_numero = Integer.parseInt( this.jTFmyBooks.getText());
        String comentarios = this.selectComentarios(com_numero);
        System.out.println(comentarios);
        String tipo = this.selectTipo(com_numero);

        ComentarioSolicitud est_com = new ComentarioSolicitud(); //nueva ventana de Comentario de solicitudes
        est_com.setVisible(true);
        if(comentarios != "Usted no ha hecho ninguna solicitud con ese número"){
            est_com.set_tipo(tipo);
        }

        est_com.set_textArea(comentarios);
        */
        //this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
        // TODO add your handling code here:
        NewNoteFrame newNoteFrame= new NewNoteFrame(this.myBooks, this.actualBook);
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
        MainFrame mainFrame= new MainFrame(this.myBooks);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBMyBooksActionPerformed

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
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JLabel jLAuthor;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLEstate;
    private javax.swing.JLabel jLIsbn;
    private javax.swing.JLabel jLLastPage;
    private javax.swing.JPanel jPNewBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JTable jTMyBooks;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

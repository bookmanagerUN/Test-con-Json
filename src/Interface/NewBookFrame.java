
package Interface;

import Data.BookInformation;
import Data.Book;
import Data.MyBooks;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import util.WriteJson;

/**
 *
 * @author Usuario
 */
public class NewBookFrame extends javax.swing.JFrame {
    private MyBooks myBooks = new MyBooks() ;
    
    
    /**
     * Creates new form NewBookFrame
     */
    public NewBookFrame() {
        //this.myBooks = myBooks;
        initComponents();
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png",this);
        cleanTextBox();
    }
    public NewBookFrame(MyBooks myBooks) {
        this.myBooks = myBooks;
        initComponents();
        UtilInterface.printImage(JLProyectIcon, "src/main/java/Interface/MediaFiles/LogoOriginal.png",this);
        cleanTextBox();
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
        JPNewBook = new javax.swing.JPanel();
        jBCancel = new javax.swing.JButton();
        jLMyBooks = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFCategory = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFAuthor = new javax.swing.JTextField();
        jBAddBook = new javax.swing.JButton();
        jLMyBooks1 = new javax.swing.JLabel();
        JBMyBooks = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BookManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPNewBook.setBackground(new java.awt.Color(255, 255, 255));
        JPNewBook.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Añadir libro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jBCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBCancel.setText("cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jLMyBooks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLMyBooks.setText("* es obligatorio");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre *");

        jTFName.setText("100 Años de Soledad");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Categoría *");

        jTFCategory.setText("Realismo mágico");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Autor *");

        jTFAuthor.setText("Gabriel García Márquez");

        jBAddBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBAddBook.setText("Añadir");
        jBAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddBookActionPerformed(evt);
            }
        });

        jLMyBooks1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLMyBooks1.setText("Al dejarlo vacio se toma como \"desconocido\"");

        javax.swing.GroupLayout JPNewBookLayout = new javax.swing.GroupLayout(JPNewBook);
        JPNewBook.setLayout(JPNewBookLayout);
        JPNewBookLayout.setHorizontalGroup(
            JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNewBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPNewBookLayout.createSequentialGroup()
                        .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPNewBookLayout.createSequentialGroup()
                        .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPNewBookLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPNewBookLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTFAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPNewBookLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLMyBooks1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPNewBookLayout.setVerticalGroup(
            JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNewBookLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLMyBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPNewBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JBMyBooks.setText("Mis libros");
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
                .addComponent(JPNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBNewInform, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE)))
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

        MainFrame mainFrame = new MainFrame();
        
        mainFrame.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddBookActionPerformed
    //  TODO CHECK crear una ventaan flotante (jOptionpane)  
    
    //  leer los campos de escritura
        System.out.println("Interface.NewBookFrame.jBAddBookActionPerformed()");
        String author = this.jTFAuthor.getText();
        String name = this.jTFName.getText();
        String isbn = "12341243";
        String category = this.jTFCategory.getText();
        
        
        int option = JOptionPane.showConfirmDialog(null, "¿confirma?" );
        //System.out.println(option);
        if(option == 0){
            int id = this.ComputeId();//ejemplo
        
            BookInformation newBookInformation = new BookInformation(id, name, author, category, isbn);
            Book newBook = new Book(newBookInformation,this.myBooks);
            this.myBooks.printAllBooks();
        
            // Update Json
            WriteJson writeJson = new WriteJson();
            try{
                writeJson.createAuxBook(this.myBooks.getMyBooks());
            
            }catch (IOException e){
                System.err.println("no se pudo guardar");
            }
            cleanTextBox();
        }
        else if(option == 1) {
            
        }
        else{
            cleanTextBox();
        }
        
        
        
    }//GEN-LAST:event_jBAddBookActionPerformed

    private void JBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMyBooksActionPerformed
        // TODO add your handling code here:
        MainFrame mainFrame = new MainFrame(this.myBooks);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBMyBooksActionPerformed
    //this metod should be in util or something like that 
    private int ComputeId(){
        System.out.println("Interface.NewBookFrame.ComputeId()");
        return  50;//acceder a lista de libros y revisar cuantos tiene
    }
    
    private void cleanTextBox(){
        UtilInterface.cleanTextBox(this.jTFAuthor);
        UtilInterface.cleanTextBox(this.jTFCategory);
        UtilInterface.cleanTextBox(this.jTFName);
    }
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
            java.util.logging.Logger.getLogger(NewBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewBookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBMyBooks;
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JPanel JPNewBook;
    private javax.swing.JButton jBAddBook;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JLabel jLMyBooks1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFAuthor;
    private javax.swing.JTextField jTFCategory;
    private javax.swing.JTextField jTFName;
    // End of variables declaration//GEN-END:variables
}
package Interface;

import Data.Book;
import Data.MyBooks;
import util.ReadJson;
import util.WriteJson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

/**
 * @author Usuario
 */
public class MainFrame extends javax.swing.JFrame {
    //TODO escribir los libros el Json(si los hay) en la tabla
    // ordenar al presionar el header de la tabla

    private MyBooks myBooks = new MyBooks();


    public MainFrame(MyBooks myBooks) {
        this.myBooks = myBooks;
        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooks.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(Color.BLUE);

        //poner logo en JLabel
        UtilInterface.printImage(JLProyectIcon, "src/Interface/MediaFiles/LogoOriginal.png", this);
        // rellenar tabla
        fillTable();

    }

    public MainFrame() {
        //TODO CHECK leer Json; crear la clase MyBook; cada vez que se inicie el programa verificar Json
        //TODO si no hay Json crear desde 0 (libro de prueba)
        try {
            ReadJson readJson = new ReadJson();
            this.myBooks = readJson.arrAuxToMyBooks(readJson.readJson());

        } catch (Exception ignored) {

        }

        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooks.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(Color.BLUE);
        fillTable();

        //poner logo en JLabel
        UtilInterface.printImage(JLProyectIcon, "src/Interface/MediaFiles/LogoOriginal.png", this);

    }

    private void fillTable() {
        UtilInterface.cleanJTable(jTMyBooks);
        for (int i = 0; i < this.myBooks.getMyBooks().count; i++) {
            int intid = this.myBooks.getMyBooks().elementPosition(i).getBookInformation().getId();
            String id = String.valueOf(intid + 1);
            String name = this.myBooks.getMyBooks().elementPosition(i).getBookInformation().getName();
            String author = this.myBooks.getMyBooks().elementPosition(i).getBookInformation().getAuthor();
            boolean state = this.myBooks.getMyBooks().elementPosition(i).getStatus();
            String strState;
            if (state) {
                strState = "Finalizado";
            } else {
                strState = "Sin finalizar";
            }
            String category = this.myBooks.getMyBooks().elementPosition(i).getBookInformation().getCategory();


            String[] tbData = {id, name, author, strState, category};
            DefaultTableModel tblModel = (DefaultTableModel) jTMyBooks.getModel();
            tblModel.addRow(tbData);


        }

    }

    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        JLProyectIcon = new javax.swing.JLabel();
        javax.swing.JPanel JPMyBooks = new javax.swing.JPanel();
        javax.swing.JScrollPane jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooks = new javax.swing.JTable();
        javax.swing.JButton jBMyBooks = new javax.swing.JButton();
        javax.swing.JLabel jLMyBooks = new javax.swing.JLabel();
        jTFmyBooks = new javax.swing.JTextField();
        javax.swing.JButton jBDeleteBook = new javax.swing.JButton();
        javax.swing.JButton jBNewBook = new javax.swing.JButton();
        javax.swing.JButton jBNewInform = new javax.swing.JButton();
        javax.swing.JButton jBFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", Font.BOLD, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        JPMyBooks.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Mis libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", Font.BOLD, 24))); // NOI18N

        jTMyBooks.setAutoCreateRowSorter(true);
        jTMyBooks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyBooks.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jTMyBooks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"0", "Libro 1", "Pedro", "Finalizado", "cat. 1"},
                        {"1", "Libro 2", "Carlos", "En lectura", "cat. 2"},
                        {"2", "Libro 3", "Esteban", "No empezado", "cat.3"}
                },
                new String[]{
                        "ID", "Nombre", "Autor", "Estado", "Categoria"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTMyBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTMyBooks.setGridColor(new java.awt.Color(255, 255, 255));
        jTMyBooks.setInheritsPopupMenu(true);
        jTMyBooks.setRowHeight(30);
        jTMyBooks.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyBooks);

        jBMyBooks.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jBMyBooks.setText("Información");
        jBMyBooks.addActionListener(evt -> jBMyBooksActionPerformed());

        jLMyBooks.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLMyBooks.setText("Escriba el ID del libro y luego presione el boton para acceder a su información");

        jTFmyBooks.addActionListener(evt -> jTFmyBooksActionPerformed());

        jBDeleteBook.setText("borrar libro");
        jBDeleteBook.addActionListener(evt -> jBDeleteBookActionPerformed());

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
                JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSPMyBooks))
                                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jBMyBooks)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jBDeleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 273, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        JPMyBooksLayout.setVerticalGroup(
                JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(JPMyBooksLayout.createSequentialGroup()
                                                .addComponent(jTFmyBooks)
                                                .addGap(3, 3, 3))
                                        .addComponent(jBDeleteBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jBNewBook.setText("Agregar libro");
        jBNewBook.addActionListener(evt -> jBNewBookActionPerformed());

        jBNewInform.setText("Filtrar");

        jBFilter.setText("Generar  informe");
        jBFilter.addActionListener(evt -> jBFilterActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBNewBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLProyectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jBNewInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(JPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBNewBook, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBNewInform, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 79, Short.MAX_VALUE)))
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

    //BOTONES:
    //TODO agregar links a todos los botones
    private void jBMyBooksActionPerformed() {

        if (this.jTFmyBooks.getText().length() > 0) {
            int id = Integer.parseInt(this.jTFmyBooks.getText());
            //checkear inputs invalidos - o que MyBooks esté vacío (se puede usar clase Util)
            Book book = this.myBooks.getMyBooks().elementPosition(id - 1);
            //System.out.println(id);
            book.printBook();
            BookInfoFrame bookInfo = new BookInfoFrame(book, this.myBooks);
            bookInfo.setVisible(true);
            this.dispose();


            this.dispose();
        }

    }

    private void jTFmyBooksActionPerformed() {//GEN-FIRST:event_jTFmyBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmyBooksActionPerformed

    private void jBNewBookActionPerformed() {//GEN-FIRST:event_jBNewBookActionPerformed
        NewBookFrame newBookFrame = new NewBookFrame(this.myBooks);
        newBookFrame.setVisible(true);
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jBNewBookActionPerformed

    private void jBFilterActionPerformed() {
        // TODO add your handling code here:
    }//GEN-LAST:event_jBFilterActionPerformed

    private void jBDeleteBookActionPerformed() {
        // TODO add your handling code here:
        if (this.jTFmyBooks.getText().length() > 0) {
            int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
            if (option == 0) {
                //System.out.println("se presionó el boton");
                int bookPosition = Integer.parseInt(this.jTFmyBooks.getText());
                this.myBooks.deleteBook(bookPosition - 1);
                WriteJson writeJson = new WriteJson();
                try {
                    writeJson.createAuxBook(this.myBooks.getMyBooks());

                } catch (IOException e) {
                    System.err.println("no se pudo guardar");
                }
                fillTable();

            }
        }


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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JTextField jTFmyBooks;
    private javax.swing.JTable jTMyBooks;
    // End of variables declaration//GEN-END:variables
}

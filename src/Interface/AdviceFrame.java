
package Interface;
import Data.Book;
import Data.MyBooks;
import Data.FrameAux;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import util.ReadJson;
import util.FrameStack;
import util.Heaps;


public class AdviceFrame extends javax.swing.JFrame {
    private MyBooks myBooks = new MyBooks();
    private FrameStack frameStack; 
    private Heaps heap;
    private MyBooks myBooks2;

    public AdviceFrame(MyBooks mybooks, Heaps heap, FrameStack frameStack) {
        
        this.myBooks2 = mybooks;
        this.myBooks = myBooks;
        this.myBooks.printAllBooks();
        this.frameStack = frameStack;
        this.heap=heap;
        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooksA.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooksA.getTableHeader().setForeground(Color.BLUE);

        //poner logo en JLabel
        UtilInterface.printImage(this.JLProyectIcon, "src/Interface/MediaFiles/LogoOriginal.png", this);
        // rellenar tabla
        fillTable();
        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        if(frameAux2.getTypeOfFrame()!= 1){
            FrameAux frame = new FrameAux(1, this.myBooks);
            this.frameStack.getStackFrame().push(frame);
        }
        

    }
    
    public AdviceFrame() {
            
        //TODO CHECK leer Json; crear la clase MyBook; cada vez que se inicie el programa verificar Json
        //TODO si no hay Json crear desde 0 (libro de prueba)
        try {
            ReadJson readJson = new ReadJson();
            this.myBooks = readJson.arrAuxToMyBooks(readJson.readJson());

        } catch (FileNotFoundException ignored) {
            System.out.println(ignored.getLocalizedMessage());
            System.out.println(ignored.getMessage());
            System.out.println("Interface.MainFrame.<init>() error al hacer lectura de Json");
        }

        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooksA.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooksA.getTableHeader().setForeground(Color.BLUE);
        fillTable();

        //poner logo en JLabel
        UtilInterface.printImage(JLProyectIcon, "src/Interface/MediaFiles/LogoOriginal.png", this);
        
        this.frameStack = new FrameStack(myBooks);
        //System.out.println("esta es la pila: ");
        //FrameAux s =(FrameAux) frameStack.getStackFrame().peek();
        //System.out.println(s.getTypeOfFrame());
        
        this.jBForward.setVisible(false);
        this.jBBack.setVisible(false);
        
    }
        
    private void fillTable() {
        UtilInterface.cleanJTable(jTMyBooksA);
        for (int i = 1; i <= this.heap.currentSize; i++) {
            int intid = i;
            Book book2 = (Book) heap.deleteMax();
            System.out.println(book2.getActualPage());
            String id = String.valueOf(intid);
            String name = book2.getBookInformation().getName();
            String pages = String.valueOf(book2.getActualPage());

            String[] tbData = {id, name, pages};
            DefaultTableModel tblModel = (DefaultTableModel) jTMyBooksA.getModel();
            tblModel.addRow(tbData);


        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLProyectIcon = new javax.swing.JLabel();
        JPMyBooks = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooksA = new javax.swing.JTable();
        jBMyBooks = new javax.swing.JButton();
        jLMyBooks = new javax.swing.JLabel();
        jTFmyBooks = new javax.swing.JTextField();
        jBForward = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        JPMyBooks.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "Mis libros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(31, 78, 121))); // NOI18N

        jTMyBooksA.setAutoCreateRowSorter(true);
        jTMyBooksA.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyBooksA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTMyBooksA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "Libro 1", "20"},
                {"1", "Libro 2", "10"},
                {"2", "Libro 3", "5"}
            },
            new String [] {
                "ID", "Nombre", "Pagina actual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMyBooksA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTMyBooksA.setGridColor(new java.awt.Color(31, 78, 121));
        jTMyBooksA.setInheritsPopupMenu(true);
        jTMyBooksA.setRowHeight(30);
        jTMyBooksA.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyBooksA);

        jBMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        jBMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBMyBooks.setForeground(new java.awt.Color(31, 78, 121));
        jBMyBooks.setText("INFORMACIÓN");
        jBMyBooks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBMyBooks.setContentAreaFilled(false);
        jBMyBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMyBooksActionPerformed(evt);
            }
        });

        jLMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLMyBooks.setText("Escriba el ID del libro y luego presione el boton que desee.");

        jTFmyBooks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFmyBooks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTFmyBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFmyBooksActionPerformed(evt);
            }
        });

        jBForward.setBackground(new java.awt.Color(255, 255, 255));
        jBForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/adelante.png"))); // NOI18N
        jBForward.setBorder(null);
        jBForward.setBorderPainted(false);
        jBForward.setContentAreaFilled(false);
        jBForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForwardActionPerformed(evt);
            }
        });

        jBBack.setBackground(new java.awt.Color(255, 255, 255));
        jBBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/atras.png"))); // NOI18N
        jBBack.setBorder(null);
        jBBack.setBorderPainted(false);
        jBBack.setContentAreaFilled(false);
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPMyBooks)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward))
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 186, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPMyBooksLayout.setVerticalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBBack)
                            .addComponent(jBForward))
                        .addContainerGap())
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMyBooksActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        if (this.jTFmyBooks.getText().length() > 0) {
            int id = Integer.parseInt(this.jTFmyBooks.getText());
            //checkear inputs invalidos - o que MyBooks esté vacío (se puede usar clase Util)
            Book book = this.myBooks.getMyBooks().elementPosition(id - 1);
            //System.out.println(id);
            book.printBook();
            BookInfoFrame bookInfo = new BookInfoFrame(book, this.myBooks,this.frameStack);
            bookInfo.setVisible(true);
            this.dispose();


            this.dispose();
        }
    }//GEN-LAST:event_jBMyBooksActionPerformed

    private void jTFmyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmyBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmyBooksActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        
        
        
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
            java.util.logging.Logger.getLogger(AdviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdviceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JPanel JPMyBooks;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBMyBooks;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JTextField jTFmyBooks;
    private javax.swing.JTable jTMyBooksA;
    // End of variables declaration//GEN-END:variables
}

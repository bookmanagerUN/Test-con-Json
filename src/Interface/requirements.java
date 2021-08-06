/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
//hola2
import Data.Book;
import Data.BookFilterName;
import Data.MyBooks;
import Data.FrameAux;
import Data.Search;
import Data.UserFinal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.FrameStack;
import util.LinkedList;



public class requirements extends javax.swing.JFrame {
    private MyBooks myBooks = new MyBooks();
    private FrameStack frameStack;
    private UserFinal user;

    /**
     * Creates new form NewJFrame1
     */
    
    public requirements(MyBooks myBooks, FrameStack frameStack, UserFinal user) {
        this.user = user;
        this.myBooks = myBooks;
        this.myBooks.printAllBooks();
        this.frameStack = frameStack;
        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooks.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(Color.BLUE);

        //poner logo en JLabel
        UtilInterface.printImage(this.JLProyectIcon, "src/Interface/MediaFiles/VAzul1.png", this);
        // rellenar tabla
        UtilInterface.cleanJTable(jTMyBooks);
        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        if(frameAux2.getTypeOfFrame()!= 6){
            FrameAux frame = new FrameAux(6, this.myBooks,this.user);
            this.frameStack.getStackFrame().push(frame);
        }
        this.jBGoToBook.setVisible(false);
        this.jTFID.setVisible(false);
        
        
        
        

    }
        
        
    private void fillTable(LinkedList<BookFilterName> listToFill) {
        UtilInterface.cleanJTable(jTMyBooks);
        for (int i = 0; i < listToFill.count; i++) {
            String id = String.valueOf(listToFill.elementPosition(i).id);
            System.out.println(id);
            String name = listToFill.elementPosition(i).name;
            String author = listToFill.elementPosition(i).author;
            boolean state = listToFill.elementPosition(i).status;
            String strState;
            if (state) {
                strState = "Finalizado";
            } else {
                strState = "Sin finalizar";
            }
            String category = listToFill.elementPosition(i).category;
            String page = String.valueOf(listToFill.elementPosition(i).page);


            String[] tbData = {id, name, author, category, strState, page};
            DefaultTableModel tblModel = (DefaultTableModel) jTMyBooks.getModel();
            tblModel.addRow(tbData);


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

        jPanel1 = new javax.swing.JPanel();
        JLProyectIcon = new javax.swing.JLabel();
        JPMyBooks = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooks = new javax.swing.JTable();
        jBGoToFilter = new javax.swing.JButton();
        jLMyBooks = new javax.swing.JLabel();
        jTFtoFilter = new javax.swing.JTextField();
        jBForward = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jCBOption = new javax.swing.JComboBox<>();
        jBGoToBook = new javax.swing.JButton();
        jTFID = new javax.swing.JTextField();
        jBNewBook = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        JPMyBooks.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "Filtro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(31, 78, 121))); // NOI18N

        jTMyBooks.setAutoCreateRowSorter(true);
        jTMyBooks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTMyBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Libro 1", "Pedro", "cat. 1", "Finalizado", null},
                {null, "Libro 2", "Carlos", "cat. 2", "En lectura", null},
                {null, "Libro 3", "Esteban", "cat.3", "No empezado", null}
            },
            new String [] {
                "ID", "Nombre", "Autor", "Categoria", "Estado", "Páginas leidas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMyBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTMyBooks.setGridColor(new java.awt.Color(31, 78, 121));
        jTMyBooks.setInheritsPopupMenu(true);
        jTMyBooks.setRowHeight(30);
        jTMyBooks.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyBooks);

        jBGoToFilter.setBackground(new java.awt.Color(255, 255, 255));
        jBGoToFilter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBGoToFilter.setForeground(new java.awt.Color(31, 78, 121));
        jBGoToFilter.setText("FILTRAR");
        jBGoToFilter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBGoToFilter.setContentAreaFilled(false);
        jBGoToFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGoToFilterActionPerformed(evt);
            }
        });

        jLMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLMyBooks.setText("Elija la opcion por la que quiere filtrar en la lista, luego coloque la palabra clave, por ultimo presione FILTRAR");

        jTFtoFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFtoFilter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTFtoFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtoFilterActionPerformed(evt);
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

        jCBOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Autor ", "Categoria" }));
        jCBOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBOptionActionPerformed(evt);
            }
        });

        jBGoToBook.setText("Ir al Libro");
        jBGoToBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGoToBookActionPerformed(evt);
            }
        });

        jTFID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTFID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jTFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMyBooks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSPMyBooks))
                        .addGap(6, 6, 6))
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addComponent(jBGoToBook, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTFID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addComponent(jCBOption, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTFtoFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jBGoToFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        JPMyBooksLayout.setVerticalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBOption, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFtoFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBGoToFilter))
                .addGap(65, 65, 65)
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGoToBook, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBForward)
                    .addComponent(jBBack))
                .addContainerGap())
        );

        jBNewBook.setText("Agregar libro");
        jBNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNewBookActionPerformed(evt);
            }
        });

        jBNewInform.setText("Recomendaciones");
        jBNewInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNewInformActionPerformed(evt);
            }
        });

        jBFilter.setText("filtro");
        jBFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFilterActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jBGoToFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGoToFilterActionPerformed
        // TODO add your handling code here:
        int option = jCBOption.getSelectedIndex();
        System.out.println(option);
        System.out.println(this.jTFtoFilter.getText().length());
        if (this.jTFtoFilter.getText().length() > 0) {
            Search search = new Search(this.jTFtoFilter.getText(), this.myBooks,option);
            this.jTFID.setVisible(true);
            this.jBGoToBook.setVisible(true);
            fillTable(search.toLinkedList());
            
        }
        else{
            int dilog = JOptionPane.showConfirmDialog(null, "rellene el espacio vacío");
            System.out.println("error");
        }
    }//GEN-LAST:event_jBGoToFilterActionPerformed

    private void jTFtoFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFtoFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFtoFilterActionPerformed

    private void jBNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewBookActionPerformed
        this.frameStack.cleanNextStack();
        
        NewBookFrame newBookFrame = new NewBookFrame(this.myBooks, this.frameStack, this.user);
        newBookFrame.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jBNewBookActionPerformed

    private void jBFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFilterActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jBFilterActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
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

    private void jBNewInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewInformActionPerformed
        this.frameStack.cleanNextStack();
        
        AdviceFrame AdviceFrame = new AdviceFrame(this.myBooks, this.frameStack, this.user);
        AdviceFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBNewInformActionPerformed

    private void jCBOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBOptionActionPerformed

    private void jBGoToBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGoToBookActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(this.jTFID.getText());
        Book checkBook = this.myBooks.getBookById(id);
        BookInfoFrame newFrame = new BookInfoFrame(checkBook, this.myBooks, this.frameStack,this.user);
        newFrame.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jBGoToBookActionPerformed

    private void jTFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIDActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JPanel JPMyBooks;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBGoToBook;
    private javax.swing.JButton jBGoToFilter;
    private javax.swing.JButton jBNewBook;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JComboBox<String> jCBOption;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JTextField jTFID;
    private javax.swing.JTextField jTFtoFilter;
    private javax.swing.JTable jTMyBooks;
    // End of variables declaration//GEN-END:variables
}
package Interface;

import Data.Book;
import Data.MyBooks;
import Data.FrameAux;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.ReadJson;
import util.FrameStack;
import util.Heaps;

public class AdviceFrame extends javax.swing.JFrame {

    private MyBooks myBooks = new MyBooks();
    private FrameStack frameStack;
    private Heaps heap;
    private MyBooks myBooks2;
    private Book book1;
    

    public AdviceFrame(MyBooks mybooks, FrameStack frameStack) {
        
        this.myBooks2 = mybooks;
        this.myBooks = myBooks;
        this.frameStack = frameStack;
        
        initComponents();
        UtilInterface.printImage(this.JLProyectIcon, "src/Interface/MediaFiles/VAzul1.png", this);
        heap = new Heaps<>();
        heap.buildHeap(myBooks2);
        fillLabels();
        if (this.frameStack.getStackFrame().count == 0) {
            this.jBBack.setVisible(false);
        }
        if (this.frameStack.getStackFrameNext().count == 0) {
            this.jBForward.setVisible(false);
        }

        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        if (frameAux2.getTypeOfFrame() != 5) {
            FrameAux frame = new FrameAux(5, this.myBooks2);
            this.frameStack.getStackFrame().push(frame);
        }
       
        
        

    }

    public AdviceFrame() {
       
        initComponents();
        heap = new Heaps();
        heap.buildHeap(myBooks2);

        UtilInterface.printImage(JLProyectIcon, "src/Interface/MediaFiles/VAzul1.png", this);

        this.frameStack = new FrameStack(myBooks2);
        

        this.jBForward.setVisible(false);
        this.jBBack.setVisible(false);
        
        

    }

    private void fillTable() {
        

    }
    
    private void fillLabels(){
        if(heap.currentSize>0){
            book1 = (Book) heap.deleteMax();
            if(book1 != null){
            
            jLabel9.setText(book1.getBookInformation().getName());
            jLabel10.setText(String.valueOf(book1.getActualPage()));
            }
            
        }
        else{
            int option = JOptionPane.showConfirmDialog(null, "No tienes mas sugerencias, ¿Quieres verlas de nuevo.?");
                if (option == 0) {
                    Heaps heap1=new Heaps();
                    heap1.buildHeap(myBooks2);
                    heap=heap1;
                    fillLabels();
             } else if (option == 1) {
                 System.out.println("ok");
                } else {
                 System.out.println("AAAAAAAAAAAA");
             }
        }
        
        
 
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLProyectIcon = new javax.swing.JLabel();
        JPMyBooks = new javax.swing.JPanel();
        jBMyBooks = new javax.swing.JButton();
        jLMyBooks = new javax.swing.JLabel();
        jBForward = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBMyBooks1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        JPMyBooks.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "Mis Sugerencias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(31, 78, 121))); // NOI18N

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
        jLMyBooks.setText("Escriba el nombre del libro y luego presione el boton que desee.");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Para continuar tus lecturas de la mejor manera");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Te sugerimos continuar con tus libros mas adelantados");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Continua con este libro:  ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(31, 78, 121));
        jLabel9.setText("jLabel9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 78, 121)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Página en la que lo dejaste la última vez :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(31, 78, 121));
        jLabel10.setText("jLabel10");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 78, 121)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dale click al boton, y mira la siguiente sugerencia.");

        jBMyBooks1.setBackground(new java.awt.Color(255, 255, 255));
        jBMyBooks1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBMyBooks1.setForeground(new java.awt.Color(31, 78, 121));
        jBMyBooks1.setText("Siguiente.");
        jBMyBooks1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBMyBooks1.setContentAreaFilled(false);
        jBMyBooks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMyBooks1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JPMyBooksLayout.createSequentialGroup()
                                    .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBMyBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                                    .addGap(138, 138, 138)
                                    .addComponent(jBForward)
                                    .addGap(8, 8, 8))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        JPMyBooksLayout.setVerticalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBMyBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBBack)
                        .addGap(36, 36, 36))
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward)
                        .addGap(30, 30, 30))))
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
                    .addComponent(JLProyectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMyBooksActionPerformed
         if(book1!=null){
             BookInfoFrame bookInfo = new BookInfoFrame(book1, this.myBooks2,this.frameStack);
            bookInfo.setVisible(true);
            this.dispose();
         }
         else{
             
         }
        
    }//GEN-LAST:event_jBMyBooksActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        System.out.println(frameas.getTypeOfFrame());

        frameStack.pop();

        frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
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

    private void jBMyBooks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMyBooks1ActionPerformed
        

        fillLabels();
    }//GEN-LAST:event_jBMyBooks1ActionPerformed

    public static void main(String args[]) {
       
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
    private javax.swing.JButton jBMyBooks1;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

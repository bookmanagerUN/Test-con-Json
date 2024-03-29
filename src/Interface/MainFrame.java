/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
//hola2
import Data.Book;
import Data.MyBooks;
import Data.FrameAux;
import Data.Search;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ReadJson;
import util.WriteJson;
import util.FrameStack;
import util.Heaps;
import util.MyStack;
import Data.UserFinal;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Graphs;
import util.readTxt;


/**
 *
 * @author Usuario
 */
public class MainFrame extends javax.swing.JFrame {
    private MyBooks myBooks = new MyBooks();
    private FrameStack frameStack;
    private Heaps<Book> heap;
    private UserFinal user;
    /**
     * Usuario actual, permite ivocar su JSON correspondiente.
     */
    

    /**
     * Creates new form NewJFrame1
     */
    
    public MainFrame(MyBooks myBooks, FrameStack frameStack, UserFinal user) {
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
        fillTable();
        if(this.frameStack.getStackFrame().count == 1){
            this.jBBack.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward.setVisible(false);
        }
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        if(frameAux2.getTypeOfFrame()!= 1){
            FrameAux frame = new FrameAux(1, this.myBooks,this.user);
            this.frameStack.getStackFrame().push(frame);
        }
        
        heap = new Heaps<>();
        heap.buildHeap(myBooks);
        
        
        

    }
    
    /**
     * Constructor que recibe el usuario, es el mismo constructor que no recibe
     * parámetros pero con el usuario para invocar el JSON con el que se inicializarán
     * los libros de este mismo.
     * 
     * @param user usuario que accedió desde {@link LogInFrame} o {@ling SignInFrame}.
     */
    
    
    public MainFrame(UserFinal user) {
            
        //TODO CHECK leer Json; crear la clase MyBook; cada vez que se inicie el programa verificar Json
        //TODO si no hay Json crear desde 0 (libro de prueba)
        this.user=user;
        try {
            ReadJson readJson = new ReadJson(this.user.getFile());
            this.myBooks = readJson.arrAuxToMyBooks(readJson.readJson());

        } catch (FileNotFoundException ignored) {
            System.out.println(ignored.getLocalizedMessage());
            System.out.println(ignored.getMessage());
            System.out.println("Interface.MainFrame.<init>() error al hacer lectura de Json");
        }
        this.myBooks.printAllBooks();
        Graphs grafo = new Graphs();
        try {
            grafo.setGraph(readTxt.readGraphTxt("requisitos/"+this.user.getName()+".txt"));
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.myBooks.setDependences(grafo);
        System.out.println(this.myBooks.getDependences().getGraph().toString());
        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooks.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(Color.BLUE);
        fillTable();

        //poner logo en JLabel
        UtilInterface.printImage(JLProyectIcon, "src/Interface/MediaFiles/VAzul1.png", this);
        
        this.frameStack = new FrameStack(myBooks, this.user);
        //System.out.println("esta es la pila: ");
        //FrameAux s =(FrameAux) frameStack.getStackFrame().peek();
        //System.out.println(s.getTypeOfFrame());
        
        this.jBForward.setVisible(false);
        this.jBBack.setVisible(false);
        heap = new Heaps<>();
        heap.buildHeap(myBooks);
        
    }
        
    private void fillTable() {
        UtilInterface.cleanJTable(jTMyBooks);
        for (int i = 0; i < this.myBooks.getMyBooks().count; i++) {
            int intid = i;
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
        jBMyBooks = new javax.swing.JButton();
        jLMyBooks = new javax.swing.JLabel();
        jTFmyBooks = new javax.swing.JTextField();
        jBDeleteBook = new javax.swing.JButton();
        jBForward = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jBNewBook = new javax.swing.JButton();
        jBNewInform = new javax.swing.JButton();
        jBFilter = new javax.swing.JButton();
        jBpre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BoockManager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        JLProyectIcon.setBackground(new java.awt.Color(255, 51, 51));
        JLProyectIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLProyectIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPMyBooks.setBackground(new java.awt.Color(255, 255, 255));
        JPMyBooks.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true), "Mis libros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(31, 78, 121))); // NOI18N

        jTMyBooks.setAutoCreateRowSorter(true);
        jTMyBooks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTMyBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "Libro 1", "Pedro", "Finalizado", "cat. 1"},
                {"1", "Libro 2", "Carlos", "En lectura", "cat. 2"},
                {"2", "Libro 3", "Esteban", "No empezado", "cat.3"}
            },
            new String [] {
                "ID", "Nombre", "Autor", "Estado", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jBDeleteBook.setBackground(new java.awt.Color(255, 255, 255));
        jBDeleteBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBDeleteBook.setForeground(new java.awt.Color(31, 78, 121));
        jBDeleteBook.setText("BORRAR LIBRO");
        jBDeleteBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 78, 121), 2, true));
        jBDeleteBook.setContentAreaFilled(false);
        jBDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteBookActionPerformed(evt);
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
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSPMyBooks)
                            .addGroup(JPMyBooksLayout.createSequentialGroup()
                                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                                        .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBDeleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 189, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jBBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward)
                        .addGap(31, 31, 31))))
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
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBForward)
                            .addComponent(jBBack))
                        .addContainerGap())
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBDeleteBook, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jBMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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

        jBpre.setText("Prerrequisitos");
        jBpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBNewBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLProyectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jBNewInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jBpre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(18, 18, 18)
                        .addComponent(jBpre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            BookInfoFrame bookInfo = new BookInfoFrame(book, this.myBooks,this.frameStack,this.user);
            bookInfo.setVisible(true);
            this.dispose();


            this.dispose();
        }
    }//GEN-LAST:event_jBMyBooksActionPerformed

    private void jTFmyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmyBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmyBooksActionPerformed

    private void jBDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteBookActionPerformed
        // TODO add your handling code here:
        this.frameStack.cleanNextStack();
        if (this.jTFmyBooks.getText().length() > 0) {
            int option = JOptionPane.showConfirmDialog(null, "¿confirma?");
            if (option == 0) {
                //System.out.println("se presionó el boton");
                int bookPosition = Integer.parseInt(this.jTFmyBooks.getText());
                this.myBooks.deleteBook(bookPosition - 1);
                WriteJson writeJson = new WriteJson();
                try {
                    writeJson.createAuxBook(this.myBooks.getMyBooks(),this.user.getFile());

                } catch (IOException e) {
                    System.err.println("no se pudo guardar");
                }
                fillTable();

            }
        }
    }//GEN-LAST:event_jBDeleteBookActionPerformed

    private void jBNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewBookActionPerformed
        this.frameStack.cleanNextStack();
        
        NewBookFrame newBookFrame = new NewBookFrame(this.myBooks, this.frameStack,this.user);
        newBookFrame.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jBNewBookActionPerformed

    private void jBFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFilterActionPerformed
        // TODO add your handling code here:
        
        FilterFrame filter = new FilterFrame(this.myBooks, this.frameStack, this.user);
        filter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBFilterActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        // TODO add your handling code here:
        
        
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

    private void jBpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpreActionPerformed
        this.frameStack.cleanNextStack();
        
        requirements requirements= new requirements(this.myBooks, this.frameStack, this.user);
        requirements.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBpreActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLProyectIcon;
    private javax.swing.JPanel JPMyBooks;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBDeleteBook;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBForward;
    private javax.swing.JButton jBMyBooks;
    private javax.swing.JButton jBNewBook;
    private javax.swing.JButton jBNewInform;
    private javax.swing.JButton jBpre;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JTextField jTFmyBooks;
    private javax.swing.JTable jTMyBooks;
    // End of variables declaration//GEN-END:variables
}

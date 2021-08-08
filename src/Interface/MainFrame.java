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
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;


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
        this.jTMyBooks.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(new Color(204,204,204));
        this.jTMyBooks.getTableHeader().setBackground(new Color(31,78,121));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTMyBooks.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        

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

        initComponents();

        // cambiar headers de la tabla
        this.jTMyBooks.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
        this.jTMyBooks.getTableHeader().setForeground(new Color(204,204,204));
        this.jTMyBooks.getTableHeader().setBackground(new Color(31,78,121));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTMyBooks.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        fillTable();
        
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
        JPMyBooks = new javax.swing.JPanel();
        jSPMyBooks = new javax.swing.JScrollPane();
        jTMyBooks = new javax.swing.JTable();
        jTFmyBooks = new javax.swing.JTextField();
        kButton4 = new com.k33ptoo.components.KButton();
        jSeparator1 = new javax.swing.JSeparator();
        kButton5 = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        jBBack = new javax.swing.JButton();
        jBForward = new javax.swing.JButton();
        kButton6 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 78, 121));

        JPMyBooks.setBackground(new java.awt.Color(204, 204, 204));

        jTMyBooks.setAutoCreateRowSorter(true);
        jTMyBooks.setBackground(new java.awt.Color(204, 204, 204));
        jTMyBooks.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTMyBooks.setForeground(new java.awt.Color(31, 78, 121));
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
        jTMyBooks.setGridColor(new java.awt.Color(204, 204, 204));
        jTMyBooks.setInheritsPopupMenu(true);
        jTMyBooks.setRowHeight(30);
        jTMyBooks.setSelectionBackground(new java.awt.Color(31, 78, 121));
        jTMyBooks.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTMyBooks.setShowGrid(false);
        jTMyBooks.getTableHeader().setReorderingAllowed(false);
        jSPMyBooks.setViewportView(jTMyBooks);

        jTFmyBooks.setBackground(new java.awt.Color(204, 204, 204));
        jTFmyBooks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTFmyBooks.setForeground(new java.awt.Color(31, 78, 121));
        jTFmyBooks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFmyBooks.setBorder(null);
        jTFmyBooks.setCaretColor(new java.awt.Color(31, 78, 121));
        jTFmyBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFmyBooksActionPerformed(evt);
            }
        });

        kButton4.setBorder(null);
        kButton4.setText("Info");
        kButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton4.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton4.setkBorderRadius(0);
        kButton4.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton4.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton4.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton4.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton4.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton4.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(31, 78, 121));

        kButton5.setBorder(null);
        kButton5.setText("Delete");
        kButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton5.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton5.setkBorderRadius(0);
        kButton5.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton5.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton5.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton5.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton5.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton5.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(45, 117, 182));
        jPanel2.setForeground(new java.awt.Color(45, 117, 182));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("User/Books");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("USER BOOKS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPMyBooksLayout.setVerticalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jTFmyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                        .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGap(30, 30, 30)
                .addComponent(jSPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        kButton1.setBorder(null);
        kButton1.setText("Add Book");
        kButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton1.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton1.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton1.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton1.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton1.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton1.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setBorder(null);
        kButton2.setText("Filter");
        kButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton2.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton2.setkBorderRadius(0);
        kButton2.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton2.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton2.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton2.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton2.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton2.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setBorder(null);
        kButton3.setText("Recomendations");
        kButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton3.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton3.setkBorderRadius(0);
        kButton3.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton3.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton3.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton3.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton3.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
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

        kButton6.setBorder(null);
        kButton6.setText("Log Out");
        kButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton6.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton6.setkBorderRadius(0);
        kButton6.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton6.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverForeGround(new java.awt.Color(31, 78, 121));
        kButton6.setkHoverStartColor(new java.awt.Color(204, 204, 204));
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
                        .addGap(17, 17, 17)
                        .addComponent(jBBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBForward)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(JPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBBack)
                    .addComponent(jBForward))
                .addGap(51, 51, 51)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(JPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        this.frameStack.cleanNextStack();
        AdviceFrame AdviceFrame = new AdviceFrame(this.myBooks, this.frameStack, this.user);
        AdviceFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        FilterFrame filter = new FilterFrame(this.myBooks, this.frameStack, this.user);
        filter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        this.frameStack.cleanNextStack();

        NewBookFrame newBookFrame = new NewBookFrame(this.myBooks, this.frameStack,this.user);
        newBookFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

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

    private void jTFmyBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmyBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmyBooksActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
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
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
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
    }//GEN-LAST:event_kButton5ActionPerformed

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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMyBooks;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBForward;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSPMyBooks;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFmyBooks;
    private javax.swing.JTable jTMyBooks;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    // End of variables declaration//GEN-END:variables
}

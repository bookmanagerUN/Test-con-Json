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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.FrameStack;
import util.LinkedList;
import util.readTxt;



public class Prerequisites extends javax.swing.JFrame {
    private MyBooks myBooks = new MyBooks();
    private FrameStack frameStack;
    private UserFinal user;
    private LinkedList<String> requirements = new LinkedList<>();

    /**
     * Creates new form NewJFrame1
     */
    
    public Prerequisites(MyBooks myBooks, FrameStack frameStack, UserFinal user) {
        this.user = user;
        this.myBooks = myBooks;
        this.myBooks.printAllBooks();
        this.frameStack = frameStack;
        
        initComponents();

        if(this.frameStack.getStackFrame().count == 0){
            this.jBBack1.setVisible(false);
        }
        if(this.frameStack.getStackFrameNext().count == 0){
            this.jBForward2.setVisible(false);
        }
        
        FrameAux frameAux2 = (FrameAux) this.frameStack.getStackFrame().peek();
        if(frameAux2.getTypeOfFrame()!= 6){
            FrameAux frame = new FrameAux(6, this.myBooks,this.user);
            this.frameStack.getStackFrame().push(frame);
        }
        
        this.jPanel3.setVisible(false);
        fillCBMainBook();
        this.jTFBook.setToolTipText("Book");
        this.jTFreq.setToolTipText("Prerequisite");
    }
    
    private void cleanInterface(){
        this.jCBRequirements.removeAllItems();
        fillCBMainBook();
        this.jPanel3.setVisible(false);
        this.jTFBook.setToolTipText("Book");
        this.jTFreq.setToolTipText("Prerequisite");
        this.jTFreq.setText("");
        this.jTFBook.setText("");
    }
    
    private void fillCBMainBook(){
        LinkedList<String> listOfVertex = this.myBooks.getDependences().getListVertex();
        System.out.println(listOfVertex.toString());
        for(int i = 0; i< listOfVertex.numberOfElements();i++){
            this.jCBMainBook.addItem(listOfVertex.elementPosition(i));
        }
    }
    private void fillCBrequirements(LinkedList<String> requirements){
        for(int i = 0; i< requirements.numberOfElements();i++){
            this.jCBRequirements.addItem(requirements.elementPosition(i));
        }
    }
    private void fillJList(LinkedList<String> requirements){
        DefaultListModel modelo = new DefaultListModel();
        for(int i = 0; i< requirements.numberOfElements();i++){
            modelo.addElement(requirements.elementPosition(i));
        }
        this.jList1.setModel(modelo);
    }
    public void addToRequirements(String book, String requirement){
        
        if(myBooks.getDependences().getGraph().contains(book)){
            if(myBooks.getDependences().getGraph().contains(requirement)){
                myBooks.getDependences().addEdge(requirement,book);
            }
            else{
                myBooks.getDependences().addVertex(requirement);
                myBooks.getDependences().addEdge(requirement,book);
            }           
        }
        else{
            myBooks.getDependences().addVertex(book);
            if(myBooks.getDependences().getGraph().contains(requirement)){
                myBooks.getDependences().addEdge(requirement,book);
            }
            else{
                myBooks.getDependences().addVertex(requirement);
                myBooks.getDependences().addEdge(requirement,book);
            }    
        }

        System.out.println(myBooks.getDependences().getGraph().toString());
        try {
            readTxt.updadeGraphTxt(user.getName(),myBooks.getDependences());
        } catch (IOException ex) {
            Logger.getLogger(Prerequisites.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"El prerrequisito fue añadido correctamente");
        
    } 
    
    public void deleteToRequirement(String book, String requirement){
        
        if(myBooks.getDependences().getGraph().contains(book)){
            if(myBooks.getDependences().getGraph().contains(requirement)){
                myBooks.getDependences().deleteEdge(book,requirement);
                try {
                    readTxt.updadeGraphTxt(user.getName(),myBooks.getDependences());
                } catch (IOException ex) {
                    Logger.getLogger(Prerequisites.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"El prerrequisito fue eliminado correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null,"El libro "+requirement+ " no se encuentra en sus prerequisitos");
            }           
        }
        else{
            JOptionPane.showMessageDialog(null,"El libro "+book+ " no se encuentra en sus prerequisitos");    
        }

        System.out.println(myBooks.getDependences().getGraph().toString());
        
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
        jLMyBooks = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBMainBook = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jCBRequirements = new javax.swing.JComboBox<>();
        kButton7 = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();
        jLBook = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        kButton4 = new com.k33ptoo.components.KButton();
        jTFBook = new javax.swing.JTextField();
        kButton5 = new com.k33ptoo.components.KButton();
        jTFreq = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBHome = new javax.swing.JButton();
        jBBack1 = new javax.swing.JButton();
        jBForward2 = new javax.swing.JButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jSeparator2 = new javax.swing.JSeparator();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 78, 121));

        JPMyBooks.setBackground(new java.awt.Color(204, 204, 204));

        jLMyBooks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLMyBooks.setForeground(new java.awt.Color(31, 78, 121));
        jLMyBooks.setText("Choose the book and then modify their prerequisites");

        jPanel2.setBackground(new java.awt.Color(45, 117, 182));
        jPanel2.setForeground(new java.awt.Color(45, 117, 182));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("User/Library/Requirements");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Requirements");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCBMainBook.setBackground(new java.awt.Color(204, 204, 204));
        jCBMainBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBMainBook.setForeground(new java.awt.Color(31, 78, 121));
        jCBMainBook.setBorder(null);
        jCBMainBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMainBookActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 249));

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(31, 78, 121), 2));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jCBRequirements.setBackground(new java.awt.Color(204, 204, 204));
        jCBRequirements.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBRequirements.setForeground(new java.awt.Color(31, 78, 121));
        jCBRequirements.setBorder(null);
        jCBRequirements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRequirementsActionPerformed(evt);
            }
        });

        kButton7.setBorder(null);
        kButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-borrar-para-siempre-32.png"))); // NOI18N
        kButton7.setText("Delete requirement");
        kButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton7.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton7.setkBorderRadius(0);
        kButton7.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton7.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton7.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton7.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton7.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton7.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 78, 121));
        jLabel4.setText("Delete requirement between");

        jLBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLBook.setText("book selected");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 78, 121));
        jLabel6.setText("and");

        jSeparator1.setBackground(new java.awt.Color(31, 78, 121));
        jSeparator1.setForeground(new java.awt.Color(31, 78, 121));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 78, 121));
        jLabel7.setText("Prerequisites");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLBook, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jCBRequirements, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBRequirements, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLBook, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(41, 41, 41)
                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        kButton4.setBorder(null);
        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-busca-mas-32.png"))); // NOI18N
        kButton4.setText("Search");
        kButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        jTFBook.setBackground(new java.awt.Color(204, 204, 204));
        jTFBook.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTFBook.setForeground(new java.awt.Color(31, 78, 121));
        jTFBook.setToolTipText("");
        jTFBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBookActionPerformed(evt);
            }
        });

        kButton5.setBorder(null);
        kButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-añadir-libro-32.png"))); // NOI18N
        kButton5.setText("Add requirement");
        kButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        kButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        kButton5.setkBackGroundColor(new java.awt.Color(31, 78, 121));
        kButton5.setkBorderRadius(0);
        kButton5.setkEndColor(new java.awt.Color(31, 78, 121));
        kButton5.setkForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverColor(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverEndColor(new java.awt.Color(45, 117, 182));
        kButton5.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverStartColor(new java.awt.Color(45, 117, 182));
        kButton5.setkPressedColor(new java.awt.Color(31, 78, 121));
        kButton5.setkSelectedColor(new java.awt.Color(204, 204, 204));
        kButton5.setkStartColor(new java.awt.Color(31, 78, 121));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        jTFreq.setBackground(new java.awt.Color(204, 204, 204));
        jTFreq.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTFreq.setForeground(new java.awt.Color(31, 78, 121));
        jTFreq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFreqActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 78, 121));
        jLabel5.setText("Add");

        javax.swing.GroupLayout JPMyBooksLayout = new javax.swing.GroupLayout(JPMyBooks);
        JPMyBooks.setLayout(JPMyBooksLayout);
        JPMyBooksLayout.setHorizontalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jTFBook, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jTFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPMyBooksLayout.createSequentialGroup()
                        .addComponent(jCBMainBook, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
            .addGroup(JPMyBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPMyBooksLayout.setVerticalGroup(
            JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPMyBooksLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBMainBook, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPMyBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFBook, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBHome.setBackground(new java.awt.Color(255, 255, 255));
        jBHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-casa-prefabricada-32.png"))); // NOI18N
        jBHome.setBorder(null);
        jBHome.setBorderPainted(false);
        jBHome.setContentAreaFilled(false);
        jBHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHomeActionPerformed(evt);
            }
        });

        jBBack1.setBackground(new java.awt.Color(255, 255, 255));
        jBBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-volver-96.png"))); // NOI18N
        jBBack1.setBorder(null);
        jBBack1.setBorderPainted(false);
        jBBack1.setContentAreaFilled(false);
        jBBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBack1ActionPerformed(evt);
            }
        });

        jBForward2.setBackground(new java.awt.Color(255, 255, 255));
        jBForward2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/icons8-adelante-96.png"))); // NOI18N
        jBForward2.setBorder(null);
        jBForward2.setBorderPainted(false);
        jBForward2.setContentAreaFilled(false);
        jBForward2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBForward2ActionPerformed(evt);
            }
        });

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

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBBack1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBForward2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jBHome)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPMyBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBForward2)
                            .addComponent(jBBack1))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPMyBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHomeActionPerformed
        this.frameStack.cleanNextStack();
        MainFrame mainFrame = new MainFrame(this.myBooks, this.frameStack, this.user);
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBHomeActionPerformed

    private void jBBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBack1ActionPerformed
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
    }//GEN-LAST:event_jBBack1ActionPerformed

    private void jBForward2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBForward2ActionPerformed
        FrameAux frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        System.out.println(frameas.getTypeOfFrame());

        frameStack.nextToNormal();

        frameas = (FrameAux) frameStack.getStackFrame().peek();

        System.out.println(frameas.getMyBooks().toString());
        JFrame frame = this.frameStack.generateFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBForward2ActionPerformed

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

    private void jCBMainBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMainBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBMainBookActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        
        int option = this.jCBMainBook.getSelectedIndex();
        String field = this.myBooks.getDependences().getListVertex().elementPosition(option);
        LinkedList<String> requirements = this.myBooks.getDependences().getGraph().search(field);
        this.jPanel3.setVisible(true);
        fillCBrequirements(requirements);
        fillJList(requirements);
        this.requirements = requirements;
        this.jLBook.setText(field);
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        String book = this.jTFBook.getText();
        String req = this.jTFreq.getText();
        addToRequirements(req, book);
        cleanInterface();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        int option = this.jCBRequirements.getSelectedIndex();
        String req = this.requirements.elementPosition(option);
        String book = this.jLBook.getText();
        deleteToRequirement(book,req);
        cleanInterface();
    }//GEN-LAST:event_kButton7ActionPerformed

    private void jTFBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBookActionPerformed

    private void jCBRequirementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRequirementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRequirementsActionPerformed

    private void jTFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFreqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFreqActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPMyBooks;
    private javax.swing.JButton jBBack1;
    private javax.swing.JButton jBForward2;
    private javax.swing.JButton jBHome;
    private javax.swing.JComboBox<String> jCBMainBook;
    private javax.swing.JComboBox<String> jCBRequirements;
    private javax.swing.JLabel jLBook;
    private javax.swing.JLabel jLMyBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTFBook;
    private javax.swing.JTextField jTFreq;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    // End of variables declaration//GEN-END:variables
}

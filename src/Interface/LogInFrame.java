/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Data.UserFinal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.HashTable;
import util.LinkedList;
import util.readTxt;

/**
 *
 * @author Diego Quintero
 */
public class LogInFrame extends javax.swing.JFrame {
    /**
     * Tabla hash desde donde se acceden a los usuarios en caso de que, el email
     * o el nombre suministrado sea el correcto, y además la contraseña sea la 
     * correcta.
     */
    private HashTable<String,UserFinal> users;
    
    /**
     * Creates new form Opción
     */
    public LogInFrame() throws IOException {
        this.initializeHashTable();
        initComponents();
        
    }
    
    private void initializeHashTable() throws IOException{
        //this.users = new HashTable<String (username),User>();
        this.users = new HashTable<String,UserFinal>();
        //TODO que savedUsers sea inicializado con un JSON
        /**
         * Arreglo de strings donde se encuentran los usuarios, representa lo que
         * se debe cargar desde el JSON y a su vez lo que se debe guardar. cada
         * string está configurada como "Nombre, Email, Contraseña".
         */
        LinkedList<String> savedUsers =readTxt.ReadTxt() ;
        
        
        for(int i=0; i<savedUsers.count ;i++ ){
            String cadena = savedUsers.elementPosition(i);
            String[] detached = cadena.split(",");
            System.out.println("hey");
            UserFinal actualUser = new UserFinal(detached[0],detached[1],detached[2],detached[3]);
             
            this.users.insert(detached[0],actualUser);
           
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jSlider1 = new javax.swing.JSlider();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        PasswordField = new javax.swing.JPasswordField();
        UserField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        SignInPageChangeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jButton2.setBackground(new java.awt.Color(1, 48, 91));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Alredy a member, Log In");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 78, 121));
        jPanel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("User or Email");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Password");

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        PasswordField.setBackground(new java.awt.Color(31, 78, 121));
        PasswordField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(204, 204, 204));
        PasswordField.setBorder(null);
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        UserField.setBackground(new java.awt.Color(31, 78, 121));
        UserField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        UserField.setForeground(new java.awt.Color(204, 204, 204));
        UserField.setToolTipText("");
        UserField.setBorder(null);
        UserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserFieldActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(31, 78, 121));
        LoginButton.setText("Log In");
        LoginButton.setBorder(null);
        LoginButton.setBorderPainted(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        SignInPageChangeButton.setBackground(new java.awt.Color(1, 48, 91));
        SignInPageChangeButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        SignInPageChangeButton.setForeground(new java.awt.Color(204, 204, 204));
        SignInPageChangeButton.setText("Not a member, Sign in.");
        SignInPageChangeButton.setBorder(null);
        SignInPageChangeButton.setBorderPainted(false);
        SignInPageChangeButton.setContentAreaFilled(false);
        SignInPageChangeButton.setDefaultCapable(false);
        SignInPageChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInPageChangeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SignInPageChangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SignInPageChangeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/MediaFiles/VAzul1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Changing the way in which it is read and understood");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(81, 81, 81)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserFieldActionPerformed

    @SuppressWarnings("deprecation")
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String insertedUser = this.UserField.getText();
        String insertedPassword = this.PasswordField.getText();
        UserFinal hypotheticalUser = new UserFinal(insertedUser,insertedUser,insertedPassword, insertedUser+".json");
        
        
        
        if(this.users.contains(insertedUser)){
            String pass = this.users.search(insertedUser).getPassword();
            if(pass.compareTo(insertedPassword)==0){
                MainFrame main = new MainFrame(hypotheticalUser);
                main.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto o Clave Incorrecta.");
            }
        } else
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto o Clave Incorrecta.");
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            LogInFrame login = new LogInFrame();
            login.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SignInPageChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInPageChangeButtonActionPerformed
        // TODO add your handling code here:
        SignInFrame signin = new SignInFrame(this.users);
        signin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SignInPageChangeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LogInFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SignInPageChangeButton;
    private javax.swing.JTextField UserField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

/*
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    username ||||password|||correo|||file
    
    
    
*/


}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class UtilInterface {
    
    public static void printImage(JLabel label, String location,JFrame frame){
        System.out.println("Interface.Util.printImage()");
        ImageIcon image;
        Icon icon;
        image = new ImageIcon(location);
        icon= new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        frame.repaint();
    }
    public static void setPanelText(String text, JPanel jPanel){
    
        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24)));
        System.out.println("Interface.Util.setPanelText()");
    }
    public static void cleanJTable(JTable jTable){
        DefaultTableModel modelo=(DefaultTableModel) jTable.getModel();
        int filas= jTable.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        
    }
    static void cleanTextBox(JTextField textField){
        textField.setText("");
    }
    static void cleanTextArea(JTextArea textArea){
        textArea.setText("");
    }
    
}

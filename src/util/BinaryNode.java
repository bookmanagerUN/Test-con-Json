/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * 
 * @author Diego Andrés Quintero Rois
 */
public class BinaryNode<DataType> {
    public BinaryNode<DataType> parent;
    public BinaryNode<DataType> right;
    public BinaryNode<DataType> left;
    public DataType data;
    public int height;

    public BinaryNode(DataType data) {
        this.data = data;
        this.parent = null;
        this.right = null;
        this.left = null;
        this.height = 0;
    }
}
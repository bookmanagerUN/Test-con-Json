/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.treeStructures;

import util.BinaryNode;

/**
 * {@code ÁRBOL AVL}.
 * <p>Es un tipo de árbol BST con la propiedad de que es autobalanceable, lo cuál se logra con la siguiente propiedad:
 * <ul><ul>
 * <li>La altura de las ramas, contadas desde la raíz, no difieren por más de 1.
 * </ul></ul>
 * <p>La altura se define como:
 * <ul><ul>
 * <li>0 si no existe nodo, ergo, la referencia es nula.
 * <li>1+max(HI,HD), esto es, 1 sumado a la altura máxima entre el hijo menor y el hijo mayor.
 * </ul></ul>
 * <p>Esto permite solucionar los problemas de complejidad que tenía en Arbol BST, logrando que todas las operaciones se
 * logren en O(log n).
 *
 * @author Diego Andrés Quintero Rois
 * @version 1.1
 * @param <DataType> Tipo de dato abstracto (ADT) que a su vez implementa la interfaz {@link Comparable}.
 */
public class AVLTree<DataType extends Comparable<? super DataType>> extends BSTree<DataType> {

    /**
     * Construye un Árbol AVL vacío invocando al Super Constructor.
     */
    public AVLTree() {
        super();
    }

    /**
     * Inserta un dato empleando {@link BSTree#insert(Comparable)} y aplica los métodos de balanceo de {@link #balance(BinaryNode)}.
     *
     * @param data dato a insertar.
     */
    @Override
    public void insert(DataType data) {
        super.insert(data);
        BinaryNode<DataType> dataNode = super.find(super.root, data);
        this.balance(dataNode);
    }

    /**
     * Elimina un dato empleando {@link BSTree#delete(Comparable)} y aplica los métodos de balanceo de {@link #balance(BinaryNode)}.
     *
     * @param data dato a eliminar.
     */
    @Override
    public void delete(DataType data) {
        if(!super.checkNode(data)) return;
        BinaryNode<DataType> dataNode = super.find(super.root, data);
        BinaryNode<DataType> parent = dataNode.right == null ? dataNode.parent : super.next(dataNode).parent;
        super.delete(data);
        if(parent != null) this.balance(parent);
    }

    /**
     * Hace el balanceo recursivo y de manera ascendente desde el nodo que se insertó, hasta la raíz,
     * basandose en la comparación de las alturas de los nodos insertados que se actualiza en los métodos
     * {@link #balanceRight(BinaryNode)} y {@link #balanceLeft(BinaryNode)}.
     * @param node nodo que se pretende balancear.
     */
    private void balance(BinaryNode<DataType> node) {
        BinaryNode<DataType> parent = node.parent;
        int leftHeight = node.left != null ? node.left.height : 0;
        int rightHeight = node.right != null ? node.right.height : 0;

        if(leftHeight > rightHeight + 1)
            this.balanceRight(node);
        if(rightHeight > leftHeight + 1)
            this.balanceLeft(node);

        this.adjustHeight(node);
        if(parent != null)
            this.balance(parent);
    }

    /**
     * Se hace el balanceo rotacional hacia la derecha del nodo en cuestión, sin embargo, en caso de que
     * el nodo hijo izquierdo tenga más peso en el lado derecho (!Ojo!, es distinto a estar desbalanceado y
     * es solo si el lado derecho tiene más peso, no el lado izquierdo), será necesario ajustarlo para que la
     * rotación de su padre sea satisfactoria, esto es rotarlo hacia la izquierda para que el peso del nodo
     * hijo izquierdo recaiga en su lado izquierdo.
     *
     * @param node nodo a rotar hacia la derecha.
     */
    private void balanceRight(BinaryNode<DataType> node) {
        BinaryNode<DataType> left = node.left;
        int leftHeightOfLeft = left.left != null ? left.left.height : 0;
        int rightHeightOfLeft = left.right != null ? left.right.height : 0;

        if(rightHeightOfLeft > leftHeightOfLeft)
            this.rotateLeft(left);
        this.rotateRight(node);
    }

    /**
     * Se hace el balanceo rotacional hacia la izquierda del nodo en cuestión, sin embargo, en caso de que
     * el nodo hijo derecho tenga más peso en el lado izquierdo (!Ojo!, es distinto a estar desbalanceado y
     * es solo si el lado izquierdo tiene más peso, no el lado derecho), será necesario ajustarlo para que la rotación
     * de su padre sea satisfactoria, esto es rotarlo hacia la derecha para que el peso del nodo hijo derecho recaiga en su lado derecho.
     *
     * @param node nodo a rotar hacia la derecha.
     */
    private void balanceLeft(BinaryNode<DataType> node) {
        BinaryNode<DataType> right = node.right;
        int leftHeightOfRight = right.left != null ? right.left.height : 0;
        int rightHeightOfRight = right.right != null ? right.right.height : 0;

        if(leftHeightOfRight > rightHeightOfRight)
            this.rotateRight(right);
        this.rotateLeft(node);
    }

    /**
     * Rotación simple a la derecha, donde el hijo izquierdo se convierte en padre y el padre adquiere la
     * posición de hijo derecho del que fué su hijo izquierdo.
     *
     * @param node nodo a rotar a la derecha.
     */
    private void rotateRight(BinaryNode<DataType> node) {
        BinaryNode<DataType> parent = node.parent;
        BinaryNode<DataType> leftSon = node.left;
        BinaryNode<DataType> rightSubRootOfLeftSon = leftSon.right;

        leftSon.parent=parent;

        if(parent == null) {
            super.root = leftSon;
        } else {
            if(leftSon.data.compareTo(parent.data) < 0)
                parent.left = leftSon;
            else if(leftSon.data.compareTo(parent.data) > 0)
                parent.right = leftSon;
        }

        node.parent=leftSon;
        leftSon.right=node;
        if(rightSubRootOfLeftSon!=null)rightSubRootOfLeftSon.parent=node;
        node.left=rightSubRootOfLeftSon;

        this.adjustHeight(node);
        this.adjustHeight(leftSon);
    }

    /**
     * Rotación simple a la izquierda, donde el hijo derecho se convierte en padre y el padre adquiere la
     * posición de hijo izquierdo del que fué su hijo derecho.
     *
     * @param node nodo a rotar a la derecha.
     */
    private void rotateLeft(BinaryNode<DataType> node) {
        BinaryNode<DataType> parent = node.parent;
        BinaryNode<DataType> rightSon = node.right;
        BinaryNode<DataType> leftSubRootOfRightSon = rightSon.left;

        rightSon.parent=parent;

        if(parent == null) {
            super.root = rightSon;
        } else {
            if(rightSon.data.compareTo(parent.data) < 0)
                parent.left = rightSon;
            else if(rightSon.data.compareTo(parent.data) > 0)
                parent.right = rightSon;
        }

        node.parent=rightSon;
        rightSon.left=node;
        if(leftSubRootOfRightSon!=null)leftSubRootOfRightSon.parent=node;
        node.right=leftSubRootOfRightSon;

        this.adjustHeight(node);
        this.adjustHeight(rightSon);
    }

    /**
     * Se ajusta el parámetro de la altura del nodo en cuestión en función de la altura que tengan sus hijos.
     *
     * @param node Nodo a ajustar su parámetro de altura.
     */
    private void adjustHeight(BinaryNode<DataType> node) {
        int leftHeight = node.left != null ? node.left.height : 0;
        int rightHeight = node.right != null ? node.right.height : 0;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }
}
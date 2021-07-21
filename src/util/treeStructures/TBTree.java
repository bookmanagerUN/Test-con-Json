/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.treeStructures;

import util.BinaryNode;
import util.MyQueue;

/**
 * {@code ÁRBOL BINARIO TRANSVERSAL}.
 * <p>Es un tipo de estructura de datos conformada por nodos que hacen referencia, a como máximo, dos nodos más. También
 * es posible definirlo como un grafo donde todos los nodos están conectados, el grado del vertice no es mayor a dos,
 * sin bucles y es no dirigido
 *
 * @author Diego Andrés Quintero Rois
 * 
 * @param <DataType> Tipo de dato abstracto (ADT) que a su vez implementa la interfaz {@link Comparable}.
 */
public class TBTree /*TraversalBinaryTree*/ <DataType extends Comparable<? super DataType>>{
    /**
     * Referencia a la raíz del árbol binario
     */
    protected BinaryNode<DataType> root;
    /**
     * Número de nodos que tiene el arbol binario
     */
    protected int nodes;

    /**
     * Construye un Árbol Binario Transversal vacío llamando al método {@link #makeEmpty()}.
     */
    public TBTree() {
        this.makeEmpty();
    }

    /**
     * Método que inicializa el método recursivo {@link #preorder(BinaryNode)}
     */
    public void preorder() {
        this.preorder(this.root);
    }

    /**
     * Método recursivo que imprime la subraíz, luego imprime el hijo izquierdo y posteriormente el derecho.
     * @param node Parámetro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     */
    private void preorder(BinaryNode<DataType> node) {
        if(node != null) {
            System.out.print(node.data + " ");
            this.preorder(node.left);
            this.preorder(node.right);
        }
    }

    /**
     * Método que inicializa el método recursivo {@link #postorder(BinaryNode)}
     */
    public void postorder() {
        this.postorder(this.root);
    }

    /**
     * Método recursivo que imprime el hijo izquierdo, luego imprime el hijo derecho y posteriormente la subraíz.
     * @param node Parámetro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     */
    private void postorder(BinaryNode<DataType> node) {
        if(node != null) {
            this.postorder(node.left);
            this.postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Método que inicializa el método recursivo {@link #inorder(BinaryNode)}
     */
    public void inorder() {
        this.inorder(this.root);
    }

    /**
     * Método recursivo que imprime el nodo izquierdo, luego imprime la subraíz y posteriormente el hijo derecho.
     * @param node Parámetro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     */
    private void inorder(BinaryNode<DataType> node) {
        if(this.root == null) {
            System.err.print("No es posible ejecutar este método");
            return;
        }
        if(node != null) {
            this.inorder(node.left);
            System.out.print(node.data + " ");
            this.inorder(node.right);
        }
    }

    /**
     * Método que inicializa el método recursivo {@link #levelOrder(BinaryNode)}
     */
    public void levelOrder() {
        this.levelOrder(this.root);
    }

    /**
     * Método recursivo que imprime el árbol por niveles.
     * @param node nodo desde el cuál se va a hacer el recorrido por niveles
     */
    private void levelOrder(BinaryNode<DataType> node) {
        if(this.root == null) {
            System.err.print("No es posible ejecutar este método");
            return;
        }
        MyQueue<BinaryNode<DataType>> queue = new MyQueue<>();
        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            BinaryNode<DataType> aux = queue.dequeue();
            if(aux.left != null) queue.enqueue(aux.left);
            if(aux.right != null) queue.enqueue(aux.right);
            System.out.print(aux.data + " ");
        }
    }

    /**
     * Verifica que la raíz del arbol no sea nula, lo que implica conocer si el arbol
     * está vacío o no.
     *
     * @return Valor booleano de si el arbol está vacío o no.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Vacía el arbol en cuestión quitando la referencia de la raíz.
     */
    public void makeEmpty() {
        this.root = null;
        this.nodes = 0;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.treeStructures;

import util.BinaryNode;
import util.LinkedList;

/**
 * {@code ÁRBOL BINARIO DE BÚSQUEDA (BST)}.
 * <p>Es una estructura de datos del tipo árbol que funciona almacenando datos de tipo abstracto (ADT) a través de nodos
 * enlazados entre si por referencias, las cuales son, como mínimo, referencias al hijo derecho (HD) e hijo izquierdo(HI); el nodo
 * que porta con estas referencias a sus hijos, se le denomina nodo padre y a su vez subraíz (R). Los datos estan ordenados de tal forma que
 * siempre se cumpla, siempre y cuando existan los nodos, que el hijo izquierdo sea menor a su padre y el hijo derecho,
 * menor a su hijo.
 *
 * <p>Para que un árbol sea BST es necesario que, dada una subraíz "R" con hijos "HD" e "HI", se cumpla simultaneamente:
 * <ul><ul>
 * <li>Que "HI es nulo" o "R es mayor que la totalidad del subarbol conformado por su HI, el cuál también es BST".
 * <li>Que "HD es nulo" o "R es menor que la totalidad del subarbol conformado por su HD, el cuál también es BST".
 * </ul></ul>
 *
 * @author Diego Andrés Quintero Rois
 * 
 * @param <DataType> Tipo de dato abstracto (ADT) que a su vez implementa la interfaz {@link Comparable}.
 */
public class BSTree /*BinarySearchTree*/ <DataType extends Comparable<? super DataType>> extends TBTree<DataType> {

    /**
     * Construye un Árbol Binario de Búsqueda vacío llamando al Super Constructor.
     */
    public BSTree() {
        super();
    }

    /**
     * Inserta un dato a través del método recursivo {@link #insert(BinaryNode, Comparable)}.
     *
     * @param data dato a insertar.
     */
    @SuppressWarnings("deprecation")
    public void insert(DataType data) {
        this.root = this.insert(this.root, data);
    }

    /**
     * Método recursivo que permite hallar la referencia nula donde debería ir el nodo del dato suministrando (Aquel que
     * se desea insertar); este consiste en recorrer logaritmicamente un camino del árbol dado el orden lógico comparativo
     * del tipo de dato abstracto (ADT).
     * @param node Parámetro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     * @param data Dato a insertar en el árbol.
     * @return La raíz con el número de descendientes incrementado en 1.
     */
    private BinaryNode<DataType> insert(BinaryNode<DataType> node, DataType data) {
        if(node == null) {
            nodes++;
            return new BinaryNode<>(data);
        } else if(data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
            node.left.parent = node;
        } else if(data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
            node.right.parent = node;
        }
        return node;
    }

    /**
     * Elimina un dato siempre y cuando exista en el árbol; el método de eliminación consiste en buscar el nodo
     * donde se encuentra el dato a eliminar, empleando el método {@link #find(BinaryNode, Comparable)}, para
     * posteriormente aplicar el método {@link #delete(BinaryNode)}.
     *
     * @param data dato a eliminar.
     */
    public void delete(DataType data) {
        if(super.isEmpty()) return;
        if(!checkNode(data)) return;
        this.delete(find(this.root, data));
    }

    /**
     * Elimina el nodo suministrado al método ajustando las referencias internas de cada nodo según sea el caso, este
     * proceso se realiza empleando los métodos {@link #promote(BinaryNode, BinaryNode)}, {@link #swap(BinaryNode, BinaryNode)}
     * , {@link #next(Comparable)}
     * @param node Nodo a eliminar.
     */
    private void delete(BinaryNode<DataType> node) {
        if(node.right == null)
            this.promote(node, node.left);
        else {
            BinaryNode<DataType> nextNode = next(node);
            this.swap(node, nextNode);
            this.promote(nextNode, nextNode.right);
        }
        nodes--;
    }

    /**
     * Elimina un subarbol suministrando el dato del nodo subraíz.
     *
     * @param data subraíz del árbol que se desea eliminar.
     */
    public void remove(DataType data) {
        this.remove(find(this.root, data));
    }

    /**
     * Se remueve el nodo suministrado al método; esto implica que su desendencia también será
     * eliminada.
     *
     * @param node nodo a eliminar.
     */
    private void remove(BinaryNode<DataType> node) {
        if(node.data.compareTo(node.parent.left.data) == 0)
            node.parent.left = null;
        else
            node.parent.right = null;
    }

    /**
     * Encuentra un dato y lo retorna, siempre y cuando este exista en el árbol; este método emplea el método recursivo
     * {@link #find(BinaryNode, Comparable)}.
     *
     * @param data dato a encontrar.
     * @return dato encontrado.
     */
    public DataType find(DataType data) {
        if(super.isEmpty()) return null;
        return find(super.root, data).data;
    }

    /**
     * Método recursivo que permite hallar el nodo de un dato suministrando este último; este consiste en recorrer
     * logaritmicamente un camino del árbol dado el orden lógico comparativo del tipo de dato abstracto (ADT).
     * @param node parametro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     * @param data Dato del nodo que se desea encontrar
     * @return
     */
    protected BinaryNode<DataType> find(BinaryNode<DataType> node, DataType data) {
        if(data.compareTo(node.data) == 0)
            return node;
        else if(data.compareTo(node.data) > 0)
            return node.right == null ? node : find(node.right, data);
        else if(data.compareTo(node.data) < 0)
            return node.left == null ? node : find(node.left, data);
        return node;
    }

    /**
     * Halla el dato siguiente de un dato dado a través del método {@link #next(BinaryNode)}.
     *
     * @param data dato al que se le desea hallar su siguiente ascendente.
     * @return dato siguiente al suministrado.
     */
    public DataType next(DataType data) {
        if(this.isEmpty()) return null;
        BinaryNode<DataType> toReturn = next(find(this.root, data));
        return toReturn != null ? toReturn.data : null;
    }

    /**
     * Método que permite hallar el nodo siguiente a un nodo suministrado; este consiste en emplear {@link #leftDescendant(BinaryNode)}
     * al hijo derecho para encontrar el menor dato de dicho subarbol, que es a su vez el siguiente nodo al suministrado;
     * en caso de que no halla desendiente derecho, esto es que no halla subarbol derecho, se halla el ancestro siguiente del nodo con
     * {@link #rightAncestor(BinaryNode)}, que sería también su siguiente.
     * @param node Nodo suministrado al cuál se desea hallar su siguiente.
     * @return Nodo siguiente a un nodo suministrado.
     */
    protected BinaryNode<DataType> next(BinaryNode<DataType> node) {
        return node.right != null ? leftDescendant(node.right) : rightAncestor(node);
    }

    /**
     * Crea una lista de orden ascendente con todos los datos existentes en el arbol dentro de un intervalo.
     *
     * @param firstData cota inferior del intervalo.
     * @param lastData  cota superior del intervalo.
     * @return lista de orden ascendente con los datos existentes dentro del intervalo.
     */
    public LinkedList<DataType> search(DataType firstData, DataType lastData) {
        LinkedList<DataType> auxList = new LinkedList<>();
        if(this.isEmpty()) return auxList;
        DataType auxData = this.find(firstData);
        auxData = auxData.compareTo(firstData) >= 0 ? auxData : this.next(auxData);
        while (auxData != null && lastData.compareTo(auxData) >= 0) {
            auxList.insertEnd(auxData);
            auxData = this.next(auxData);
        }
        return auxList;
    }

    /**
     * Método recursivo que permite hallar el descendiente con menor valor numérico perteneciente al subárbol dada una
     * subraíz como parámetro inicial de la recursión.
     *
     * @param node subraíz del subárbol al que se le hallará el nodo con menor valor.
     * @return Nodo descendiente con menor valor númerico.
     */
    private BinaryNode<DataType> leftDescendant(BinaryNode<DataType> node) {
        return node.left == null ? node : leftDescendant(node.left);
    }

    /**
     * Método recursivo que permite hallar el ancestro cuyo valor sea, si y solo si, mayor al del nodo suministrado.
     *
     * @param node parametro que se asigna recursivamente. Indica el nodo actual desde donde se están haciendo las
     *             comparaciones.
     * @return Nodo ancestro con mayor valor númerico al nodo suministrado al inicio de la recursión.
     */
    private BinaryNode<DataType> rightAncestor(BinaryNode<DataType> node) {
        if(node.parent == null) return null;
        return node.data.compareTo(node.parent.data) < 0 ? node.parent : rightAncestor(node.parent);
    }

    /**
     * Se promueve un nodo; esto es, que el nodo en cuestión adquiere la posición de su padre,
     * conservando la referencia a sus hijos. el nodo padre queda olvidado, por lo tanto deja de
     * exisitir.
     *
     * @param sire nodo padre.
     * @param seed nodo hijo que pretende adquirir la posición de su padre.
     */
    private void promote(BinaryNode<DataType> sire, BinaryNode<DataType> seed) {
        if(seed != null) seed.parent = sire.parent;

        if(sire == this.root)
            this.root = seed;
        else if(sire.parent.left != null && sire.data.compareTo(sire.parent.left.data) == 0)
            sire.parent.left = seed;
        else if(sire.parent.right != null && sire.data.compareTo(sire.parent.right.data) == 0)
            sire.parent.right = seed;
    }

    /**
     * Intercambia los datos de un par de nodos suministrados, lo que permite mantener las
     * referencias a otros nodos sin demasiadas complicaciones en comparación a si se decide volver a
     * referenciar ambos nodos.
     *
     * @param node1 nodo 1 a intercambiar dato con nodo 2.
     * @param node2 nodo 2 a intercambiar dato con nodo 1.
     */
    private void swap(BinaryNode<DataType> node1, BinaryNode<DataType> node2) {
        DataType data1 = node1.data;
        node1.data = node2.data;
        node2.data = data1;
    }

    /**
     * Verifica la existencia de un nodo en el árbol, dado un hipotético dato existente.
     *
     * @param data dato del nodo a comprobar existencia en el árbol.
     * @return el valor booleano de si el nodo existe o no.
     */
    protected boolean checkNode(DataType data) {
        return data.compareTo(find(this.root, data).data) == 0;
    }
}

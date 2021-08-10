/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lenovo
 */
public class Graphs<T> {
    private HashTable<T,LinkedList<T>> graph = new HashTable();

    private LinkedList<T> listVertex;
    private LinkedList<T> vertexVisited;

    public Graphs(){
        listVertex = new LinkedList<>();
        vertexVisited = new LinkedList<>();
    }

    public LinkedList<T> getListVertex() {
        return listVertex;
    }

    public LinkedList<T> getVertexVisited() {
        return vertexVisited;
    }

    public HashTable<T, LinkedList<T>> getGraph() {
        return graph;
    }

    public void setGraph(HashTable<T, LinkedList<T>> graph) {
        this.graph = graph;
    }
    
    public void addVertex(T key){
        graph.insert(key,new LinkedList<>());
        listVertex.insertEnd(key);
    }

    public void deleteVertex(T key){
        graph.delete(key);
    }

    public void addEdge(T key1,T key2){

        //Controlar nulos

        LinkedList<T> temp = graph.search(key1);

        if(temp.contains(key2)){
            System.err.println("Esta conexión ya está creada");
        }else{
            graph.delete(key1);
            temp.insertEnd(key2);
            graph.insert(key1,temp);
        }
    }

    public void deleteEdge(T key1,T key2) {
        System.out.println("DHFJDSKJFKDSFBDSJFDKJGFDKGFDSGFJG");
        LinkedList<T> temp = graph.search(key1);
        System.out.println(temp.toString());
        System.out.println(key1+"////"+key2);
        if(temp.contains(key2)){
            System.out.println("");
            LinkedList<Integer> pos = temp.find(key2);
            System.out.println(pos.toString());
            temp.deletePosition(pos.headElement());
        }else{
            System.err.println("No es posible eliminar esta conexión porque no existe");
        }

    }

    public void topologicalSort(){
        MyStack stack = new MyStack();
        // iterate through all the nodes and their neighbours if not already visited.
        for (int i=0;i<listVertex.count;i++){
            T c= listVertex.elementPosition(i);
            if (!vertexVisited.contains(c)){
                sort(c,stack);
            }
        }
        // print all the elements in the stack in reverse order
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }

    // this recursive method iterates through all the nodes and neighbours.
    // Pushes the visited items to stack
    private void sort(T ch, MyStack stack){
        // add the visited node to list, so we don't repeat this node again
        vertexVisited.insertEnd(ch);
        // the leaf nodes wouldn't have neighbors. A check added to avoid null pointer
        if(graph.search(ch)!=null){
            // get all the neighbor nodes , by referring its edges

            T neighborNode;
            // if an edge exists for the node, then visit that neighbor node

            for (int j=0; j<graph.search(ch).count;j++){
                neighborNode = graph.search(ch).elementPosition(j);
                if (!vertexVisited.contains(neighborNode)){
                    sort(neighborNode,stack);
                }
            }
        }
        // push the latest node on to the stack
        stack.push(ch);
    }

    public static void main(String[] args) {
        Graphs<String> grafo= new Graphs();
        /*
        grafo.addVertex("Go to ATM");
        grafo.addVertex("Fix Computer");
        grafo.addVertex("Taxes");
        grafo.addVertex("Buy stamps");
        grafo.addVertex("Look up recipe");
        grafo.addVertex("Buy groceries");
        grafo.addVertex("cook dinner");
        grafo.addVertex("mail recipe");
        grafo.addVertex("mail postcard");
        grafo.addVertex("mail tax");

        grafo.addEdge("Go to ATM","Buy stamps");
        grafo.addEdge("Go to ATM","Buy groceries");

        grafo.addEdge("Fix Computer","Taxes");
        grafo.addEdge("Fix Computer","Look up recipe");

        grafo.addEdge("Taxes","mail tax");

        grafo.addEdge("Buy stamps","mail tax");
        grafo.addEdge("Buy stamps","mail postcard");
        grafo.addEdge("Buy stamps","mail recipe");

        grafo.addEdge("Buy groceries","cook dinner");
        grafo.addEdge("Look up recipe","Buy groceries");
        grafo.addEdge("Look up recipe","mail recipe");
        grafo.addEdge("Look up recipe","cook dinner");
        */

        /*grafo.addVertex("Discretas 1");
        grafo.addVertex("Discretas 2");
        grafo.addVertex("Discretas 3");
        grafo.addVertex("algoritmos");

        grafo.addEdge("Discretas 3","Discretas 2");
        grafo.addEdge("algoritmos","Discretas 2");
        grafo.addEdge("Discretas 2","Discretas 1");



        grafo.topologicalSort();*/
        
        Graphs<String> aux = new Graphs<>();

        
        aux.addVertex("Discretas 1");
        aux.addVertex("Discretas 2");
        aux.addVertex("Discretas 3");
        aux.addVertex("Discretas 4");
        aux.addVertex("Algoritmos 1");
        aux.addVertex("Algoritmos 2");
        aux.addVertex("Algoritmos 3");
        
        aux.addEdge("Discretas 2", "Discretas 1");
        aux.addEdge("Discretas 2", "Discretas 4");
        aux.addEdge("Discretas 3", "Discretas 2");
        aux.addEdge("Discretas 4", "Discretas 3");
        aux.addEdge("Discretas 1", "Algoritmos 2");
        aux.addEdge("Algoritmos 2", "Algoritmos 1");   
        System.out.println(aux.getGraph().toString());
        for(int i=0; i<aux.getGraph().toTxt().numberOfElements();i++){
            String[] xd = aux.getGraph().toTxt().elementPosition(i).split("=");
        
            System.out.println(xd[0]);
            System.out.println(xd[1]);
        }


    }

}

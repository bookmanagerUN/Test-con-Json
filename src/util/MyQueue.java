package util;

public class MyQueue<T> {
    private NodoSimpleLinkedList<T> front;
    private NodoSimpleLinkedList<T> back;

    public MyQueue(){
        makeEmpty();
    }
    public void makeEmpty(){
        back=null;
        front=null;
    }
    public void enqueue (T toInsert){
        NodoSimpleLinkedList<T> newNodo= new NodoSimpleLinkedList<>(toInsert);
        if(front==null){
            front=newNodo;
            back=newNodo;
        }
        else{
            back.setNext(newNodo);
            back = newNodo;
        }
    }
    public T dequeue(){
        if(front==null){
            System.out.println("ERROR cola vacia");
            return null;
        }
        else {
            NodoSimpleLinkedList<T> aux = front;
            front = front.getNext();
            return ((T) aux.getData());
        }
    }
    public T peek(){
        if(this.front==null){
            System.out.println("ERROR cola vacia");
            return null;
        }
        else{
            return (T) this.front.getData();
        }
    }
    public boolean isEmpty(){
        if(this.front==null){
            return true;
        }
        else{
            return false;
        }
    }


    private NodoSimpleLinkedList<T> getFront() {
        return front;
    }

    private void setFront(NodoSimpleLinkedList<T> front) {
        this.front = front;
    }

    private NodoSimpleLinkedList<T> getBack() {
        return back;
    }

    private void setBack(NodoSimpleLinkedList<T> back) {
        this.back = back;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodoSimpleLinkedList<T> aux = this.front;
        if(aux==null){
            return "La cola esta vacia";
        }
        while (aux != null){
            sb.append(aux.getData());
            sb.append(", ");
            aux = aux.getNext();
        }
        String toReturn = sb.toString();
        toReturn =  toReturn.substring(0, sb.length() - 2);
        return toReturn+"]";
    }
}

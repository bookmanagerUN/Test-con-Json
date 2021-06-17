package util;

public class Nodo<TypeData> {
    private TypeData data;

    public Nodo(TypeData data) {
        this.data = data;


    }


    public TypeData getData() {
        return data;
    }

    public void setData(TypeData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "data=" + data +
                '}';
    }
}

class NodoSimpleLinkedList<TypeData> extends Nodo {
    private NodoSimpleLinkedList<TypeData> next;

    public NodoSimpleLinkedList(TypeData data) {
        super(data);
        this.next = null;


    }

    public NodoSimpleLinkedList<TypeData> getNext() {
        return next;
    }

    public void setNext(NodoSimpleLinkedList<TypeData> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodoSimpleLinkedList{" +
                "next=" + next +
                "} " + super.toString();
    }
}

class NodoDoublyLinkedList<TypeData> extends Nodo {
    private NodoDoublyLinkedList<TypeData> next;
    private NodoDoublyLinkedList<TypeData> prev;

    public NodoDoublyLinkedList(TypeData data) {
        super(data);
    }

    public NodoDoublyLinkedList<TypeData> getNext() {
        return next;
    }

    public void setNext(NodoDoublyLinkedList<TypeData> next) {
        this.next = next;
    }

    public NodoDoublyLinkedList<TypeData> getPrev() {
        return prev;
    }

    public void setPrev(NodoDoublyLinkedList<TypeData> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "NodoDoublyLinkedList{" +
                "next=" + next +
                ", prev=" + prev +
                "} " + super.toString();
    }
}


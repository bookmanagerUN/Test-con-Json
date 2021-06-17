package util;


public class MyBST<T extends Comparable<? super T>> {
        private NodoDoublyLinkedList<T> root;

        public MyBST() {
                makeEmpty();
        }
        public void preOrden(){
                this.auxPreOrder(this.root);

        }
        private  void auxPreOrder(NodoDoublyLinkedList<T> auxRoot){

                if(auxRoot!=null){
                        System.out.print(auxRoot.getData()+" ");
                        auxPreOrder(auxRoot.getPrev());
                        auxPreOrder(auxRoot.getNext());
                }
        }
        public void posOrden(){
                this.auxPosOrder(this.root);
        }
        private void auxPosOrder(NodoDoublyLinkedList<T> auxRoot){
                if(auxRoot!=null){
                        auxPosOrder(auxRoot.getPrev());
                        auxPosOrder(auxRoot.getNext());
                        System.out.print(auxRoot.getData()+" ");
                }
        }
        public void inOrden(){
                this.auxInOrder(this.root);
        }
        private void auxInOrder(NodoDoublyLinkedList<T> auxRoot){
                if(auxRoot!=null){
                        auxInOrder(auxRoot.getPrev());
                        System.out.print(auxRoot.getData()+" ");
                        auxInOrder(auxRoot.getNext());
                }
        }
        public void levels(){
                this.auxLevel(this.root);
        }
        private void auxLevel(NodoDoublyLinkedList<T> auxRoot){
                MyQueue<NodoDoublyLinkedList<T>> c = new MyQueue<>();
                NodoDoublyLinkedList<T> aux;
                c.enqueue(auxRoot);
                while(!c.isEmpty()){
                        aux = c.dequeue();
                        System.out.print(aux.getData()+" ");
                        if(aux.getPrev() !=null){
                                c.enqueue(aux.getPrev());
                        }
                        if(aux.getNext()!=null){
                                c.enqueue(aux.getNext());
                        }
                }
        }
        public void insert(T newData){
                this.root = this.insert(newData, this.root);
        }

        public NodoDoublyLinkedList<T> insert(T newData, NodoDoublyLinkedList<T> aux){
                if(aux == null)
                        return new NodoDoublyLinkedList<>(newData);
                int compareResult = newData.compareTo((T)aux.getData());
                if(compareResult < 0)
                        aux.setPrev(insert(newData,aux.getPrev()));
                else if(compareResult > 0)
                        aux.setNext(insert(newData, aux.getNext()));
                return aux;
        }

        public void makeEmpty(){
        this.root = null;
        }

        public NodoDoublyLinkedList<T> getRoot() {
                return root;
        }

        public void setRoot(NodoDoublyLinkedList<T> root) {
                this.root = root;
        }
}

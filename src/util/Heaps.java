/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Arrays;

class Heaps1<T extends Comparable<? super T>> {

    private static final int defaultCapacity = 10;
    private int currentSize;
    private T[] array;

    //Constructor para inicializar un heap con capacidad por defecto
    public Heaps1() {
        this.array = (T[]) new Comparable[defaultCapacity];
    }

    //Constructor para inicializar un heap con capacidad dada por consola
    public Heaps1(int capacity) {
        this.array = (T[]) new Comparable[capacity + 1];
    }

    // Metodo para duplicar el tamaño de un array
    private T[] duplicateLength(T[] arr) {
        arr = Arrays.copyOf(arr, arr.length * 2 + 1);
        return arr;
    }
    
    // Metodo para insertar un elemento a la cola de prioridad
     void insert(T x){
         if(currentSize==array.length-1){
             array = duplicateLength(array);
         }
         percolateUp(array, x);
     }
     
    //Metodo para modificar el monticulo cada vez que se quiera insertar un elemento, manteniendo la propiedad de orden y estructura
    private void percolateUp(T[] arr, T x){
        int hole = ++currentSize;
        for(arr[0]=x; x.compareTo(arr[hole/2])>0;hole/=2){
            arr[hole]=array[hole/2];
        }
        arr[hole]=x;
    }
    //Metodo para saber si el monticulo está vacio
     public Boolean isEmpty(){
         if(array.length==0){
             return true;
         }
         return false;
     }
     
     // Metodo para devolver el valor mayor del monticulo
     public T findMax(){
         if(this.isEmpty()){
             System.out.println("El monticulo está vacio, no se puede retornar el valor menor");
         }
         return array[1];
     }
     
     // Metodo para elminar el elemento con mayor valor en el monticulo
     public T deleteMax(){
         if(this.isEmpty()){
             System.out.println("No es posible eliminar porque el monticulo no tiene elementos");
         }
         T min = findMax();
         array[1] = array[currentSize--];
         percolateDown(1);
         return min;
                  
     }
     //Metodo para modificar el monticulo cada vez que se quiera insertar un elemento, manteniendo la propiedad de orden y estructura
     private void percolateDown(int hole){
         int child;
         T tmp = array[hole];
         for(;hole*2 <= currentSize; hole=child){
             child=hole*2;
             if(child!=currentSize && array[child+1].compareTo(array[child])>0){
             child++;
             }
             if(array[child].compareTo(tmp)>0){
                 array[hole] = array[child];
             }else{
                 break;
             }
         }
         array[hole]=tmp;
     }
     
    // Metodo para imprimir los elementos del monticulo
     void recorrer(){
         for(int i=1; i<this.array.length;i++){
             System.out.print(array[i]+ " ");
         }
     }

}

public class Heaps {

    public static void main(String[] args) {
        Heaps1<Integer> asd = new Heaps1<>();
        asd.insert(2);
        asd.insert(3);
        asd.insert(4);
        asd.insert(6);
        asd.insert(1);
        asd.insert(0);
        asd.insert(5);
        asd.recorrer();
        System.out.println("");
        asd.deleteMax();
        asd.insert(8);
        asd.insert(7);
        System.out.println("");
        asd.recorrer();
        asd.deleteMax();
        System.out.println("");
        asd.recorrer();
        System.out.println("");
        System.out.println(asd.findMax());
    }

}

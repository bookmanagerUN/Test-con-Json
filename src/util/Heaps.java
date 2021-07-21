/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.MyBooks;
import java.util.Arrays;



public class Heaps<T extends Comparable<? super T>> {
    

    private static final int defaultCapacity = 10;
    public int currentSize;
    private T[] array;

    //Constructor para inicializar un heap con capacidad por defecto
    public Heaps() {
        this.array = (T[]) new Comparable[defaultCapacity];
    }

    //Constructor para inicializar un heap con capacidad dada por consola
    public Heaps(int capacity) {
        this.array = (T[]) new Comparable[capacity + 1];
    }
    
    public void buildHeap(MyBooks myBooks){
         for(int i= 0; i< myBooks.getMyBooks().count;i++){
             this.insert((T)myBooks.getMyBooks().elementPosition(i));
    }    
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
     public T recorrer(int i){
         return array[i];
     }



    }



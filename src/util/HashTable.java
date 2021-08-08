/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.nio.BufferUnderflowException;

/**
 *
 * @author Diego Quintero
 */
@SuppressWarnings("unchecked")
public class HashTable<KeyType, ValueType> {
    private HashData<KeyType, ValueType>[] hashTable;
    private final int MAX_SIZE = 0x3b9aca00;
    private float lambda;
    private int capacity;
    private int keys;

    public HashTable() {
        this.makeEmpty();
    }

    public void insert(KeyType key, ValueType value){
        if(contains(key))
            System.err.println("Está sobreescribiendo el valor de una clave.");
        int hashCode = Math.abs(key.hashCode());

       
        if(lambda >= 0.5)
            this.rehashing(2 * this.capacity);

        HashData<KeyType, ValueType> aux;
        int i = Math.abs(key.hashCode() % this.capacity);

        while(true) {
            aux = hashTable[i];
            if(aux == null || !aux.status){
                hashTable[i] = new HashData<>(key, value);
                break;
            }
            i = this.pollFunction(key, i+1);
        }

        this.keys++;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    public void delete(KeyType key) {
        if(!this.contains(key))
            return;
        HashData<KeyType, ValueType> aux;
        int i = Math.abs(key.hashCode() % this.capacity);
        while (true) {
            aux = hashTable[i];
            if(aux.key.equals(key)) {
                aux.status = false;
                break;
            }
            i = this.pollFunction(key, i+1);
        }
        this.keys--;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    public ValueType search(KeyType key) {
        if(!this.contains(key)){
            System.err.println("No existe esa llave.");
            throw new BufferUnderflowException();
        }

        HashData<KeyType, ValueType> aux;
        int i = Math.abs(key.hashCode() % this.capacity);

        while (true) {
            aux = hashTable[i];
            if(key.equals(aux.key) && aux.status) break;
            i = this.pollFunction(key, i+1);
        }

        return aux.value;
    }

    public boolean contains(KeyType key){
        HashData<KeyType, ValueType> aux;
        int i = Math.abs(key.hashCode() % this.capacity);
        if(i > this.capacity)
            return false;
        int counter = 0;
        while (true) {
            aux = hashTable[i];
            if(counter++ == this.capacity || aux == null)
                return false;
            if(key.equals(aux.key) && aux.status)
                break;
            i = this.pollFunction(key, i+1);
        }
        return true;
    }

    public void makeEmpty() {
        this.capacity = 20;
        this.keys = 0;
        this.lambda = 0;
        this.hashTable = new HashData[this.capacity];
    }

    private void rehashing(int newCapacity) {
        if(this.hashTable.length==MAX_SIZE)
            return;

        HashData[] hashTable;

        if(newCapacity>=MAX_SIZE)
            hashTable = new HashData[MAX_SIZE];
        else
            hashTable = new HashData[newCapacity];

        if(this.capacity >= 0)
            System.arraycopy(this.hashTable, 0, hashTable, 0, this.capacity);
        this.hashTable = hashTable;
        this.capacity = hashTable.length;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    private int pollFunction(KeyType key, int i) {
        return Math.abs((key.hashCode()) + i^2) % this.capacity;
    }
    
    public LinkedList<String> toTxt() {
        LinkedList<String> toReturn = new LinkedList();
        for (int i = 0; i < this.capacity; i++) {
            if(hashTable[i] != null && hashTable[i].status) {
                //System.out.println("-------------aaaaaaaaaaa--------------");
                String cadena = hashTable[i].toString();
                //System.out.println(cadena);
                toReturn.insertEnd(cadena);
            }
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "[";

        for (int i = 0; i < this.capacity; i++) {
            if(hashTable[i] != null && hashTable[i].status) {
                if(i != 0)
                    toReturn += ", ";
                toReturn += hashTable[i].toString();
            }
        }
        return toReturn + "]";
    }

    private static class HashData<KeyType, ValueType> {
        KeyType key;
        ValueType value;
        boolean status;

        HashData(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
            this.status = true;
        }
        
        @Override
        public String toString() {
            if(status)
                return key.toString() + "=" + value.toString();
            else
                return null;
        }
    }
}
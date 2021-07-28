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
    private float lambda;
    private int capacity;
    private int keys;

    public HashTable() {
        this.makeEmpty();
    }

    public void insert(KeyType key, ValueType value) {
        int hashCode = key.hashCode();

        if(hashCode > this.capacity)
            this.rehashing(hashCode + 1);
        if(lambda > 0.5)
            this.rehashing(2 * this.capacity);

        this.insert(new HashData<>(key, value), hashCode);
        this.keys++;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    private void insert(HashData<KeyType, ValueType> hashData, int i) {
        if(hashTable[i] != null && hashTable[i].status)
            this.insert(hashData, this.pollFunction(hashData.key, i));
        else
            hashTable[i] = hashData;
    }

    public void delete(KeyType key) {
        this.search(key);
        this.delete(key, key.hashCode());
        this.keys--;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    private void delete(KeyType key, int i) {
        if(hashTable[i].key.equals(key))
            hashTable[i].status = false;
        else
            this.delete(key, pollFunction(key, i));
    }

    public ValueType search(KeyType key) {
        HashData<KeyType, ValueType> aux;
        int i = key.hashCode();
        int counter = 0;
        while (true) {
            aux = hashTable[i];
            if(!aux.status || aux == null || counter++ == this.capacity)
                throw new BufferUnderflowException();
            if(key.equals(aux.key)) break;
            i = this.pollFunction(key, i);
        }
        return aux.value;
    }

    public void makeEmpty() {
        this.capacity = 20;
        this.keys = 0;
        this.lambda = 0;
        this.hashTable = new HashData[this.capacity];
    }

    private void rehashing(int newCapacity) {
        HashData[] hashTable = new HashData[newCapacity];
        for (int i = 0; i < this.capacity; i++)
            hashTable[i] = this.hashTable[i];
        this.hashTable = hashTable;
        this.capacity = newCapacity;
        this.lambda = ((float) this.keys) / ((float) this.capacity);
    }

    private int pollFunction(KeyType key, int i) {
        return (key.hashCode() + i * (13 - (key.hashCode() % 13))) % this.capacity;
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
                return key.toString() + ":" + value.toString();
            else
                return null;
        }
    }
}
package dataStructures;

import dataStructures.HashNode;
import model.Passenger;

public class HashTable<K, T> implements HashInterface<K, T> {
    private static final int NORM_CAPACITY = 40;

    private HashNode<K, T>[] list;
    private int limit;
    private int size;

    public HashTable() {
        this(NORM_CAPACITY);
    }

    public HashTable(int limit) {
        this.limit = limit;
        this.size = 0;

        list = new HashNode[limit];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int hashCode(K key) {
        String keyString = key.toString();
        int kLenght = toString().length() - 1;
        int hash = 0;
        for (int i = 0; i < keyString.length(); i++) {
            hash += keyString.charAt(i) * Math.pow(128, kLenght);
            kLenght--;
        }

        hash = (int) Math.floor(limit * ((hash * 0.75) % 1));

        return hash;
    }

    public void chainedHashInsert(K key, T value) {
        int i = hashCode(key);

        HashNode<K, T> nodeTemp = new HashNode<>(key, value);

        if (list[i] != null) {
            nodeTemp.setNext(list[i]);
            list[i].setPrev(nodeTemp);
        }
        list[i] = nodeTemp;
        size++;
    }

    public HashNode chainedHashSearch(K key) {
        int i = hashCode(key);
        return chainedHashSearch(key, list[i]);
    }

    private HashNode chainedHashSearch(K key, HashNode<K, T> current) {
        String msg = "The key is not in the data base";
        if (current == null) {
            System.out.println(msg);
            return null;
        }
        if (current.getKey().equals(key)) {
            return current;
        }

        return chainedHashSearch(key, current.getNext());
    }

    public void chainedHashDelete(K key) {
        int i = hashCode(key);

        if (list[i].getKey().equals(key)) {
            list[i].getNext().setPrev(null);
            list[i] = list[i].getNext();
        } else {
            chainedHashDelete(key, list[i].getNext());
        }
    }

    private void chainedHashDelete(K key, HashNode<K, T> current) {
        if (current == null) {
            return;
        }
        if (current.getKey().equals(key)) {
            if (current.getNext() == null) {
                current.getPrev().setNext(null);
            } else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
            return;
        }
        chainedHashDelete(key, current.getNext());
    }

    public T getValue(K key) {
        int i = hashCode(key);
        return getValue(key, list[i]);
    }

    private T getValue(K key, HashNode<K, T> current) {
        if (current == null) {
            return null;
        }

        if (current.getKey().equals(key)) {
            return current.getValue();
        }

        return getValue(key, current.getNext());
    }
}

package dataStructures;

public class HashNode<K, T> {
    private K key;
    private T value;
    private HashNode<K, T> next;
    private HashNode<K, T> prev;

    public HashNode(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HashNode<K, T> getNext() {
        return next;
    }

    public void setNext(HashNode<K, T> next) {
        this.next = next;
    }

    public HashNode<K, T> getPrev() {
        return prev;
    }

    public void setPrev(HashNode<K, T> prev) {
        this.prev = prev;
    }


}
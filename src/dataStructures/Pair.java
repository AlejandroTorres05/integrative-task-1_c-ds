package dataStructures;

import com.sun.istack.internal.NotNull;

public class Pair <K, V>{

    /**
     * This class will be used to support the
     * PriorityQueue class and will contain the key and value
     * that user is saving in a position of the PriorityQueue
     * */

    private K key;
    private V value;

    public Pair(@NotNull K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * All Getters and setters of this class
     * will be used to get or modify the element
     * saved in each attribute of the class
     * */

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

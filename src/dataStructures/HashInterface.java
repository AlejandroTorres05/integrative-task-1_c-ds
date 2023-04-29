package dataStructures;

public interface HashInterface<K, T> {
    int getSize();

    boolean isEmpty();

    int hashCode(K key);

    void chainedHashInsert(K key, T value);
}

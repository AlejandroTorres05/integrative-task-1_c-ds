package dataStructures;

/**
 * This interface has the Hash behavior
 */
public interface HashInterface<K, T> {

    /**
     * This method returns an int that indicates the HashTable size
     * @Pre: There must be a HashTable instanced
     * @Post: It returns an int
     */
    int getSize();

    /**
     * This method returns a boolean that indicates if
     * a HashTable have elements or not
     * @return the boolean value true if the HashTable doesn't have
     * elements or the boolean value false if the HashTable has
     * elements
     * @Pre: There must be a HashTable instanced
     * @Post: It returns a boolean
     */
    boolean isEmpty();

    /**
     * This method create the hashcode for an object in this case
     * a passenger for add in the HashTable
     * @param key
     * @Pre: The passenger was created
     * @Post: create the hashCode Passenger
     */
    int hashCode(K key);

    /**
     * This method insert the object in this case
     * the passenger in the hashTable
     * @param key
     * @param value
     * @Pre: The passenger was created
     * @Post: insert the passenger
     */
    void chainedHashInsert(K key, T value);
}

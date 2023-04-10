package dataStructures;

/**
 * This interface has the heap behavior
 * */

public interface HeapInterface <K extends Comparable<K>, V> {

    /**
     * This method organizes the Heap to its agree with heap
     * properties. For this the method compares an element
     * saved in an index position of the array with its left
     * and right sons and searches the mayor. When this method
     * find the mayor, makes it the root of the subHeap. Finally,
     * if it is necessary, maxHeapIfy method calls itself to
     * organize the new conflict in the heap.
     * @param array from Pair<K,V> class, is the array that has a
     *              conflict and the method must organize.
     * @param index from Integer class, is the index of the
     *              element that the method must organize
     * @Pre: There must be a heap in the system
     * @Post: The heap will be organized
     * */
    void maxHeapIfy(Pair<K,V>[] array, int index);

    /**
     * This method organize the correct Heap structure with a
     * Heap entered at the constructors methods
     * @param array from Pair<K,V> class is the array that this
     *              method must organize
     * @Pre: There must be a heap to organize in the system
     * @Post: The array must have the correct Heap structure
     * */
    void buildHeap(Pair<K,V>[] array);

    /**
     * This method organize the heap in ascending order
     * and can return an organized array
     * @param array from Pair<K,V> class, is the Heap that
     *              this method must become in an ordered
     *              array
     * @return array from Pair<K,V> class and this array
     *              must be a sorted array
     * @Pre: There must be a Heap with the correct Heap structure
     *              at the system
     * @Post: The entered heap now is an array ordered in
     *              ascending form and this method can return
     *              the sorted array
     * */
    Pair<K,V>[] heapSort(Pair<K,V>[] array);

    /**
     * This method returns the index of the father
     * for an index of an element entered or if the
     * index is 0 (the root), the method must throw
     * IllegalArgumentException Exception
     * @param index from integer class. This param is the
     *              index of an element in the Heap
     * @return Returns the result of the operation that
     *              indicates the index required
     * @Pre There must be a heap with elements
     * @Post Returns the required index
     * */
    int fatherOf (int index) throws IllegalArgumentException;

    /**
     * This method returns the index of the left son
     * for an index of an element entered
     * @param index from integer class. This param is the
     *              index of an element in the Heap
     * @return Returns the result of the operation that
     *              indicates the index required
     * @Pre There must be a heap with elements
     * @Post Returns the required index
     * */
    int leftSon (int index);

    /**
     * This method returns the index of the right son
     * for an index of an element entered
     * @param index from integer class. This param is the
     *              index of an element in the Heap
     * @return Returns the result of the operation that
     *              indicates the index required
     * @Pre There must be a heap with elements
     * @Post Returns the required index
     * */
    int rightSon (int index);


    Pair<K, V>[] getArray();

    /**
     * This setter creates a new Heap with a
     * new entered array
     * @param array from Pair<K,V> class is the new
     *              array that will be the Heap
     * @Post: The new Heap will be in the system
     * */
    void setArray(Pair<K, V>[] array);

    int getSize();

    int getHeapSize();

    /**
     * This setter will trie to change the heap
     * size. If the new Heap size is mayor than size
     * the method must throw IllegalArgumentException
     * exception, else will change the heap size and
     * will rebuild the Heap to conserve the correct
     * Heap structure
     * @param heapSize from Integer class may be the
     *                 new heap size
     * @Pre: There must be a Heap in the system
     * @Post: If the new heap size is minor than size,
     *                  the heap size will be updated
     *                  and the Heap will be rebuilt
     * */
    void setHeapSize(int heapSize) throws IllegalArgumentException;

}

package dataStructures;

import Exceptions.*;

/**
 * This class is a priority queue that uses
 * the Heap and PriorityQueue behavior. For that
 * this class implements  HeapInterface and
 * PriorityQueueInterface interfaces
 * Hear there are methods to manipulate the heapSize,
 * assure Heap and PriorityQueue structure. Also,
 * there are methods to get all elements to the
 * priorityQueue and get a sorted array using the
 * elements in the priorityQueue
 * @author Alejandro Torres
 * @author Alejandro Amu
 * @see HeapInterface
 * @see PriorityQueueInterface
 * @see Pair
 * @since 18.0
 * */
public class PriorityQueue<K extends Comparable<K>, V>
        implements HeapInterface<K, V>, PriorityQueueInterface<K,V>
{

    private Pair<K, V>[] array;
    private int size;
    private int heapSize;

    /**
     * This constructor makes a void heap
     * */
    public PriorityQueue(int size) {
        this.size = size;
        this.heapSize = -1;
        this.array = (Pair<K, V>[]) new Object[size];
    }

    /**
     * This constructor makes a heap with values at the array entered.
     * If the length of the array joined and size specified aren't
     * equals, this method must throw IllegalArgumentException
     * */
    public PriorityQueue(Pair<K, V>[] array, int size, int heapSize) throws IllegalArgumentException{
        this.array = array;
        this.size = size;
        if (array.length != size){
            throw new IllegalArgumentException(
                    "The size specified and length of the array joined aren't equals"
            );
        } else {
            this.heapSize = heapSize-1;
            buildHeap(this.array);
        }
    }

    /**
     * This constructor makes the Heap only with an entered array
     * */
    public PriorityQueue(Pair<K, V>[] array){
        this.array = array;
        this.size = array.length;
        this.heapSize = array.length-1;
        buildHeap(this.array);
    }

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
    @Override
    public void maxHeapIfy(Pair<K, V>[] array, int index) {

        int l = leftSon(index);
        int r = rightSon(index);
        int largest;

        if (l <= this.heapSize && array[l].getKey().compareTo(array[index].getKey()) > 0){
            largest = l;
        } else {
            largest = index;
        }

        if (r <= heapSize && array[r].getKey().compareTo(array[largest].getKey()) > 0) {
            largest = r;
        }

        if (largest != index){
            Pair<K,V> n = array[index];
            this.array[index] = array[largest];
            this.array[largest] = n;
            maxHeapIfy(array, largest);
        }
    }

    /**
     * This method organize the correct Heap structure with a
     * Heap entered at the constructors methods
     * @param array from Pair<K,V> class is the array that this
     *              method must organize
     * @Pre: There must be a heap to organize in the system
     * @Post: The array must have the correct Heap structure
     * */
    @Override
    public void buildHeap(Pair<K, V>[] array) {
        for (int i = this.heapSize/2; i >= 0; i--){
            maxHeapIfy(array, i);
        }
    }

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
    @Override
    public Pair<K,V>[] heapSort(Pair<K, V>[] array) {
        buildHeap(this.array);
        for (int i = this.heapSize; i >= 0; i--){
            Pair<K,V> pair = array[0];
            array[0] = array[i];
            array[i] = pair;
            maxHeapIfy(array, 0);
        }
        this.heapSize = -1;
        return array;
    }

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
    @Override
    public int fatherOf(int index) throws IllegalArgumentException{

        if (index == 0){
            throw new IllegalArgumentException(
                    "The entered argument is the root and it doesn't have father"
            );
        }
        index++;
        return (index/2) - 1;
    }

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
    @Override
    public int leftSon(int index) {
        index++;
        return (index*2) - 1;
    }

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
    @Override
    public int rightSon(int index) {
        index++;
        return (index*2);
    }

    public Pair<K, V>[] getArray() {
        return array;
    }

    /**
     * This setter creates a new Heap with a
     * new entered array
     * @param array from Pair<K,V> class is the new
     *              array that will be the Heap
     * @Post: The new Heap will be in the system
     * */
    public void setArray(Pair<K, V>[] array) {
        this.array = array;
        this.size = array.length;
        this.heapSize = this.size-1;
        buildHeap(this.array);
    }

    public int getSize() {
        return size;
    }

    public int getHeapSize() {
        return heapSize;
    }
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
    public void setHeapSize(int heapSize) throws IllegalArgumentException{
        if (heapSize > this.size){
            throw new IllegalArgumentException(
                    "The new HeapSize cannot be mayor than the size"
            );
        } else {
            this.heapSize = heapSize;
            buildHeap(this.array);
        }
    }

    /**
     * This method could insert a new element in the priority
     * queue. If the priority queue is at capacity, the method
     * must throw QueueIsAtCapacityException exception.
     * @param element a Pair is the new element that may be
     *                added to the priority queue
     * @return a boolean which indicates that the element was
     *                 added
     * @Pre: There must be a priority queue initialized in the
     *                  system
     * @Post: The element will be added to the priority queue or
     *                  the system will throw  QueueIsAtCapacityException
     *                  exception
     * */
    @Override
    public boolean insert(Pair<K, V> element) {
        this.heapSize++;
        if (this.size == this.heapSize){
            heapSize--;
            throw new QueueIsAtCapacityException(
                    "Cannot insert elements because the Priority queue is at capacity"
            );
        }else {
            this.heapSize++;
            this.array[this.heapSize] = element;
            increaseKey(this.heapSize, element.getKey());
            return true;
        }
    }

    /**
     * This method could return the mayor element saved
     * in the priority queue. If the priority queue is empty,
     * this method must throw EmptyQueueException exception
     * @return a Pair that must be the element with the
     *              mayor key
     * @Pre: There must be a priority queue initialized in
     *              the system
     * @Post: Returns the maximum element or throws
     *              EmptyQueueException exception
     * */
    @Override
    public Pair<K, V> maximum() throws EmptyQueueException{
        if (this.heapSize < 0){
            throw new EmptyQueueException(
                    "cannot show any element because at this moment the priority queue is empty"
            );
        } else {
            return this.array[0];
        }
    }

    /**
     * This method could return and extract the mayor element saved
     * in the priority queue. If the priority queue is empty,
     * this method must throw EmptyQueueException exception
     * @return a Pair that must be the element with the
     *              mayor key
     * @Pre: There must be a priority queue initialized in
     *              the system
     * @Post: Extracts the maximum element and rebuilt the Heap
     *              structure or throws EmptyQueueException exception
     * */
    @Override
    public Pair<K, V> extractMaximum() throws EmptyQueueException{
        if (this.heapSize < 0){
            throw new EmptyQueueException(
                    "cannot extract any element because at this moment the priority queue is empty"
            );
        } else {
            Pair<K,V> pair = this.array[0];
            this.array[0] = this.array[this.heapSize];
            this.heapSize--;
            maxHeapIfy(this.array, 0);
            return pair;
        }
    }

    /**
     * This method could increase the key of an element
     * saved in an entered position. If the new key is
     * smaller than actual key, the method must throw
     * IllegalArgumentException
     * @param index an integer that represents the position
     *              of the element that the method may
     *              increase its key
     * @param newKey an K element is the new key that the
     *               element may have
     * @Pre: There must be a heap with elements
     * @Post: The key of an element will be changed or the
     *              method will throw IllegalArgumentException
     *              exception
     * */
    @Override
    public void increaseKey(int index, K newKey) throws IllegalArgumentException{
        if (newKey.compareTo(this.array[index].getKey()) < 0){
            throw new IllegalArgumentException(
                    "The new key cannot be smaller than actual key"
            );
        }
        this.array[index].setKey(newKey);
        while (index > 0 &&
                this.array[fatherOf(index)].getKey().compareTo(this.array[index].getKey()) < 0)
        {
            Pair<K,V> pair = this.array[fatherOf(index)];
            this.array[fatherOf(index)] = this.array[index];
            this.array[index] = pair;
            index = fatherOf(index);
        }
    }
}

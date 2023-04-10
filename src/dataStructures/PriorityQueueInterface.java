package dataStructures;

import Exceptions.EmptyQueueException;

/**
 * This interface has the Priority queue behavior
 * */
public interface PriorityQueueInterface <K extends Comparable<K>, V> {

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
    boolean insert (Pair<K,V> element);

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
    Pair<K,V> maximum () throws EmptyQueueException;

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
    Pair<K,V> extractMaximum () throws EmptyQueueException;

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
    void increaseKey (int index, K newKey) throws IllegalArgumentException;
}

package dataStructures;

/**
 * This Interface has the Queue behavior
 * */

public interface QueueInterface<E>{

    /**
     * This method add an element to the Queue.
     * The new element will be saved at the end
     * @param item an E element is the new object
     *             that will be saved in the structure
     * @Pre: There must be a queue initialized
     * @Post: The queue will have the new element
     * */
    void enQueue (E item);

    /**
     * This method indicates if the Queue has
     * elements saved or not
     * @return a boolean that indicates the required
     *              information
     * */
    boolean isEmpty ();

    /**
     * This method just returns the element
     * that is in the front of the Queue. But,
     * this method doesn't change the structure
     * and doesn't dequeue nothing. If there is not
     * any element in the Queue, this method throws
     * EmptyQueueException exception.
     * @return an E element that is in the front
     * of the structure.
     * @Pre: There must be a Queue initialized
     * */
    E front ();

    /**
     * This method dequeues and returns the element
     * that is in the front. If there is not
     * any element in the Queue, this method throws
     * EmptyQueueException exception.
     * @return an E element that is in the front
     * of the structure.
     * @Pre: There must be a Queue initialized
     * @Post: If there were elements in the Queue,
     *              the element that was in the front
     *              will be dequeued and returned. Else
     *              the method throws the exception
     * */
    E deQueue ();
}

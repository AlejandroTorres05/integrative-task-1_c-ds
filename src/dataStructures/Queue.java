package dataStructures;

import Exceptions.EmptyQueueException;

/**
 * This class is the Queue that follows the Queue
 * behavior. For that, this class implements
 * QueueInterface
 * @author Alejandro Amu
 * @author ALejandro Torres
 * @see QueueInterface
 * @since 18.0
 * */
public class Queue <E> implements QueueInterface<E> {

    private Node<E> front;
    private Node<E> last;

    /**
     * This constructor makes an empty Queue
     * @Post: An empty Queue will be initialized
     * */
    public Queue (){
        this.front = null;
        this.last = null;
    }

    /**
     * This constructor makes a queue from an
     * array with initial elements that the user is saving
     * in the queue
     * @param elements an E array that contains all
     *                 elements that the queue will have
     *                 initially
     * @Post: The queue will be created and will contain
     *                  the entered elements
     * */
    public Queue (E[] elements){
        for (int i = 0; i < elements.length; i++){
            enQueue(elements[i]);
        }
    }

    /**
     * This method add an element to the Queue.
     * The new element will be saved at the end
     * @param item an E element is the new object
     *             that will be saved in the structure
     * @Pre: There must be a queue initialized
     * @Post: The queue will have the new element
     * */
    @Override
    public void enQueue(E item) {
        Node<E> element = new Node<>(item);

        if ( this.front == null) {
            this.front = element;
            this.last = this.front;
            return;
        }

        this.last.setNext(element);
        element.setPrevious(this.last);
        this.last = this.last.getNext();
    }

    /**
     * This method indicates if the Queue has
     * elements saved or not
     * @return a boolean that indicates the required
     *              information
     * */
    @Override
    public boolean isEmpty() {
        if(this.front == null) return true;
        return false;
    }

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
    @Override
    public E front() {
        if (this.front == null){
            throw new EmptyQueueException(
                    "This Queue is empty. Cannot dequeue any element"
            );
        } else {
            return this.front.getData();
        }
    }

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
    @Override
    public E deQueue() {
        if (this.front == null){
            throw new EmptyQueueException(
                    "This Queue is empty. Cannot dequeue any element"
            );
        }
        E element = this.front.getData();

        if (this.front.equals(this.last)){
            this.front = null;
            this.last = null;
        } else {
            this.front = this.front.getNext();
            this.front.getPrevious().setNext(null);
            this.front.setPrevious(null);
        }
        return element;
    }
}

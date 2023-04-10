package Exceptions;

/**
 * Empty QueueException is thrown when the system
 * tries to make any operation whit elements in an empty
 * Queue
 * */
public class EmptyQueueException extends RuntimeException{

    /**
     * Constructs an EmptyQueueException object
     * */
    public EmptyQueueException(){
        super();
    }

    /**
     * Constructs an EmptyQueueException object
     * @param reason a String giving more information about
     *               an empty queue
     * */
    public EmptyQueueException(String reason){
        super(reason);
    }
}

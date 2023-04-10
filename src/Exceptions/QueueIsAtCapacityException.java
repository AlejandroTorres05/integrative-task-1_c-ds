package Exceptions;

/**
 * QueueIsAtCapacityException is thrown when the system
 * tries to add any element to a priority queue at capacity
 * */
public class QueueIsAtCapacityException extends RuntimeException{

    /**
     * Constructs a QueueIsAtCapacityException object
     * */
    public QueueIsAtCapacityException(){
        super();
    }

    /**
     * Constructs a QueueIsAtCapacityException object
     * @param reason a String giving more information about
     *               the exception
     * */
    public QueueIsAtCapacityException(String reason){
        super(reason);
    }
}

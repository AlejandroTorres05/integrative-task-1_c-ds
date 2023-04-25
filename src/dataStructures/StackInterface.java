package dataStructures;

import java.util.EmptyStackException;

/**
 * This interface has the Stack behavior
 */

public interface StackInterface <T> {

    /**
     * This method returns a boolean that indicates if
     * a Stack have elements or not
     * @return the boolean value true if the Stack doesn't have
     * elements or the boolean value false if the Stack has
     * elements
     * @Pre: There must be a Stack instanced
     * @Post: It returns a boolean
     * */
    boolean isEmpty ();

    /**
     * This method inserts a new element on the Stack,
     * it considers if there are elements or not in the Stack to avoid
     * the NullPointerException
     * @param item is the value that a user wants to save in the Stack and
     *             item will be from the class with the user instances this
     *             data structure
     * @Pre: There must be a Stack instanced on the system
     * @Post: The Stack will have one item more
     * */
    void push (T item);

    /**
     * This method gives to user the item that is on the limit
     * @return this.top, if there is a top. Else throws EmptyStackException
     * @Pre: There must be a Stack instanced in the system
     * @Post: It returns the data top or trows EmptyStackException
     * */
    T top () throws EmptyStackException;

    /**
     * This method deletes and returns the last element saved
     * in the Stack
     * @return this.top element from the class which user instanced
     * the Stack or throws EmptyStackException, if there aren't
     * elements saved
     * @Pre: There must be a Stack instanced in the system
     * @Post: It returns the data top or trows EmptyStackException
     * */
    T pop () throws EmptyStackException;
}

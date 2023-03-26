package dataStructures;

import java.util.EmptyStackException;

public interface StackInterface <T> {

    boolean isEmpty ();
    void push (T item);
    T top () throws EmptyStackException;
    T pop () throws EmptyStackException;
}

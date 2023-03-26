package dataStructures;

public class Node<E>
        implements NodeInterface<E>{

    private E data;
    private Node<E> next;
    private Node<E> previous;

    /**
     * This constructor instances a new Node without
     * references to next and previous Node.
     * @param data will be from the type entered to the new Node
     * Post: The system will create a new Node.
     * */
    public Node(E data) {
        this.data = data;
    }

    /**
     * This method returns the data object.
     * @return data from the type entered when the Node was instanced
     * Pre: There must be a Node created
     * Post: The Node return the data object
     * */
    @Override
    public E getData() {
        return this.data;
    }

    /**
     * This method returns the next linked Node.
     * @return next from Node
     * Pre: There must be a Node created with a next linked Node
     * Post: The Node return the next Node
     * */
    @Override
    public Node<E> getNext() {
        return this.next;
    }

    /**
     * This method changes the next linked Node with the
     * Node entered
     * @param newNext will be the new next linked Node
     * Pre: There must be the two Nodes instanced
     * Post: The Node will have a new next Node
     * */
    @Override
    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }

    /**
     * This method returns the previous linked Node.
     * @return next from Node
     * Pre: There must be a Node created with a previous linked Node
     * Post: The Node return the next Node
     * */
    @Override
    public Node<E> getPrevious() {
        return this.previous;
    }

    /**
     * This method changes the previous linked Node with the
     * Node entered
     * @param newPrev will be the new linked previous Node
     * Pre: There must be the two Nodes instanced
     * Post: The Node will have a new previous Node
     * */
    @Override
    public void setPrevious(Node<E> newPrev) {
        this.previous = newPrev;
    }

}

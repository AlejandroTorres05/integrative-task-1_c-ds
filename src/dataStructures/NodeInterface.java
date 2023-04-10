package dataStructures;

public interface NodeInterface <D>{

    /**
     * This method returns the data object.
     * @return data from the type entered when the Node was instanced
     * @Pre: There must be a Node created
     * @Post: The Node return the data object
     * */
    D getData ();

    /**
     * This method returns the next linked Node.
     * @return next from Node
     * @Pre: There must be a Node created with a next linked Node
     * @Post: The Node return the next Node
     * */
    Node getNext();

    /**
     * This method changes the next linked Node with the
     * Node entered
     * @param newNext will be the new next linked Node
     * @Pre: There must be the two Nodes instanced
     * @Post: The Node will have a new next Node
     * */
    void setNext(Node<D> newNext);

    /**
     * This method returns the previous linked Node.
     * @return next from Node
     * @Pre: There must be a Node created with a previous linked Node
     * @Post: The Node return the next Node
     * */
    Node getPrevious ();

    /**
     * This method changes the previous linked Node with the
     * Node entered
     * @param newPrev will be the new linked previous Node
     * @Pre: There must be the two Nodes instanced
     * @Post: The Node will have a new previous Node
     * */
    void setPrevious (Node<D> newPrev);

}

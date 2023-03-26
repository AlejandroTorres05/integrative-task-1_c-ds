package dataStructures;

public interface NodeInterface <D>{

    D getData ();
    Node getNext();
    void setNext(Node<D> newNext);
    Node getPrevious ();
    void setPrevious (Node<D> newPrev);

}

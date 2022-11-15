package queue;

/**
 * A {@link QNode} is an element of a queue that is implemented
 * using a Linked List structure to allow for unbounded size.
 */
public class QNode<T>
{
    // You can use this class or modify it however you like

    private T element;
    private QNode<T> next;
    private QNode<T> previous;

    public QNode(T elem)
    {
        element = elem;
        next = null;
        previous = null;
    }

    public T getElement()
    {
        return element;
    }

    public void setElement(T elem)
    {
        element = elem;
    }

    public QNode<T> getNext()
    {
        return next;
    }

    public void setNext(QNode<T> nextNode)
    {
        next = nextNode;
    }

    public QNode<T> getPrevious()
    {
        return previous;
    }

    public void setPrevious(QNode<T> prevNode)
    {
        previous = prevNode;
    }
}

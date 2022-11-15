package queue;

import java.util.Iterator;

/**
 * A {@link LinkedQueue} is a queue that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedQueue<T> implements QueueInterface<T>
{

    QNode<T> front;
    QNode<T> rear;
    int size;

    /**
     * {@inheritDoc}.
     */
    @Override
    public T dequeue() throws IllegalStateException {
        // TODO: Implement the dequeue method.
        //   If the list is empty you should throw an exception.
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T peek() throws IllegalStateException {
        // TODO: Implement the peek method, which should return
        //   (but not remove) the element that will dequeue next.
        //   If the list is empty you should throw an exception.
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public QueueInterface<T> enqueue(T elem) {
        // TODO: Implement the enqueue method.
        //   If the list is empty or you try to enqueue a null,
        //   you should throw an exception.
        return null;
    }

    /**
     * Returns the rear most element of this queue.
     *
     * @return the rear most element of this queue.
     * @throws {@link IllegalStateException} if the queue is empty
     */
    public T peekLast() throws IllegalStateException {
        // TODO: Implement the peekLast method, which should return
        //   (but not remove) the element that was last to enqueue.
        //   If the list is empty you should throw an exception.
        // NOTE: this method is not part of the grocery simulation
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString()
    {
        // TODO: Implement the toString method.
        return null;
    }

    /**
     * Clear the queue of nodes and set size to zero.
     // NOTE: this method is not part of the grocery simulation
     */
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator()
    {
        // TODO: Implement the iterator method, which returns
        //  an iterator over elements of type T.
        // NOTE: this method is not part of the grocery simulation
        // The skeleton here uses an anonymous inner class,
        //  but you can write your own iterator class if you like.

        return new Iterator<>()
        {
            QNode<T> current = front;

            @Override
            public boolean hasNext()
            {
                // TODO: what goes here?
                return false;
            }

            @Override
            public T next()
            {
                // TODO: your code here...don't go OOB!
                return null;
            }
        };
    }
}

package structures.linear.queue.genericQueue;

/**
 * Interface for Queue (FIFO)
 *
 * @author Rackumi
 */
public interface QueueGeneric<E> {

    /**
     * Checks the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Checks if the queue is empty
     *
     * @return True if the queue is empty and false othersise
     */
    boolean isEmpty();

    /**
     * Adds and element at the front of the queue
     *
     * @param element is the element to be inserted
     */
    void enqueue(E element);

    /**
     * Removes the element at the rear of the queue
     *
     * @return the removed element
     */
    E dequeue() throws RuntimeException;

    /**
     * Checks the element at the front of the queue
     *
     * @return the element at the front of the queue
     */
    E front() throws RuntimeException;

}
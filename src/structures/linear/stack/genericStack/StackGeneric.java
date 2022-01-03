package structures.linear.stack.genericStack;

/**
 * Interface for Stack (LIFO)
 *
 * @author Rackumi
 */
public interface StackGeneric<E> {

    /**
     * Checks the number of elements in the stack
     *
     * @return the number of elements of the stack
     */
    int size();

    /**
     * Checks if the stack is empty
     *
     * @return True if the list is empty and false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element at the top of the stack
     *
     * @param element is the element to be inserted
     */
    void push(E element);

    /**
     * Removes the element at the top of the stack
     *
     * @return the removed element
     */
    E pop() throws RuntimeException;

    /**
     * Checks the element at the top of the stack
     *
     * @return the element at the top of the stack
     */
    E top() throws RuntimeException;

}

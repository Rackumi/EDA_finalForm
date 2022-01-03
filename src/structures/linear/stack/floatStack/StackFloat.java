package structures.linear.stack.floatStack;

/**
 * Interface for Stack (LIFO)
 *
 * @author Rackumi
 */
public interface StackFloat {

    /**
     * Checks the number of elements in the stack
     *
     * @return the number of elements of the stack
     */
    int size();

    /**
     * Checks if the stack is empty
     *
     * @return True if the stack is empty and false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element at the top of the stack
     *
     * @param element is the element to be inserted
     */
    void push(Float element);

    /**
     * Removes the element at the top of the stack
     *
     * @return the removed element
     */
    Float pop() throws RuntimeException;

    /**
     * Checks the element at the top of the stack
     *
     * @return the element at the top of the stack
     */
    Float top() throws RuntimeException;

}

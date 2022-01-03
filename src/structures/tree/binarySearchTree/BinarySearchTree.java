package structures.tree.binarySearchTree;

import structures.Position;

/**
 *
 * @author Rackumi
 */
public interface BinarySearchTree<E> extends Iterable<Position<E>> {

    /**
     * Returns an entry containing the given key. Returns null if no such entry
     * exists.
     * @param value
     * @return 
     */
    Position<E> find(E value);

    /**
     * Returns an iterable collection of all the entries containing the given
     * key.
     * @param value
     * @return 
     */
    Iterable<? extends Position<E>> findAll(E value);

    /**
     * Inserts an entry into the tree and returns the newly created entry.
     * @param value
     * @return 
     */
    Position<E> insert(E value);

    /**
     * Returns whether the tree is empty.
     * @return 
     */
    boolean isEmpty();


    /**
     * Removes a position.
     * @param pos the position to be removed.
     */
    void remove(Position<E> pos) throws IllegalStateException;

    /**
     * Removes a position.
     * @param pos the position to be removed.
     * @return the removed element
     */
    int removeReturn(Position<E> pos) throws IllegalStateException;

    /**
     * Returns the number of entries in the tree.
     * @return 
     */
    int size();

    /**
     *
     * @param m minimun value
     * @param M maximun value
     * @return an iterator from m to M (both included)
     */
    Iterable<? extends Position<E>> rangeIterator(E m, E M);

    //extras

    Position<E> successor(Position<E> pos);

    Position<E> predecessor(Position<E> pos);

    Iterable<Position<E>> successors(Position<E> pos);

    Iterable<Position<E>> predecessors(Position<E> pos);

    Position<E> first();

    Position<E> last();

    Iterable<Position<E>> findRange(E minValue, E maxValue) throws RuntimeException;

}
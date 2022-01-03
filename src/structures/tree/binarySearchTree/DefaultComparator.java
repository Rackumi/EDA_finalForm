package structures.tree.binarySearchTree;

import java.util.Comparator;

/**
 * Comparator based on the natural ordering
 *
 * @author Rackumi
 */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compares two given elements
     *
     * @param a
     * @param b
     * @return a negative integer if <tt>a</tt> is less than <tt>b</tt>, zero if
     * <tt>a</tt> equals <tt>b</tt>, or a positive integer if
     * <tt>a</tt> is greater than <tt>b</tt>
     * -1 si a < b
     * 0 si a == b
     * 1  si a > b
     */
    @Override
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }

}
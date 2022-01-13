package examenes.extra1.source.tree;

import structures.Position;
import structures.tree.iterators.BFSIterator;

import java.util.Iterator;

/**
 *
 * @author Rackumi
 */
public class DescendingWeight <E> {
    /**
     * Minimun weight for the sum from node to some leaf.
     *
     * @param tree
     * @param node
     * @return
     */
    public int calculate(WeightedLinkedTree<E> tree, Position<E> node) {
        Iterator<Position<E>> it = new BFSIterator<>(tree, node);
        int min = Integer.MAX_VALUE;
        while(it.hasNext()){
            Position<E> pos = it.next();
            if(tree.isLeaf(pos)){
                int aux = tree.getWeight(node, pos);
                if(min > aux){
                    min = aux;
                }
            }
        }
        return min;
    }

}
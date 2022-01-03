package examenes.extra1.solution.tree;

import structures.Position;

/**
 *
 * @author Rackumi
 */
public class AscendingWeight <E> {

    /**
     * Weight for the sum from node to root.
     *
     * @param tree
     * @param node
     * @return
     */
    public int calculate(WeightedLinkedTree<E> tree, Position<E> node) {
        int acu=0;
        while (!tree.isRoot(node)) {
            acu = acu + tree.getWeight(tree.parent(node), node);
            node = tree.parent(node);
        }
        return acu;
    }
    
    public int calculateRec(WeightedLinkedTree<E> tree, Position<E> node) {
        if (tree.isRoot(node)) {
            return 0;
        }else {
            Position<E> p = tree.parent (node);
            return tree.getWeight(p, node) + calculateRec (tree,p);
        }
    }

}
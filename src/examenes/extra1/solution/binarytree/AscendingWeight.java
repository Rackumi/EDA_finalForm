package examenes.extra1.solution.binarytree;

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
    public int calculate(WeightedLinkedBinaryTree<E> tree, Position<E> node) {
        int acu = 0;
        while (!tree.isRoot(node)) {
        	acu = acu + tree.getWeight(tree.parent(node), node);
        	node = tree.parent(node);
        }
        return acu;
    }

}
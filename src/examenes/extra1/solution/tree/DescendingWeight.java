package examenes.extra1.solution.tree;

import structures.Position;

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
        int pesoMinimo = Integer.MAX_VALUE;
        if (tree.isLeaf(node)) {
            return 0;
        }else {
            for (Position<E> hijo: tree.children(node)) {
                int aux = tree.getWeight(node, hijo)+calculate (tree,hijo);
                if (aux < pesoMinimo) {
                    pesoMinimo = aux;
                }
            }
            return pesoMinimo;
        }
    }

}
package examenes.extra1.solution.binarytree;

import structures.Position;

/**
 *
 * @author Rackumi
 */

public class DescendingWeight <E>{
    
    /**
     * Minimun weight for the sum from node to some leaf.
     * @param tree
     * @param node
     * @return 
     */
    public int calculate(WeightedLinkedBinaryTree <E> tree, Position <E> node) {
        if (tree.isLeaf(node)) {
        	return 0;
        }else {
        	int peso_mio_izq=0, peso_mio_der=0;
        	int peso_izq=0, peso_der=0;
        	if (tree.hasLeft(node)) {
        		Position <E> izq = tree.left(node);
        		peso_izq = calculate (tree,izq);
        		peso_mio_izq = tree.getWeight(node, izq);
        	}
        	
        	if (tree.hasRight(node)) {
        		Position <E> der = tree.right(node);
        		peso_der = calculate (tree,der);
        		peso_mio_der = tree.getWeight(node, der);
        	}
        	
        	if ((peso_izq+peso_mio_izq<peso_der+peso_mio_der) && (tree.hasLeft(node))) {
        		return peso_izq+peso_mio_izq;
        	}else if (tree.hasRight(node)){
        		return peso_der+peso_mio_der;
        	}else {
        		return peso_izq+peso_mio_izq;
        	}
        	
        }
    }

}
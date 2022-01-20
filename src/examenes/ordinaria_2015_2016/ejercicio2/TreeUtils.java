package examenes.ordinaria_2015_2016.ejercicio2;

import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.BinaryTreeUtils;

/**
 *
 * @author Rackumi
 */
public class TreeUtils<E> {

    BinaryTreeUtils binaryTreeUtils = new BinaryTreeUtils(); //ya estan implementados en el binaryTreeUtils

    public boolean isOdd(BinaryTree <E> t) {
        return binaryTreeUtils.isOdd(t);
    }

    public boolean isPerfect(BinaryTree <E> t) {
    	return binaryTreeUtils.isPerfect(t);
    }

}
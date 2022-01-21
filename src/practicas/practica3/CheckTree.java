package practicas.practica3;

import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.BinaryTreeUtils;

/**
 * @author Rackumi
 */

public class CheckTree<E extends Comparable> { //en structure dentro de binaryTreeUtils

    BinaryTreeUtils<E> binaryTreeUtils = new BinaryTreeUtils<>();

    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * iterative
     * @param tree
     * @return
    */
    public boolean isBinarySearchTree(BinaryTree<E> tree){
        return binaryTreeUtils.isBinarySearchTree(tree);
    }


    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * recursive
     * @param tree
     * @return
     */
    public boolean isBinarySearchTreeRec(BinaryTree<E> tree){
        return binaryTreeUtils.isBinarySearchTreeRec(tree);
    }

}
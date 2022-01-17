package practicas.practica3;

import structures.Position;
import structures.tree.binarySearchTree.DefaultComparator;
import structures.tree.binarytree.BinaryTree;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Rackumi
 */

public class CheckTree<E extends Comparable> {
   
    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * iterative
     * @param tree     
     * @return      
    */
    public boolean isBinarySearchTree(BinaryTree<E> tree){
        boolean isBS = true;
        Comparator<E> comparator = new DefaultComparator<>();

        Iterator<Position<E>> it = tree.iterator();
        while(it.hasNext()){
            Position<E> node = it.next();
            int comp = comparator.compare(tree.left(node).getElement(), node.getElement());
            if(tree.hasLeft(node)){
                if(comp > 0){
                    isBS = false;
                }
            }
            if(tree.hasRight(node)){
                if(comp < 0){
                    isBS = false;
                }
            }
        }
        return isBS;
    }


    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * recursive
     * @param tree
     * @return
     */
    public boolean isBinarySearchTreeRec(BinaryTree<E> tree){
        return isBinarySearchTreeRecAux(tree, tree.root(), true);
    }

    public boolean isBinarySearchTreeRecAux(BinaryTree<E> tree, Position<E> node, boolean cond){
        Comparator<E> comparator = new DefaultComparator<>();
        int comp = comparator.compare(tree.left(node).getElement(), node.getElement());
        if(tree.hasLeft(node)){
            if(comp < 0){
                return isBinarySearchTreeRecAux(tree, tree.left(node), cond);
            }
            else{
                return false;
            }
        }
        if(tree.hasRight(node)){
            if(comp > 0){
                return isBinarySearchTreeRecAux(tree, tree.right(node), cond);
            }
            else{
                return false;
            }
        }
        return cond;
    }

}
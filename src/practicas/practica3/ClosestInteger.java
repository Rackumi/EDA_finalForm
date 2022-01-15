package practicas.practica3;

import structures.Position;
import structures.tree.binarySearchTree.BinarySearchTree;
import structures.tree.binarySearchTree.DefaultComparator;
import structures.tree.binarySearchTree.LinkedBinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rackumi
 */
public class ClosestInteger {

    /**
     * Recives a BinarySearchTree and an integer i and returns the Position that contains the closest integer to i
     * @param tree
     * @param i
     * @return
     */
    public Position<Integer> closest(LinkedBinarySearchTree<Integer> tree, int i){
        if(tree.isEmpty()){
            throw new RuntimeException("The tree is null or empty");
        }
        Comparator<Integer> comparator = new DefaultComparator<>();
        Position<Integer> node = tree.binTree.root();

        while(!tree.binTree.isLeaf(node)){
            int comp = comparator.compare(i, node.getElement());
            if(comp == 0){
                return node;
            }
            if(comp < 0){
                if(!tree.binTree.hasLeft(node)){
                    return node;
                }
                node = tree.binTree.left(node);
            }
            else{
                if(!tree.binTree.hasRight(node)){
                    return node;
                }
                node = tree.binTree.right(node);
            }
        }
        return node;
    }

    /**
     * Recives a BinarySearchTree and an integer i and returns the Position that contains the closest integer to i rec
     * @param tree
     * @param i
     * @return
     */
    public Position<Integer> closestRec(LinkedBinarySearchTree<Integer> tree, int i){
        if(tree.isEmpty()){
            throw new RuntimeException("The tree is null or empty");
        }
        return closestRecAux(tree, i, tree.binTree.root());
    }

    public Position<Integer> closestRecAux(LinkedBinarySearchTree<Integer> tree, int i, Position<Integer> node){
        Comparator<Integer> comparator = new DefaultComparator<>();
        int comp = comparator.compare(i, node.getElement());

        if(!tree.binTree.isLeaf(node)) {
            if (comp == 0) {
                return node;
            }
            if (comp < 0) {
                if (!tree.binTree.hasLeft(node)) {
                    return node;
                }
                return closestRecAux(tree, i, tree.binTree.left(node));
            } else {
                if (!tree.binTree.hasRight(node)) {
                    return node;
                }
                return closestRecAux(tree, i, tree.binTree.right(node));
            }
        }
        return node;
    }

    /**
     * Recives a BinarySearchTree and an integer i and returns the Position that contains the closest integer to i
     * @param tree     
     * @param i     
     * @return      
     */
    public Position<Integer> closest2(BinarySearchTree<Integer> tree, int i){ //No usar iterator, mala solucion
        if(tree.isEmpty()){
            throw new RuntimeException("The tree is null or empty");
        }

        Iterator<Position<Integer>> it = tree.iterator();
        while(it.hasNext()) {
            Position<Integer> pos = it.next();
            Position<Integer> suc = tree.successor(pos);
            if(pos.getElement() == i || suc == null) {
                return pos;
            }
            if(pos.getElement() < i && i < suc.getElement()){
                if(Math.abs(pos.getElement()-i) < Math.abs(suc.getElement()-i)) {
                    return pos;
                }
                else{
                    return suc;
                }
            }
        }
        return null;

    }
    
}
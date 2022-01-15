package practicas.practica3;

import structures.Position;
import structures.tree.binarySearchTree.BinarySearchTree;

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
    public Position<Integer> closest (BinarySearchTree<Integer> tree, int i){
        if(tree.isEmpty()){
            throw new RuntimeException("The tree is null or empty");
        }

        Iterator<Position<Integer>> it = tree.iterator(); //TODO no usar iterador
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
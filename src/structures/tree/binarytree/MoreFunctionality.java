package structures.tree.binarytree;

import structures.Position;
import structures.tree.iterators.InOrderIterator;

import java.util.Iterator;

/**
 * @author Rackumi
 */
public class MoreFunctionality<T> {

    /**
     * Check if a BinaryTree is perfect. 
     * A BinaryTree is perfect if all its internal nodes have left chlid and right child.
     * @param t
     * @return 
     */
    public boolean isPerfect(BinaryTree<T> t){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    /**
     * Check if a BinaryTree is imperfect. 
     * A BinaryTree is imperfect if not all its internal nodes have left chlid and right child.
     * @param t
     * @return 
     */
    public boolean isImperfect(BinaryTree<T> t){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    /**
     * Check if a BinaryTree is odd. 
     * A BinaryTree is odd if more than half its nodes are left child.
     * @param t
     * @return 
     */
    public boolean isOdd(BinaryTree<T> t){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    /**
     * Check if a BinaryTree is even. 
     * A BinaryTree is even if more than half its nodes are right child.
     * @param t
     * @return 
     */
    public boolean isEven(BinaryTree<T> t){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    /**
     * Check if a BinaryTree is ambidextrous. 
     * A BinaryTree is ambidextrous if its left and right children doesn't differ in more than one.
     * @param t
     * @return 
     */
    public boolean isAmbidextrous(BinaryTree<T> t){
        int leftChildren = 0;
        int rightChildren = 0;
        if(t.isEmpty()){
            return true;
        }
        if(t.isLeaf(t.root())){
            return true;
        }
        Iterator<Position<T>> it = new InOrderIterator<>(t);
        while(it.hasNext()){
            Position<T> node = it.next();
            if (t.isLeaf(node)) {
                Position<T> parent = t.parent(node);
                if(t.hasLeft(parent)){
                    if(t.left(parent).equals(node)){
                        leftChildren++;
                    }
                }
                if(t.hasRight(parent)){
                    if(t.right(parent).equals(node)){
                        rightChildren++;
                    }
                }
            }
        }

        return !(Math.abs(leftChildren - rightChildren) > 1);
    }

}
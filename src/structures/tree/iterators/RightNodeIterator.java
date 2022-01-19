package structures.tree.iterators;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import structures.Position;
import structures.tree.binarytree.BinaryTree;

/**
 * @author Rackumi
 */
public class RightNodeIterator<T> implements Iterator<Position<T>> {

    BinaryTree<T> tree;
    Deque<Position<T>> q;

    public RightNodeIterator(BinaryTree<T> tree){
        this.tree = tree;
        q = new LinkedList<>();
        if(!tree.isEmpty()){
            q.addFirst(tree.root());
        }
    }

    //hasNext puede devolver true cuando no quedan más nodos derechos, habria que solucionarlo.
    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public Position<T> next() {
        Position<T> node = q.removeLast();
        for(Position<T> p: tree.children(node)){
            q.addFirst(p);
        }
        Position<T> parent = tree.parent(node);
        if(!tree.isRoot(node)){
            if(tree.hasRight(parent)){
                if(tree.right(parent).equals(node)){
                    return node;
                }
            }
        }
        return next();
    }

}
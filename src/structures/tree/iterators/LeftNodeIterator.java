package structures.tree.iterators;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import structures.Position;
import structures.tree.binarytree.BinaryTree;

/**
 * @author Rackumi
 */
public class LeftNodeIterator<T> implements Iterator<Position<T>> {

    BinaryTree<T> tree;
    Deque<Position<T>> q;

    public LeftNodeIterator(BinaryTree<T> tree){
        this.tree = tree;
        q = new LinkedList<>();
        if(!tree.isEmpty()){
            q.addFirst(tree.root());
        }
    }

    //hasNext puede devolver true cuando no quedan más nodos izquierdos, habria que solucionarlo.
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
            if(tree.hasLeft(parent)){
                if(tree.left(parent).equals(node)){
                    return node;
                }
            }
        }
        return next();
    }
    
}
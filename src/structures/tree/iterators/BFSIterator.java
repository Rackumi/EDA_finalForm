package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;

import java.util.*;

/**
 * BFSIterator
 *
 * @author Rackumi
 */
public class BFSIterator<E> implements Iterator<Position<E>> {

    private final Tree<E> tree;
    private final Queue<Position<E>> q = new LinkedList<>();

    public BFSIterator(Tree<E> t){
        this.tree = t;
        if(!t.isEmpty()){
            this.q.add(this.tree.root());
        }
    }

    public BFSIterator(Tree<E> t, Position<E> root){
        this.tree = t;
        if(!t.isEmpty()){
            this.q.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public Position<E> next() {

        if(q.isEmpty()){
            throw new NoSuchElementException();
        }
        Position<E> node = q.poll();
        for(Position<E> p: tree.children(node)){
            q.add(p);
        }
        return node;
    }

}
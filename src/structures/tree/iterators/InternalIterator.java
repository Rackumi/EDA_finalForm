package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InternalIterator<E>  implements Iterator<Position<E>> {

    Deque<Position<E>> q = new LinkedList<>();;
    Tree<E> tree;

    public InternalIterator(Tree<E> tree){
        this.tree = tree;
        if(!tree.isEmpty()){
            if(tree.isInternal(this.tree.root())) {
                this.q.addFirst(this.tree.root());
            }
        }
    }

    public InternalIterator(Tree<E> tree, Position<E> root){
        this.tree = tree;
        if(!tree.isEmpty()) {
            if(tree.isInternal(root)) {
                this.q.addFirst(root);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public Position<E> next() {
        Position<E> node = q.removeLast();
        for(Position<E> p: tree.children(node)){
            if(tree.isInternal(p)){
                q.addFirst(p);
            }
        }
        return node;
    }

}
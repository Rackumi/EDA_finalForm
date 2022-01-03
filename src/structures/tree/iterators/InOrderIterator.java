package structures.tree.iterators;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * InOrderIterator
 *
 * @author Rackumi
 */
public class InOrderIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;
    private final Deque<Position<E>> s = new LinkedList<>();

    public InOrderIterator(BinaryTree<E> tree) {
        this.tree = tree;
        if(!tree.isEmpty()){
            goToLastInLeft(tree.root());
        }
    }

    public InOrderIterator(BinaryTree<E> tree, Position<E> node) {
        this.tree = tree;
        if(!tree.isEmpty()){
            goToLastInLeft(node);
        }
    }

    public void goToLastInLeft(Position<E> pos){
        s.push(pos);
        while(tree.hasLeft(pos)){
            pos = tree.left(pos);
            s.push(pos);
        }
    }

    @Override
    public boolean hasNext() {
        return (!s.isEmpty());
    }

    @Override
    public Position<E> next() {
        Position<E> node = s.pop();

        if(tree.hasRight(node)){
            goToLastInLeft(tree.right(node));
        }

        return node;
    }

}
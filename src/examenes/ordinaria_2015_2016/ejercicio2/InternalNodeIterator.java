package examenes.ordinaria_2015_2016.ejercicio2;

import java.util.Iterator;

import structures.Position;
import structures.tree.Tree;
import structures.tree.iterators.InternalIterator;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {

    InternalIterator<E> internalIterator; //ya esta implementado en los iteradores

	public InternalNodeIterator(Tree<E> tree) {
		this.internalIterator = new InternalIterator<>(tree);
	}

    public InternalNodeIterator(Tree<E> tree, Position<E> root) {
        this.internalIterator = new InternalIterator<>(tree, root);
    }

    @Override
    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    /**
     * This method visits the nodes of a tree by following a breath-first
     * search
     */
    @Override
    public Position<E> next() {
        return this.internalIterator.next();
    }

}
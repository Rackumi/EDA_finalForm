package examenes.ordinaria_2015_2016.ejercicio1;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import structures.Position;
import structures.tree.Tree;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {

	
	public InternalNodeIterator(Tree<E> tree) {
		
	}

    public InternalNodeIterator(Tree<E> tree, Position<E> root) {
    	
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * This method visits the nodes of a tree by following a breath-first
     * search
     */
    @Override
    public Position<E> next() {
        return null;
    }

}
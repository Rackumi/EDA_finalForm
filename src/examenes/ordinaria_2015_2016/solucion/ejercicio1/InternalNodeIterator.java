package examenes.ordinaria_2015_2016.solucion.ejercicio1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import structures.Position;
import structures.tree.Tree;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {
    ArrayList<Position<E>> almacen;
    Tree<E> tree;
    
    public InternalNodeIterator(Tree<E> tree) {
        if (!((tree==null) || (tree.isEmpty()))) {
            this.tree = tree;
            almacen = new ArrayList <> ();

            if (tree.isInternal(tree.root())) {
                almacen.add (tree.root());
            }
        }else {
            almacen = new ArrayList <> ();
        }
        
    }

    public InternalNodeIterator(Tree<E> tree, Position<E> root) {
        this.tree = tree;
        almacen = new ArrayList <> ();
        
        if (tree.isInternal(root)) {
            almacen.add (root);
        }
       // rellenar (root);
    }
    /*
    private void rellenar (Position<E> p) {
        if (this.tree.isInternal(p)) {
            almacen.add(p);
            for (Position<E> hijo: this.tree.children(p)) {
                rellenar (hijo);
            }
        }
    }*/

    @Override
    public boolean hasNext() {
        return !almacen.isEmpty();
    }

    /**
     * This method visits the nodes of a tree by following a breath-first search
     */
    @Override
    public Position<E> next() {
        Position<E> toReturn =  almacen.remove (0);
        
        for (Position<E> hijo: this.tree.children(toReturn)) {
            if (tree.isInternal(hijo))
                almacen.add (hijo);
        }
        return toReturn;
        
    }

}
package examenes.ordinaria_2015_2016.solucion.ejercicio2;

import java.util.Iterator;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.iterators.InOrderIterator;

/**
 *
 * @author Rackumi
 */
public class TreeUtils<E> {
    private int contarNodosRec (BinaryTree <E> t, Position<E> p) {
        int cont=1;
        for (Position<E> hijo: t.children(p)) {
            cont = cont + contarNodosRec (t,hijo);
        }
        return cont;
    }

    private int contarNodos (BinaryTree <E> t, Position<E> p) {
        Iterator it = new InOrderIterator(t,p);
        int cont = 0;
        while (it.hasNext()) {
            cont++;
            it.next();
        }
        return cont;
    }

    public boolean isOdd(BinaryTree <E> t) {
        if ((t.isEmpty()) || (t.isLeaf(t.root()))) {
            return true;
        }
        int contNodosEnIzquierda = 0;
        if (t.hasLeft(t.root())) {
            contNodosEnIzquierda = contarNodos (t, t.left(t.root()));
            if (contNodosEnIzquierda> t.size()/2) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean isPerfect(BinaryTree <E> t) {
    	if ((t==null) || (t.isEmpty())) {
            return true;
        }else {
            for (Position<E> p: t) {
                if (t.isInternal(p)) {
                    if ((!t.hasLeft(p)) || (!t.hasRight(p))) {
                        return false;
                    }
                }
                /*
                int cont=0;
                for (Position<E> hijo: t.children (p)) {
                    cont++;
                }
                if ((t.isInternal(p)) && (cont<2))
                    return false;
                */
            }
            return true;
        }
    }

}
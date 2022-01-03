package examenes.adelanto_2018_2019;

import structures.Position;
import structures.tree.iterators.BFSIterator;
import structures.tree.narytree.NAryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JustParent<E> {

    public Iterable<Position<E>> justParent(NAryTree<E> tree){ //padres no abuelos
        List<Position<E>> l = new LinkedList<>();

        Iterator<Position<E>> it = new BFSIterator<E>(tree);
        boolean cond = true;
        while(it.hasNext()){
            Position<E> node = it.next();
            if(!tree.isLeaf(node)) {
                for (Position<E> p : tree.children(node)) {
                    if (!tree.isLeaf(p)) { //si en algun momento se cumple que alguno de los hijos no sea leaf entonces ese nodo ya no nos vale
                        cond = false;
                    }
                }
                if (cond) {
                    l.add(node);
                }
            }
        }
        return l;
    }

}
package examenes.adelanto_2018_2019;

import structures.Position;
import structures.tree.narytree.NAryTree;

import java.util.*;

public class JustParent<E> {

    public Collection<Position<E>> justParent(NAryTree<E> t){
        Set<Position<E>> set = new HashSet<>();
        Iterator<Position<E>> it = t.iterator();
        while(it.hasNext()){
            Position<E> node = it.next();
            if(!t.isLeaf(node)) {
                boolean valid = true;
                for (Position<E> p : t.children(node)) {
                    if (!t.isLeaf(p)) { //si en algun momento se cumple que alguno de los hijos no sea leaf entonces ese nodo ya no nos vale
                        valid = false;
                    }
                }
                if (valid) {
                    set.add(node);
                }
            }
        }
        return set;
    }

}
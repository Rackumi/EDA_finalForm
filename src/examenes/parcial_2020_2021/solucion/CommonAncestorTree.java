package examenes.parcial_2020_2021.solucion;

import structures.Position;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import java.util.HashSet;
import java.util.Set;

public class CommonAncestorTree<E> {

    private NAryTree<E> tree;

    public CommonAncestorTree(NAryTree<E> tree) {
        this.tree = tree;
    }

    public NAryTree<E> createCommonTreeAncestor(Position<E> p1, Position<E> p2) {
        Position<E> commAnc = findCommonAncestor(p1, p2);
        NAryTree<E> res = new LinkedTree<>();
        Position<E> root = res.addRoot(commAnc.getElement());
        copyTree(res, commAnc, root);
        return res;
    }

    private void copyTree(NAryTree<E> dst, Position<E> pSrc, Position<E> pDst) {
        for (Position<E> child : tree.children(pSrc)) {
            Position<E> newPos = dst.add(child.getElement(), pDst);
            copyTree(dst, child, newPos);
        }
    }

    private Position<E> findCommonAncestor(Position<E> p1, Position<E> p2) {
        Set<Position<E>> ancestorsP1 = new HashSet<>();
        Position<E> ancP1 = p1;
        while (!tree.isRoot(ancP1)) {
            ancestorsP1.add(ancP1);
            ancP1 = tree.parent(ancP1);
        }
        ancestorsP1.add(ancP1); // Cuando llegamos a la raiz le ponemos en la lista de ancestros tambien
        Position<E> ancP2 = p2;
        boolean found = ancestorsP1.contains(ancP2);
        while (!tree.isRoot(ancP2) && !found) {
            ancP2 = tree.parent(ancP2);
            found = ancestorsP1.contains(ancP2);
        }
        return ancP2;
    }

}
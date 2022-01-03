package examenes.parcial_2020_2021.exam;

import structures.Position;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CommonAncestorTree<E> {

    private NAryTree<E> tree;

    public CommonAncestorTree(NAryTree<E> tree) {
        this.tree = tree;
    }

    public NAryTree<E> createCommonTreeAncestor(Position<E> p1, Position<E> p2) {
        Set<Position<E>> s = new HashSet<>();
        Position<E> nodeAux = p1;
        s.add(nodeAux);

        while(!tree.isRoot(nodeAux)){
            nodeAux = tree.parent(nodeAux);
            s.add(nodeAux);
        }
        s.add(nodeAux);

        Position<E> nodeAux2 = p2;
        while(!tree.isRoot(nodeAux2)){
            if(s.contains(nodeAux2)){
                return tree.subTree(nodeAux2);
            }
            nodeAux2 = tree.parent(nodeAux2);
        }

        //habria que hacer un metodo copy ya que el subTree hace un remove del arbol?
        return tree.subTree(nodeAux2);
    }

}
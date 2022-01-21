package examenes.extraordinaria_2019_2020.ejercicio1;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.iterators.InOrderIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CountBalanced<E> {

    //probablemente esta solucion sea bastante compleja ya que hacemos O(n) en el iterador de cada elemento y
    // luego otros dos O(n) para calcular el nivel de cada hijo del nodo y poder restarlos.
    //exactamente, hacemos O(n^2)
    public int countBalanced(BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return 0;
        }
        int cont = 0;
        Iterator<Position<E>> it = new InOrderIterator<>(tree);
        while(it.hasNext()){
            Position<E> node = it.next();

            int lBranch = 0;
            if(tree.hasLeft(node)){
                lBranch = lvl(tree, tree.left(node));
            }

            int rBranch = 0;
            if(tree.hasRight(node)){
                rBranch = lvl(tree, tree.right(node));
            }

            int balance = lBranch - rBranch;
            if(balance <= 1 && balance >= -1){
                cont++;
            }
        }

        return cont;
    }

    public int lvl(BinaryTree<E> t, Position<E> node){
        if(t.isEmpty()){
            return 0;
        }
        int left = 0;
        int right = 0;

        if(t.hasLeft(node)){
            left = lvl(t, t.left(node));
        }
        if(t.hasRight(node)){
            right = lvl(t, t.right(node));
        }

        return Math.max(left, right)+1;
    }

    //En esta solucion hacemos O(n) gracias a un recorrido en postorden
    public int countBalanced2(BinaryTree<E> tree) {
        if(tree.isEmpty()){
            return 0;
        }
        List<Position<E>> list = new LinkedList<>();
        countBalanced2Aux(tree, tree.root(), list);
        return list.size();
    }

    private int countBalanced2Aux(BinaryTree<E> tree, Position<E> node, List<Position<E>> l) {
        int left = 0;
        int right = 0;
        if(tree.hasLeft(node)){
            left = countBalanced2Aux(tree, tree.left(node), l);
        }
        if(tree.hasRight(node)){
            right = countBalanced2Aux(tree, tree.right(node), l);
        }
        if(!(Math.abs(left-right) > 1)){
            l.add(node);
        }
        return Math.max(left, right)+1;
    }

}
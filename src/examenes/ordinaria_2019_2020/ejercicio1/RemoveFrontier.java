package examenes.ordinaria_2019_2020.ejercicio1;

import structures.Position;
import structures.tree.iterators.BFSIterator;
import structures.tree.narytree.NAryTree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveFrontier<E> {

    public void removeFrontier(NAryTree<E> tree) {
        //Solucion 1
//        Iterator<Position<E>> it = new BFSIterator<>(tree);
//        while(it.hasNext()){
//            Position<E> node = it.next();
//            if(tree.isLeaf(node)){
//                tree.remove(node);
//            }
//        }

        //Solucion 2
//        Deque<Position<E>> q = new LinkedList<>();
//        q.addFirst(tree.root());
//
//        while(!q.isEmpty()){
//            Position<E> node = q.removeLast();
//            for(Position<E> p: tree.children(node)){
//                q.addFirst(p);
//            }
//            if(tree.isLeaf(node)){
//                tree.remove(node);
//            }
//        }

        //Solucion 3
//        Deque<Position<E>> q = new LinkedList<>();
//        LinkedList<Position<E>> leafs = new LinkedList<>();
//        q.addFirst(tree.root());
//
//        while(!q.isEmpty()){
//            Position<E> node = q.removeLast();
//            for(Position<E> p: tree.children(node)){
//                q.addFirst(p);
//            }
//            if(tree.isLeaf(node)){
//                leafs.add(node);
//            }
//        }
//
//        for(Position<E> leaf: leafs){
//            tree.remove(leaf);
//        }

        //Solucion 4
        LinkedList<Position<E>> leafs = new LinkedList<>();
        for(Position<E> p: tree){
            if(tree.isLeaf(p)){
                leafs.add(p);
            }
        }

        for(Position<E> leaf: leafs){
            tree.remove(leaf);
        }

    }

}
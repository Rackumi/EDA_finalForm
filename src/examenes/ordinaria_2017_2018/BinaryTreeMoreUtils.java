package examenes.ordinaria_2017_2018;

import practicas.practica2.Pair;
import structures.Position;
import structures.tree.binarytree.BinaryTree;

import java.util.*;

public class BinaryTreeMoreUtils<E> {

    BinaryTree<E> tree;

    BinaryTreeMoreUtils(BinaryTree<E> tree){
        this.tree = tree;
    }

    public Iterable<Integer> levelsComplete(BinaryTree<E> tree){
        Set<Integer> l1 = new HashSet<>();//niveles completos
        Set<Integer> l2 = new HashSet<>();//niveles incompletos
        Deque<Pair<Position<E>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(tree.root(), 1)); // se ha considerado que la raiz es altura 1 para que cuadre con el enunciado

        while(!q.isEmpty()){
            Pair<Position<E>, Integer> node = q.removeLast();
            for(Position<E> p: tree.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
            }
            if((tree.hasLeft(node.getFirst()) && tree.hasRight(node.getFirst())) || tree.isLeaf(node.getFirst())){
                l1.add(node.getSecond());
            }
            else{
                l2.add(node.getSecond());
            }
        }
        for(Integer p: l2){
            l1.remove(p);
        }
        return l1;
    }

    public Iterable<Integer> levelsIncomplete(BinaryTree<E> tree){
        Set<Integer> l = new HashSet<>();
        Deque<Pair<Position<E>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(tree.root(), 1)); // se ha considerado que la raiz es altura 1 para que cuadre con el enunciado

        while(!q.isEmpty()){
            Pair<Position<E>, Integer> node = q.removeLast();
            for(Position<E> p: tree.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
            }
            if(!((tree.hasLeft(node.getFirst()) && tree.hasRight(node.getFirst())) || tree.isLeaf(node.getFirst()))){
                l.add(node.getSecond());
            }
        }
        return l;
    }

}
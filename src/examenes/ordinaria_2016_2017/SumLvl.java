package examenes.ordinaria_2016_2017;

import practicas.practica2.Pair;
import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.narytree.NAryTree;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SumLvl<E> {

    public int sumLevels(NAryTree<Integer> t, int[] nums){
        int cont = 0;
        Set<Integer> set = new HashSet<>();
        for(Integer n: nums){
            set.add(n);
        }
        Deque<Pair<Position<Integer>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(t.root(), 0));

        while(!q.isEmpty()){
            Pair<Position<Integer>, Integer> node = q.removeLast();
            for(Position<Integer> p: t.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
            }
            if(set.contains(node.getSecond())){
                cont += node.getFirst().getElement();
            }
        }
        return cont;
    }

    public int sumBinaryLevels(BinaryTree<Integer> t, int[] nums){
        int cont = 0;
        Set<Integer> set = new HashSet<>();
        for(Integer n: nums){
            set.add(n);
        }
        Deque<Pair<Position<Integer>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(t.root(), 0));

        while(!q.isEmpty()){
            Pair<Position<Integer>, Integer> node = q.removeLast();
            for(Position<Integer> p: t.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
            }
            if(set.contains(node.getSecond())){
                cont += node.getFirst().getElement();
            }
        }
        return cont;
    }

}
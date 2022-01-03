package examenes.extra2.source.sumlevels;

import practicas.practica2.Pair;
import structures.Position;
import structures.tree.binarytree.BinaryTree;

import java.util.*;

public class SumLevels {
	
	private BinaryTree<Integer> tree;
	
	public SumLevels(BinaryTree<Integer> tree) {
            this.tree = tree;
	}

    public int sumLevels(int[] levels){
        int cont = 0;
        Pair<Position<Integer>, Integer> node = new Pair<>(tree.root(), 0);
        Deque<Pair<Position<Integer>, Integer>> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(Integer p: levels){
            set.add(p);
        }

        q.addFirst(node);
        while(!q.isEmpty()){
            node = q.removeLast();
            for(Position<Integer> p: tree.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
            }
            if(set.contains(node.getSecond())){
                cont = cont + node.getFirst().getElement();
            }
        }

        return cont;
    }

}
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
        Deque<Pair<Position<Integer>, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair(this.tree.root(), 0));
        Set<Integer> set = new HashSet<>();
        for(Integer p: levels){
            set.add(p);
        }
        int cont = 0;
        while(!q.isEmpty()){
            Pair<Position<Integer>, Integer> pos = q.removeLast();
            for(Position<Integer> p: this.tree.children(pos.getFirst())){
                q.addFirst(new Pair(p, pos.getSecond()+1));
            }
            if(set.contains(pos.getSecond())){
                cont += pos.getFirst().getElement();
            }
        }

        return cont;
    }

}
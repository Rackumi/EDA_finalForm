package examenes.extra2.solucion.sumlevels;

import java.util.*;

import practicas.practica2.Pair;
import structures.Position;
import structures.tree.binarytree.BinaryTree;

public class SumLevels {
	
	private BinaryTree<Integer> tree;
	
	public SumLevels(BinaryTree<Integer> tree) {
            this.tree = tree;
	}
	
    private int dameNivel (BinaryTree<Integer> tree, Position<Integer> p) {
        int n=0;
        while (!tree.isRoot(p)) {
            n++;
            p=tree.parent (p);
        }
        return n;
    }

	public int sumLevels(int[] levels) {
        ArrayList<Integer> levelsPro = new ArrayList<> ();
        for (int i=0; i<levels.length; i++) {
            levelsPro.add (levels[i]);
        }

        int acu = 0;
        for (Position<Integer> p: tree) {
            int nivel = dameNivel (tree, p);
            if (levelsPro.contains(nivel)) {
                acu = acu + p.getElement();
            }
        }
        return acu;
	}
	
    private int sumLevelsRec(BinaryTree<Integer> tree, Position<Integer> nodo, ArrayList<Integer> levelsPro, int nivelActual) {
        int acu = 0;
        if (levelsPro.contains(nivelActual)) {
            acu = acu + nodo.getElement();
        }
        
        for (Position<Integer> hijo: tree.children(nodo)) {
            acu = acu + sumLevelsRec (tree,hijo, levelsPro, nivelActual+1);
        }
        return acu;
    }    
        
    public int sumLevelsRec(int[] levels) {
        ArrayList<Integer> levelsPro = new ArrayList<> ();
        for (int i=0; i<levels.length; i++) {
            levelsPro.add (levels[i]);
        }

        int n = 0;

        n= sumLevelsRec (tree, tree.root (), levelsPro, 0);

        return n;
	}

    public int sumLevels2(int[] levels){
        int cont = 0;
        Pair<Position<Integer>, Integer> node = new Pair<>(tree.root(), 0);
        Deque<Pair<Position<Integer>, Integer>> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(Integer p: levels){
            set.add(p);
        }

        q.addFirst(node);
        if(set.contains(node.getSecond())){
            cont = node.getFirst().getElement();
        }
        while(!q.isEmpty()){
            node = q.removeLast();
            for(Position<Integer> p: tree.children(node.getFirst())){
                q.addFirst(new Pair(p,node.getSecond()+1));
                if(set.contains(node.getSecond()+1)){
                    cont = cont + p.getElement();
                }

            }
        }

        return cont;
    }

}
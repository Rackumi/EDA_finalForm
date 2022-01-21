package structures.tree.binarytree;

import practicas.practica2.Pair;
import structures.Position;
import structures.tree.binarySearchTree.DefaultComparator;
import structures.tree.iterators.InOrderIterator;
import structures.tree.iterators.PreOrderIterator;

import java.util.*;

public class BinaryTreeUtils<E> {
	
	private BinaryTree<E> tree;

	public BinaryTreeUtils(){

	}

	public BinaryTreeUtils(BinaryTree<E> tree) {
		this.tree = tree;
	}

	/**
	* Given a tree the method returns a new tree where all left children
	* become right children and vice versa
	*/
	public BinaryTree<E> mirror() {
		Position<E> node = this.tree.root();
		BinaryTree<E> t = new LinkedBinaryTree<>();
		t.addRoot(node.getElement());
		if(tree.hasLeft(node)){
			t.attachRight(t.root(), this.mirror());
		}
		if(tree.hasRight(node)){
			t.attachLeft(t.root(), this.mirror());
		}
		return t;
	}

	/**
	* Determines whether the element e is in the tree or not
	*/
	public boolean contains (E e) {
		Iterator<Position<E>> it = new InOrderIterator<>(tree);
		while (it.hasNext()){
			if(it.next().getElement() == e){
				return true;
			}
		}
		return false;
	}
	
	/**
	* Determines the level of a node in the tree
	*/
	public int level(Position<E> n) {
		int left= 0;
		int right = 0;
		if(tree.hasLeft(n)){
			left = level(tree.left(n));
		}
		if(tree.hasRight(n)){
			right = level(tree.right(n));
		}
		return Math.max(left, right)+1;
	}

	/**
	 * Se dice que un arbol binario es perfecto si todos los nodos internos tienen dos hijos.
	 * Implementar un metodo is Perfect, que determine si un arbol binario es perfecto o no.
	 */
	public boolean isComplete(){ //isPerfect?
		for(Position<E> p: tree){
			//if(!((hasLeft(node) && hasRight(node)) || isLeaf(node))){
			//if((!(hasLeft(node) && hasRight(node)) && !isLeaf(node))){
			if(((!tree.hasLeft(p) || !tree.hasRight(p)) && tree.isInternal(p))){
				return false;
			}
		}
		return true;
	}

	private int calcularNodos (BinaryTree<E> t, Position<E> p) {
		int cont = 0;
		Iterator<Position<E>> it = new InOrderIterator<>(t, p);
		while(it.hasNext()){
			it.next();
			cont++;
		}
		return cont;
	}

	private int calcularNodos2 (BinaryTree<E> t, Position<E> p) {
		int cont = 1;
		if(t.hasLeft(p)){
			cont = cont + calcularNodos2(t, t.left(p));
		}
		if(t.hasRight(p)){
			cont = cont + calcularNodos2(t, t.right(p));
		}
		return cont;
	}

	/**
	 * Se dice que un arbol binario es zurdo si es vacio, es hoja o
	 * mas de la mitad de sus descendientes están en el hijo izquierdo.
	 * Implementar el metodo isOdd, que determina si un arbol binario es zurdo o no
	 */
	public boolean isOdd (BinaryTree<E> t) {
		if(t.isEmpty()){
			return true;
		}
		if(t.isLeaf(t.root())){
			return true;
		}
		int nodosIzq = 0;
		int nodosDer = 0;

		if(t.hasLeft(t.root())){
			nodosIzq = calcularNodos2(t,t.left(t.root()));
		}
		if(t.hasRight(t.root())){
			nodosDer = calcularNodos2(t,t.right(t.root()));
		}

		return nodosIzq > nodosDer;
	}

	public boolean isOdd2(BinaryTree <E> t) {
		if ((t.isEmpty()) || (t.isLeaf(t.root()))) {
			return true;
		}
		int contNodosEnIzquierda = 0;
		if (t.hasLeft(t.root())) {
			contNodosEnIzquierda = calcularNodos(t, t.left(t.root()));
			if (contNodosEnIzquierda> t.size()/2) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public int nodeLevel(Position<E> root, Position<E> n){
		if(root==n){
			return 1;
		}
		else {
			int left = 0;
			int right = 0;
			if (tree.hasLeft(root)) {
				left = nodeLevel(tree.left(root), n);
			}
			if (tree.hasRight(root)) {
				right = nodeLevel(tree.right(root), n);
			}
			return Math.max(left, right) +1;
		}
	}

	/**
	 * Check if a BinaryTree is perfect.
	 * A BinaryTree is perfect if all its internal nodes have left chlid and right child.
	 * @param t
	 * @return
	 */
	public boolean isPerfect(BinaryTree<E> t){
		Iterator<Position<E>> it = t.iterator();
		while(it.hasNext()){
			Position<E> node = it.next();
			if(!(t.isLeaf(node) || t.hasLeft(node) && t.hasRight(node))){
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if a BinaryTree is imperfect.
	 * A BinaryTree is imperfect if not all its internal nodes have left chlid and right child.
	 * @param t
	 * @return
	 */
	public boolean isImperfect(BinaryTree<E> t){
		return !isPerfect(t);
	}

	/**
	 * Check if a BinaryTree is even.
	 * A BinaryTree is even if more than half its nodes are right child.
	 * @param t
	 * @return
	 */
	public boolean isEven(BinaryTree<E> t){
		if(t.isEmpty()){
			return true;
		}
		if(t.isLeaf(t.root())){
			return true;
		}
		int nodosIzq = 0;
		int nodosDer = 0;

		if(t.hasLeft(t.root())){
			nodosIzq = calcularNodos2(t,t.left(t.root()));
		}
		if(t.hasRight(t.root())){
			nodosDer = calcularNodos2(t,t.right(t.root()));
		}

		return nodosIzq < nodosDer;
	}

	public boolean isEven2(BinaryTree<E> t){
		int left = 0;
		int right = 0;
		for(Position<E> pos : t){
			if(!t.isRoot(pos)){
				Position<E> parent = t.parent(pos);
				if(t.hasLeft(parent)){
					if(t.left(parent) == pos){
						left++;
					}
				}
				if(t.hasRight(parent)){
					if(t.right(parent) == pos){
						right++;
					}
				}
			}
		}
		return left < right;
	}

	/**
	 * Check if a BinaryTree is ambidextrous.
	 * A BinaryTree is ambidextrous if its left and right children doesn't differ in more than one.
	 * @param t
	 * @return
	 */
	public boolean isAmbidextrous(BinaryTree<E> t){
		int left = 0;
		int right = 0;
		if(t.isEmpty()){
			return true;
		}
		if(t.isLeaf(t.root())){
			return true;
		}
		Iterator<Position<E>> it = new InOrderIterator<>(t);
		while(it.hasNext()){
			Position<E> node = it.next();
			if (!t.isRoot(node)) {
				Position<E> parent = t.parent(node);
				if(t.hasLeft(parent)){
					if(t.left(parent).equals(node)){
						left++;
					}
				}
				if(t.hasRight(parent)){
					if(t.right(parent).equals(node)){
						right++;
					}
				}
			}
		}

		return (Math.abs(left - right) <= 1);
	}

	public boolean isBalanced(BinaryTree<E> tree) {
		if(tree.isEmpty()){
			return true;
		}
		boolean[] balanced = new boolean[1];
		balanced[0] = true;
		isBalancedAux(tree, tree.root(), balanced);
		return balanced[0];
	}

	private int isBalancedAux(BinaryTree<E> tree, Position<E> node, boolean[] balanced) {
		int left = 0;
		int right = 0;
		if(tree.hasLeft(node)){
			left = isBalancedAux(tree, tree.left(node), balanced);
		}
		if(tree.hasRight(node)){
			right = isBalancedAux(tree, tree.right(node), balanced);
		}
		if(Math.abs(left-right) > 1){
			balanced[0] = false;
		}
		return Math.max(left, right)+1;
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

	/**
	 * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
	 * iterative
	 * @param tree
	 * @return
	 */
	public boolean isBinarySearchTree(BinaryTree<E> tree){
		boolean isBS = true;
		Comparator<E> comparator = new DefaultComparator<>();

		Iterator<Position<E>> it = tree.iterator();
		while(it.hasNext()){
			Position<E> node = it.next();
			int comp = comparator.compare(tree.left(node).getElement(), node.getElement());
			if(tree.hasLeft(node)){
				if(comp > 0){
					isBS = false;
				}
			}
			if(tree.hasRight(node)){
				if(comp < 0){
					isBS = false;
				}
			}
		}
		return isBS;
	}


	/**
	 * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
	 * recursive
	 * @param tree
	 * @return
	 */
	public boolean isBinarySearchTreeRec(BinaryTree<E> tree){
		return isBinarySearchTreeRecAux(tree, tree.root(), true);
	}

	public boolean isBinarySearchTreeRecAux(BinaryTree<E> tree, Position<E> node, boolean cond){
		Comparator<E> comparator = new DefaultComparator<>();
		int comp = comparator.compare(tree.left(node).getElement(), node.getElement());
		if(tree.hasLeft(node)){
			if(comp < 0){
				return isBinarySearchTreeRecAux(tree, tree.left(node), cond);
			}
			else{
				return false;
			}
		}
		if(tree.hasRight(node)){
			if(comp > 0){
				return isBinarySearchTreeRecAux(tree, tree.right(node), cond);
			}
			else{
				return false;
			}
		}
		return cond;
	}

}
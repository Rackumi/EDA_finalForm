package structures.tree.binarytree;

import structures.Position;
import structures.tree.iterators.InOrderIterator;
import structures.tree.iterators.PreOrderIterator;

import java.util.Iterator;

public class BinaryTreeUtils<E> {
	
	private BinaryTree<E> tree;
	
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

}
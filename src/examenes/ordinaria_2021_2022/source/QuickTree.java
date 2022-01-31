package examenes.ordinaria_2021_2022.source;

import structures.Position;
import structures.tree.narytree.LinkedTree;

public class QuickTree<E> extends LinkedTree<E> {
	
	public QuickTree() {
		super();
	}
	
	@Override
	public Position<E> add(E element, Position<E> p) {
		Position<E> node = super.add(element, p);
		return node;
	}
	
	@Override
	public Position<E> addRoot(E e) {
		Position<E> node = super.addRoot(e);
		return node;
	}
	
	@Override
	public Position<E> add(E element, Position<E> p, int n) {
		Position<E> node = super.add(element, p, n);
		return node;
	}
	
	@Override
	public void remove(Position<E> p) {
		super.remove(p);
	}
	
	public Position<E> search(E element) {
		throw new RuntimeException("Falta por implementar");
	}

}
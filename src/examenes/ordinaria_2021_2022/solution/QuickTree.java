package examenes.ordinaria_2021_2022.solution;

import structures.Position;
import structures.tree.narytree.LinkedTree;

import java.util.HashMap;
import java.util.Map;

public class QuickTree<E> extends LinkedTree<E> {
	
	public QuickTree() {
		super();
	}

	private Map<E, Position<E>> map = new HashMap<>();

	@Override
	public Position<E> add(E element, Position<E> p) {
		Position<E> node = super.add(element, p);
		map.put(node.getElement(), node);
		return node;
	}
	
	@Override
	public Position<E> addRoot(E e) {
		Position<E> node = super.addRoot(e);
		map.put(node.getElement(), node);
		return node;
	}
	
	@Override
	public Position<E> add(E element, Position<E> p, int n) {
		Position<E> node = super.add(element, p, n);
		map.put(node.getElement(), node);
		return node;
	}
	
	@Override
	public void remove(Position<E> p) {
		super.remove(p);
		map.remove(p.getElement());
	}
	
	public Position<E> search(E element) {
		return map.get(element);
	}

}
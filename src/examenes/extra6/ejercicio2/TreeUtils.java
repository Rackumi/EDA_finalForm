package examenes.extra6.ejercicio2;

import structures.Position;
import structures.tree.Tree;
import structures.tree.iterators.BFSIterator;

import java.util.*;

public class TreeUtils<E> {
	
	public boolean iguales (Tree<E> t1, Tree<E> t2) {
		if(t1.isEmpty() && t2.isEmpty()) {
			return true;
		}
		else if(!t1.isEmpty() && t2.isEmpty()){
			return false;
		}
		else if(t1.isEmpty() && !t2.isEmpty()){
			return false;
		}
		else {
//			return igualesAux(t1, t1.root(), t2, t2.root());
			return igualesExamen(t1, t1.root(), t2, t2.root());
		}
	}

	public boolean igualesAux(Tree<E> t1, Position<E> node1, Tree<E> t2, Position<E> node2){
		if(!node1.getElement().equals(node2.getElement())){
			return false;
		}
		Iterator<Position<E>> it1 = (Iterator<Position<E>>) t1.children(node1).iterator();
		Iterator<? extends Position<E>> it2 = t1.children(node1).iterator();

		while(it1.hasNext() && it2.hasNext()){
			Position<E> p1 = it1.next();
			Position<E> p2 = it2.next();

			boolean bool = igualesAux(t1, p1, t2, p2);
			if(!bool){
				return false;
			}
		}

		return (!it1.hasNext() && !it2.hasNext());
	}

	public boolean igualesExamen(Tree<E> t1, Position<E> node1, Tree<E> t2, Position<E> node2) { //este se basa en el concepto de iguales que nos dice el ejercicio
		if(!node1.getElement().equals(node2.getElement())){
			return false;
		}

		Set<Position<E>> s1 = new HashSet<>();
		for(Position<E> p : t1.children(node1)){
			s1.add(p);
		}
		int cont1 = s1.size();

		Set<Position<E>> s2 = new HashSet<>();
		for(Position<E> p : t2.children(node2)){
			s2.add(p);
		}
		int cont2 = s2.size();

		if(cont1!=cont2){
			return false;
		}

		for(Position<E> node: s1){
			//usando un mapa podriamos hacer un get y sacar el elemento
			if(!s2.contains(node)){
				return false;
			}
			else{
				boolean aux = igualesExamen(t1,node,t2,node);
				if(!aux) {
					return false;
				}
			}
		}

		return true;
	}

	//Nota: La otra función la hacemos en los LinkedTree con la siguiente cabecera
	//public LinkedTree<E> copiarDesde (Position<E> origen);

}
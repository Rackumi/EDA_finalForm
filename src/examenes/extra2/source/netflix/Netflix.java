package examenes.extra2.source.netflix;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.*;

public class Netflix {

	Map<String, LinkedList<Movie>> mapTitulos = new HashTableMapDH<>();
	Map<Integer, LinkedList<Movie>> mapAno = new HashTableMapDH<>();
	Map<String, LinkedList<Movie>> mapTipo = new HashTableMapDH<>();

	public void addContent(String title, int year, ArrayList<String> types) {

		LinkedList<Movie> l1 = mapTitulos.get(title);
		if(l1==null){
			l1 = new LinkedList<>();
			l1.add(new Movie(title, year, types));
			mapTitulos.put(title, l1);
		}
		else{
			l1.add(new Movie(title, year, types));
		}

		LinkedList<Movie> l2 = mapAno.get(year);
		if(l2==null){
			l2 = new LinkedList<>();
			l2.add(new Movie(title, year, types));
			mapAno.put(year, l2);
		}
		else{
			l2.add(new Movie(title, year, types));
		}

		for(String type: types) {
			LinkedList<Movie> l3 = mapTipo.get(type);
			if (l3 == null) {
				l3 = new LinkedList<>();
				l3.add(new Movie(title, year, types));
				mapTipo.put(type, l3);
			} else {
				l3.add(new Movie(title, year, types));
			}
		}
	}
	
	public Iterable<Movie> findTitle(String title){
		return mapTitulos.get(title);
	}
	
	public Iterable<Movie> findYear(int year){
		return mapAno.get(year);
	}

	public Iterable<Movie> findType(String type) {
		return mapTipo.get(type);
	}
	
	public Iterable<Movie> findType(Set<String> type){
		Set<Movie> set = new HashSet<>();
		for(String t: type){
			set.addAll(mapTipo.get(t));
		}
		return set;
	}

}
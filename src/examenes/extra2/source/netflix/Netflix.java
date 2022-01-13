package examenes.extra2.source.netflix;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.dictionaries1.Dictionary;
import structures.notOrderedMapsAndDictionaries.dictionaries1.HashTableDictionarySC;

import java.util.*;

public class Netflix {

	Dictionary<String, Movie> m1 = new HashTableDictionarySC<>();
	Dictionary<Integer, Movie> m2 = new HashTableDictionarySC<>();
	Dictionary<String, Movie> m3 = new HashTableDictionarySC<>();

	public void addContent(String title, int year, ArrayList<String> types){
		Movie movie = new Movie(title, year, types);
		m1.insert(title, movie);
		m2.insert(year, movie);
		for(String t: types){
			m3.insert(t, movie);
		}
	}

	public Iterable<Movie> findTitle(String title){
		List<Movie> l = new LinkedList<>();
		for(Entry<String, Movie> p: m1.findAll(title)){
			l.add(p.getValue());
		}
		return l;
	}

	public Iterable<Movie> findYear(int year){
		List<Movie> l = new LinkedList<>();
		for(Entry<Integer, Movie> p: m2.findAll(year)){
			l.add(p.getValue());
		}
		return l;
	}

	public Iterable<Movie> findType(String type){
		List<Movie> l = new LinkedList<>();
		for(Entry<String, Movie> p: m1.findAll(type)){
			l.add(p.getValue());
		}
		return l;
	}

	public Iterable<Movie> findType(Set<String> type){
		Set<Movie> l = new HashSet<>(); //para eliminar repeticiones
		for(String t: type) {
			for (Entry<String, Movie> p : m1.findAll(t)) {
				l.add(p.getValue());
			}
		}
		return l;
	}

}
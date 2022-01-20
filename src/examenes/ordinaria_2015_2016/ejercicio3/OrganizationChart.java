package examenes.ordinaria_2015_2016.ejercicio3;

import java.util.*;

import structures.Position;
import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.dictionaries1.Dictionary;
import structures.notOrderedMapsAndDictionaries.dictionaries1.HashTableDictionarySC;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

public class OrganizationChart {

	private NAryTree<Employee> ntree;
	private Map<String, Position<Employee>> empleados;
	private Dictionary<String, Employee> dic;

	public OrganizationChart(String str){
		ntree = new LinkedTree<>();
		empleados = new HashMap<>();
		dic = new HashTableDictionarySC<>();
	}

	public void getGrantHolders (LinkedList<Employee> almacen) {
		for(Position<Employee> pos: ntree){
			if(ntree.isLeaf(pos)){
				almacen.add(pos.getElement());
			}
		}
	}
	
	public Iterable<Employee> getChiefs (String empleado) {
		List<Employee> l = new LinkedList<>();
		Position<Employee> pos = empleados.get(empleado);
		while(!ntree.isRoot(pos)){
			l.add(pos.getElement());
			pos = ntree.parent(pos);
		}
		l.add(pos.getElement());
		return l;
	}

	public void addEmployee(Employee jefe, Employee empleado) {
		if(jefe != null) {
			empleados.put(empleado.getNombre(), ntree.add(empleado, empleados.get(jefe.getNombre())));
			dic.insert(empleado.getCargo(), empleado);
		}
		else{
			empleados.put(empleado.getNombre(), ntree.addRoot(empleado));
			dic.insert(empleado.getCargo(), empleado);
		}
	}

	public void getEmployees(String cargo, LinkedList<Employee> almacen) {
		for(Entry<String, Employee> entry: dic.findAll(cargo)){
			almacen.add(entry.getValue());
		}
	}

}
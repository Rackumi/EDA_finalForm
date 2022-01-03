package examenes.ordinaria_2015_2016.solucion.ejercicio2;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;

import structures.Position;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapLP;
import structures.tree.narytree.LinkedTree;

public class OrganizationChart {

    LinkedTree<Employee> arbol = new LinkedTree<>();
    HashTableMapLP <String, Position<Employee>> agendaPositions =
            new  HashTableMapLP <>();

    public void getGrantHolders(LinkedList<Employee> almacen) {
        for (Position<Employee> p: arbol) {
            if (arbol.isLeaf(p)) {
                almacen.add (p.getElement());
            }
        }
    }

    public Iterable<Employee> getChiefs(String empleado) {
        ArrayList<Employee> almacen = new ArrayList<Employee>();
        Position<Employee> p = agendaPositions.get(empleado);
        while (!arbol.isRoot(p)) {
            p = arbol.parent(p);
            almacen.add(p.getElement());
        }
        return almacen;
    }

    public void addEmployee(Employee jefe, Employee empleado) {
        if (jefe==null) {
            Position<Employee> p = arbol.addRoot(empleado);
            agendaPositions.put (empleado.getNombre(), p);
        }else {
            Position<Employee> p = arbol.add(empleado, agendaPositions.get (jefe.getNombre()));
            agendaPositions.put (empleado.getNombre(), p);
        }
    }

    public void getEmployees(String cargo, LinkedList<Employee> almacen) {
        
    }

}
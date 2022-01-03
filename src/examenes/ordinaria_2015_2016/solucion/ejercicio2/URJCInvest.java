package examenes.ordinaria_2015_2016.solucion.ejercicio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapLP;

public class URJCInvest {
    HashTableMapLP<String, OrganizationChart> mapa_empresas = 
            new HashTableMapLP<>();
    
    HashTableMapLP<String, HashSet<Employee>> mapa_cargos =
            new HashTableMapLP<>();
    
    public OrganizationChart searchCompany(String empresa) {
        return mapa_empresas.get(empresa);
    }

    public Iterable<Employee> getGrantHolders(String empresa) {
        OrganizationChart e = mapa_empresas.get (empresa);
        LinkedList<Employee> lista = new LinkedList<>();
        e.getGrantHolders(lista);
        return lista;
    }

    public Iterable<Employee> getChiefs(String empresa, String empleado) {
        OrganizationChart e = mapa_empresas.get (empresa);
        return e.getChiefs(empleado);
    }

    public Iterable<Employee> getEmployees(String cargo) {
        return mapa_cargos.get(cargo);
    }

    public void addEmployee(String empresa, Employee jefe, Employee empleado) {
        OrganizationChart e = mapa_empresas.get (empresa);
        
        if (e==null) {
            e = new OrganizationChart();
            e.addEmployee(jefe, empleado);
            mapa_empresas.put (empresa, e);
        }else {
            e.addEmployee(jefe, empleado);
        }
        
        HashSet<Employee> listaDeCargo = mapa_cargos.get(empleado.getCargo());
        if (listaDeCargo==null) {
            listaDeCargo= new HashSet<>();
            listaDeCargo.add(empleado);
            mapa_cargos.put (empleado.getCargo(), listaDeCargo);
        }else {
            listaDeCargo.add(empleado);
        }
                
    }

}
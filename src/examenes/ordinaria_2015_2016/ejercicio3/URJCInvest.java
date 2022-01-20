package examenes.ordinaria_2015_2016.ejercicio3;

import structures.notOrderedMapsAndDictionaries.Entry;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class URJCInvest {

	private Map<String, OrganizationChart> map;

	public URJCInvest(){
		map = new HashMap<>();
	}

	public OrganizationChart searchCompany (String empresa) {
		OrganizationChart organizationChart = map.get(empresa);
		if(organizationChart == null){
			throw new RuntimeException("Esa empresa no esta entre las carteras de empresa");
		}
		return organizationChart;
	}

	public Iterable<Employee> getGrantHolders (String empresa) {
		OrganizationChart organizationChart = searchCompany(empresa);
		LinkedList<Employee> l = new LinkedList<>();
		organizationChart.getGrantHolders(l);
		return l;
	}

	public Iterable<Employee> getChiefs (String empresa, String empleado) {
		OrganizationChart organizationChart = searchCompany(empresa);
		return organizationChart.getChiefs(empleado);
	}

	public Iterable<Employee> getEmployees (String cargo) {
		LinkedList<Employee> l = new LinkedList<>();
		LinkedList<Employee> lAux = new LinkedList<>();
		for(String k: map.keySet()){
			OrganizationChart oc = map.get(k);
			oc.getEmployees(cargo, lAux);
			l.addAll(lAux);
		}
		return l;
	}

	public void addEmployee (String empresa, Employee jefe, Employee empleado) {
		OrganizationChart organizationChart = searchCompany(empresa);
		organizationChart.addEmployee(jefe, empleado);
	}

	public static void main(String[] args) {

		URJCInvest invest = new URJCInvest();
		OrganizationChart urjc = new OrganizationChart("URJC");
		Employee fs = new Employee("URJC", "Fernando Su·rez", "Dean", "");
		Employee ad = new Employee("URJC", "Abraham Duarte", "Full professor", "");
		Employee as = new Employee("URJC", "Antonio Sanz", "Full professor", "");
		Employee js = new Employee("URJC", "Jes˙s S·nchez-Oro", "Associate professor", "");
		Employee dc = new Employee("URJC", "David Concha", "Associate professor", "");
		urjc.addEmployee(null, fs);
		urjc.addEmployee(fs, ad);
		urjc.addEmployee(fs, as);
		urjc.addEmployee(ad, js);
		urjc.addEmployee(as, dc);
//		invest.addCompany(urjc);

		System.out.println("JEFES DE JESUS");
		for (Employee emp : invest.getChiefs("URJC", "Jes˙s S·nchez-Oro")) {
			System.out.println(emp);
		}
		System.out.println("JEFES DE ANTONIO");
		for (Employee emp : invest.getChiefs("URJC", "Antonio Sanz")) {
			System.out.println(emp);
		}
		System.out.println("JEFES DE FERNANDO");
		for (Employee emp : invest.getChiefs("URJC", "Fernando Su·rez")) {
			System.out.println(emp);
		}

		System.out.println("BECARIOS URJC");
		for (Employee emp : invest.getGrantHolders("URJC")) {
			System.out.println(emp);
		}

		System.out.println("FULL PROFESSORS");
		for (Employee emp : invest.getEmployees("Full professor")) {
			System.out.println(emp);
		}
		System.out.println("ASSOCIATE PROFESSORS");
		for (Employee emp : invest.getEmployees("Associate professor")) {
			System.out.println(emp);
		}
		System.out.println("DEANS");
	}

}
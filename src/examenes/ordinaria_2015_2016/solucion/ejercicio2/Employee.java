package examenes.ordinaria_2015_2016.solucion.ejercicio2;

public class Employee {

	private String nombre;
	private String descripcion;
	private String cargo;
	private String empresa;

	public Employee (String n, String d, String c, String e) {
		this.nombre = n;
		this.descripcion = d;
		this.cargo = c;
		this.empresa = e;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
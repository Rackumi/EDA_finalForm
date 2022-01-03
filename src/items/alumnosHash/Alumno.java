package items.alumnosHash;

import java.util.Objects;
import static java.lang.Integer.parseInt;

public class Alumno {

    private String nombre;
    private String dni;
    private int edad;

    public Alumno(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Alumno) {
            Alumno alumno = (Alumno) o;
            return Objects.equals(this.nombre, alumno.getNombre()) && Objects.equals(this.dni, alumno.getDni());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() { //equals y hascode deben tener en cuenta los mismos atributos
        return parseInt(getDni()) % 97;
    }

}
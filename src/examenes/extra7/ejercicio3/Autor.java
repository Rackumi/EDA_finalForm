package examenes.extra7.ejercicio3;

/**
 * @author Rackumi
 */
public class Autor implements Comparable {

    private String nombre;
    private int publicaciones;

    @Override
    public int compareTo(Object o) {
        Autor otro = (Autor) o;
        if (getPublicaciones() > otro.getPublicaciones()) {
            return 1;
        } else if (getPublicaciones() < otro.getPublicaciones()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the publicaciones
     */
    public int getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(int publicaciones) {
        this.publicaciones = publicaciones;
    }

}
package examenes.extraordinaria_2020_2021;

public class Area {

    private String nombre;
    private int dificultadLvl;
    private int nEnemigos;

    public Area(String nombre, int dificultadLvl, int nEnemigos) {
        this.nombre = nombre;
        this.dificultadLvl = dificultadLvl;
        this.nEnemigos = nEnemigos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDificultadLvl() {
        return dificultadLvl;
    }

    public void setDificultadLvl(int dificultadLvl) {
        this.dificultadLvl = dificultadLvl;
    }

    public int getnEnemigos() {
        return nEnemigos;
    }

    public void setnEnemigos(int nEnemigos) {
        this.nEnemigos = nEnemigos;
    }

}
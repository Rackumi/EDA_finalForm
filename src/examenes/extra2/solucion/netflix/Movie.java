package examenes.extra2.solucion.netflix;

import java.util.ArrayList;

public class Movie {
    private String titulo;
    private int annio;
    private ArrayList<String> generos;
    
    public Movie (String titulo, int annio, ArrayList<String> generos) {
        this.titulo = titulo;
        this.annio = annio;
        this.generos = generos;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the annio
     */
    public int getAnnio() {
        return annio;
    }

    /**
     * @param annio the annio to set
     */
    public void setAnnio(int annio) {
        this.annio = annio;
    }

    /**
     * @return the generos
     */
    public ArrayList<String> getGeneros() {
        return generos;
    }

    /**
     * @param generos the generos to set
     */
    public void setGeneros(ArrayList<String> generos) {
        this.generos = generos;
    }

}
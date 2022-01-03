package examenes.extra2.solucion.netflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Netflix {
    private HashMap<String, ArrayList<Movie>> mapa_por_titulo = new HashMap<> ();
    private HashMap<Integer, ArrayList<Movie>> mapa_por_annio = new HashMap<> ();
    private HashMap<String, ArrayList<Movie>> mapa_por_genero = new HashMap<> ();

    public void addContent(String title, int year, ArrayList<String> types) {
        Movie m = new Movie (title, year, types);

        ArrayList<Movie> peliculas = mapa_por_titulo.get (title);
        
        if (peliculas==null) { //Es la primera vez que meten ese titulo, no hay otra con ese titulo
            peliculas = new ArrayList<>();
            peliculas.add (m);
            mapa_por_titulo.put (title, peliculas);
        }else {
            peliculas.add (m);
        }
        
        peliculas = mapa_por_annio.get (year);
        
        if (peliculas==null) { //Es la primera vez que meten ese titulo, no hay otra con ese titulo
            peliculas = new ArrayList<Movie>();
            peliculas.add (m);
            mapa_por_annio.put (year, peliculas);
        }else {
            peliculas.add (m);
        }

        for (String genero: types) {
            peliculas = mapa_por_genero.get (genero);
        
            if (peliculas==null) { //Es la primera vez que meten ese titulo, no hay otra con ese titulo
                peliculas = new ArrayList<Movie>();
                peliculas.add (m);
                mapa_por_genero.put (genero, peliculas);
            }else {
                peliculas.add (m);
            }
        }
    }

    public Iterable<Movie> findTitle(String title) {
        return mapa_por_titulo.get (title);
    }

    public Iterable<Movie> findYear(int year) {
        return mapa_por_annio.get (year);
    }

    public Iterable<Movie> findType(String type) {
        return mapa_por_genero.get (type);

    }

    public Iterable<Movie> findType(Set<String> types) {
        Set<Movie> resultado = new HashSet <> ();
        
        for (String genero: types) {
            for (Movie m: mapa_por_genero.get (genero)) {
                resultado.add(m);
            }
        }
        
        return resultado;
    }

}
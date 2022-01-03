package examenes.ordinaria_2020_2021.solucion;

import java.util.Objects;

public class Movie {

    String title;
    float rate;
    int runtime;

    public Movie(String title, float rate, int runtime) {
        this.title = title;
        this.rate = rate;
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title+", "+rate+", "+runtime;
    }
}

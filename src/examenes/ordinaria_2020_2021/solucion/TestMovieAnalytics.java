package examenes.ordinaria_2020_2021.solucion;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestMovieAnalytics {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/examenes/ordinaria_2020_2021/solucion/movies.csv";
        MovieAnalytics analytics = new MovieAnalytics(path);
        analytics.showMovies();
        PrintWriter pw = new PrintWriter("src/examenes/ordinaria_2020_2021/solucion/showmovies.txt");
        pw.println(analytics.showMovies());
        pw.close();
    }

}
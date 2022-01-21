package examenes.ordinaria_2020_2021.source;

import examenes.ordinaria_2020_2021.solucion.MovieAnalytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestMovieAnalytics {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/examenes/ordinaria_2020_2021/source/movies.csv";
        examenes.ordinaria_2020_2021.solucion.MovieAnalytics analytics = new MovieAnalytics(path);
        analytics.showMovies();
        PrintWriter pw = new PrintWriter("src/examenes/ordinaria_2020_2021/source/showmovies.txt");
        pw.println(analytics.showMovies());
        pw.close();
    }

}
package examenes.ordinaria_2020_2021.test;

import examenes.ordinaria_2020_2021.solucion.Movie;
import examenes.ordinaria_2020_2021.solucion.MovieAnalytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieAnalyticsTest {

//    @org.junit.jupiter.api.Test
//    void testPromising9() throws IOException {
//        List<String> expected = new BufferedReader(new FileReader("testFiles/promising_9.txt")).lines().collect(Collectors.toList());
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        List<String> platforms = new ArrayList<>();
//        platforms.add("netflix");
//        platforms.add("disney");
//        int pos = 0;
//        for (Movie movie : analytics.promisingMoviesInPlatforms(9, platforms)) {
//            assertEquals(expected.get(pos), movie.toString());
//            pos++;
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void testPromising8() throws IOException {
//        List<String> expected = new BufferedReader(new FileReader("testFiles/promising_8.txt")).lines().collect(Collectors.toList());
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        List<String> platforms = new ArrayList<>();
//        platforms.add("netflix");
//        platforms.add("disney");
//        int pos = 0;
//        for (Movie movie : analytics.promisingMoviesInPlatforms(8, platforms)) {
//            assertEquals(expected.get(pos), movie.toString());
//            pos++;
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void testPromising7() throws IOException {
//        List<String> expected = new BufferedReader(new FileReader("testFiles/promising_7.txt")).lines().collect(Collectors.toList());
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        List<String> platforms = new ArrayList<>();
//        platforms.add("hulu");
//        platforms.add("prime");
//        int pos = 0;
//        for (Movie movie : analytics.promisingMoviesInPlatforms(7, platforms)) {
//            assertEquals(expected.get(pos), movie.toString());
//            pos++;
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void testComedy() throws IOException {
//        Set<String> expected = new BufferedReader(new FileReader("testFiles/comedy.txt")).lines().collect(Collectors.toSet());
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        for (Movie movie : analytics.moviesOfGenre("Comedy")) {
//            assertTrue(expected.contains(movie.toString()));
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void testAction() throws IOException {
//        Set<String> expected = new BufferedReader(new FileReader("testFiles/action.txt")).lines().collect(Collectors.toSet());
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        for (Movie movie : analytics.moviesOfGenre("Action")) {
//            assertTrue(expected.contains(movie.toString()));
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void testShowMovies() throws IOException {
//        String expected = Files.readString(Path.of("testFiles/showmovies.txt"));
//        String path = "movies.csv";
//        MovieAnalytics analytics = new MovieAnalytics(path);
//        String showMovies = analytics.showMovies();
//        assertEquals(expected, showMovies);
//    }

}

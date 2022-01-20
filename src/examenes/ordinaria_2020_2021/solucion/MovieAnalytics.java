package examenes.ordinaria_2020_2021.solucion;

import structures.orderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.AbstractTreeOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.Entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovieAnalytics {

    private AbstractTreeOrderedDict<Integer, Movie> movies;
    private Map<String, Set<Movie>> platformsMovies;
    private Map<String, Set<Movie>> genresMovies;

    public MovieAnalytics(String path) {
        movies = new AVLOrderedDict<>();
        platformsMovies = new HashMap<>();
        genresMovies = new HashMap<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = null;
            bf.readLine(); // Slip header
            while ((line = bf.readLine()) != null) {
                String[] tokens = line.split(",");
                try {
                    String title = tokens[0];
                    float rate = Float.parseFloat(tokens[1]);
                    boolean netflix = Integer.parseInt(tokens[2]) == 1;
                    boolean hulu = Integer.parseInt(tokens[3]) == 1;
                    boolean primevideo = Integer.parseInt(tokens[4]) == 1;
                    boolean disney = Integer.parseInt(tokens[5]) == 1;
                    String[] genresList = tokens[6].split(";");
                    int runtime = Integer.parseInt(tokens[7]);
                    Movie movie = addMovie(title, rate, runtime, genresList);
                    if (netflix) {
                        addToPlatform(movie, "netflix");
                    }
                    if (hulu) {
                        addToPlatform(movie, "hulu");
                    }
                    if (primevideo) {
                        addToPlatform(movie, "prime");
                    }
                    if (disney) {
                        addToPlatform(movie, "disney");
                    }
                } catch (Exception e) {
                    // Ignore errors due to misformat in data
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Movie addMovie(String title, float rate, int runtime, String[] genres) {
        Movie movie = new Movie(title, rate, runtime);
        movies.insert((int) rate, movie);
        for (String genre : genres) {
           genresMovies.putIfAbsent(genre, new HashSet<>());
           genresMovies.get(genre).add(movie);
        }
        return movie;
    }

    private void addToPlatform(Movie movie, String platform) {
        platformsMovies.putIfAbsent(platform, new HashSet<>());
        platformsMovies.get(platform).add(movie);
    }

    public Iterable<Movie> promisingMoviesInPlatforms(int rating, Iterable<String> platforms) {
        Set<Movie> search = new HashSet<>();
        for (Entry<Integer, Movie> entry : movies.findAll(rating)) {
            for (String platform : platforms) {
                if (platformsMovies.containsKey(platform) && platformsMovies.get(platform).contains(entry.getValue())) {
                    search.add(entry.getValue());
                }
            }
        }
        return search;
    }

    public Iterable<Movie> moviesOfGenre(String genre) {
        return genresMovies.get(genre);
    }

    public String showMovies() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            stb.append("==========\n");
            stb.append(i).append("\n");
            stb.append("==========\n");
            for (Entry<Integer, Movie> entry : movies.findAll(i)) {
                Movie movie = entry.getValue();
                stb.append(movie.toString()).append("\n");
            }
        }
        return stb.toString();
    }

}
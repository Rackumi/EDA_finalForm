package examenes.ordinaria_2020_2021.source;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
//import structures.OrderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
//import structures.OrderedMapsAndDictionaries.ordereddictionary.Entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MovieAnalytics {

//    HashTableMapDH<String, Set<Movie>> genres;
//    AVLOrderedDict<Integer, Movie> scores;
//    HashTableMapDH<String, Set<Movie> > platforms;
//
//    public MovieAnalytics(String path) {
//        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
//            // Atributes
//            genres= new HashTableMapDH<String, Set<Movie>>();
//            scores = new AVLOrderedDict<>();
//            platforms = new HashTableMapDH<String, Set<Movie>>();
//            platforms.put("netflix", new HashSet<Movie>());
//            platforms.put("hulu", new HashSet<Movie>());
//            platforms.put("prime", new HashSet<Movie>());
//            platforms.put("disney", new HashSet<Movie>());
//            String line = null;
//            bf.readLine(); // Skip header
//            // Read lines
//            while ((line = bf.readLine()) != null) {
//                String[] tokens = line.split(",");
//                try {
//                    String title = tokens[0];
//                    float rate = Float.parseFloat(tokens[1]);
//                    boolean netflix = Integer.parseInt(tokens[2]) == 1;
//                    boolean hulu = Integer.parseInt(tokens[3]) == 1;
//                    boolean primevideo = Integer.parseInt(tokens[4]) == 1;
//                    boolean disney = Integer.parseInt(tokens[5]) == 1;
//                    String[] genresList = tokens[6].split(";");
//                    int runtime = Integer.parseInt(tokens[7]);
//                    //
//                    Movie m = new Movie( title, rate, netflix, hulu, primevideo, disney, genresList, runtime);
//                    // Dict genres
//                    for( String g : genresList ) {
//                        Set<Movie> s = genres.get(g);
//                        if (s==null)
//                            genres.put(g, new HashSet<Movie>());
//                        genres.get(g).add(m);
//                    }
//                    if(netflix)
//                        platforms.get("netflix").add(m);
//                    if(hulu)
//                        platforms.get("hulu").add(m);
//                    if(primevideo)
//                        platforms.get("prime").add(m);
//                    if(disney)
//                        platforms.get("disney").add(m);
//                    // Dict score
//                    //scores.get( (int) rate ).insert( m );
//                    scores.insert( (int) rate , m );
//                } catch (Exception e) {
//                    // Ignore errors due to misformat in data
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Movie addMovie(String title, float rate, int runtime, String[] genres) {
//        Movie m = new Movie( title, rate, false, false, false, false, genres, runtime);
//        // Dict genres
//        for( String g : genres )
//            this.genres.get(g).add(m);
//        // No booleans
//        // Dict score
//        scores.insert( (int) rate, m );
//        return m;
//    }
//
//    public Iterable<Movie> promisingMoviesInPlatforms(int rating, Iterable<String> platforms) {
//        Set<Movie> search = new HashSet<>();
//        for (Entry<Integer,Movie> entry : scores.findAll(rating)) {
//            for (String platform : platforms) {
//                if (this.platforms.get(platform).contains(entry.getValue())) {
//                    search.add(entry.getValue());
//                }
//            }
//        }
//        return search;
//    }
//
//    public Iterable<Movie> moviesOfGenre(String genre) {
//        ArrayList<Movie> list = new ArrayList<>();
//        for( Movie m : genres.get(genre) )
//            list.add(m);
//        return list;
//    }
//
//    public String showMovies() {
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i <10; i++){
//            sb.append("==========\n");
//            sb.append( i + "\n");
//            sb.append("==========\n");
//            for (Entry<Integer,Movie> m : scores.findAll(i)) {
//                sb.append( m.getValue().getTitle() + ", " + m.getValue().getRate() + ", " + m.getValue().getRuntime() + "\n" );
//            }
//        }
//        sb.append("==========\n");
//        sb.append( 10 + "\n");
//        sb.append("==========\n");
//        return sb.toString();
//    }
}

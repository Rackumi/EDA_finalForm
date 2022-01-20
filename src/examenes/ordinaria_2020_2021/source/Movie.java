package examenes.ordinaria_2020_2021.source;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
//                        String title = tokens[0];
//                        float rate = Float.parseFloat(tokens[1]);
//                        boolean netflix = Integer.parseInt(tokens[2]) == 1;
//                        boolean hulu = Integer.parseInt(tokens[3]) == 1;
//                        boolean primevideo = Integer.parseInt(tokens[4]) == 1;
//                        boolean disney = Integer.parseInt(tokens[5]) == 1;
//                        String[] genresList = tokens[6].split(";");
//                        int runtime = Integer.parseInt(tokens[7]);

    private String title;
    private float rate;
    private boolean netflix;
    private boolean hulu;
    private boolean primevide;
    private boolean disney;
    private String[] genresList;
    int runtime;

    public Movie(String t, float r, boolean n, boolean h, boolean p, boolean d, String[]g, int run){
        this.title=t;
        this.rate=r;
        this.netflix=n;
        this.hulu=h;
        this.primevide=p;
        this.disney=d;
        this.genresList=g;
        this.runtime=run;
    }

    public String getTitle(){
        return title;
    }

    public float getRate(){
        return rate;
    }

    public int getRuntime() {
        return runtime;
    }

    @Override
    public int compareTo(Movie o) {
        Movie b = (Movie) o;
        if(rate > b.getRate())
            return 1;
        else if (rate < b.getRate())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString(){
        return title + ", " + rate + ", " + runtime;
    }

    @Override
    public int hashCode(){
        return Objects.hash(title);
    }

    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        Movie m = (Movie) o;
        return m.title.equals(title);
    }

}
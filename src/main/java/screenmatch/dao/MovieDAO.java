package screenmatch.dao;

import screenmatch.models.Movie;
import screenmatch.services.record.MovieData;

import java.util.ArrayList;

public class MovieDAO {

    private static ArrayList<Movie> movieBacklogg = new ArrayList<>();
    private static ArrayList<Movie> movieWatched = new ArrayList<>();

    public Movie newMovie(MovieData data){
        Movie movie = Movie.fromData(data);
        movieBacklogg.add(movie);
        return movie;
    }

    public static ArrayList<Movie> getMovieBacklogg() {
        return movieBacklogg;
    }

    public void setWatched(Movie movie){
        if(!movieBacklogg.contains(movie)){
            throw new IllegalArgumentException("This movie is not in backlog.");
        }
        movie.setWatched(true);
        movieWatched.add(movie);
    }

    public static ArrayList<Movie> getMovieWatched() {
        return movieWatched;
    }
}

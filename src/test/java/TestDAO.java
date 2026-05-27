import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screenmatch.controller.MovieController;
import screenmatch.dao.MovieDAO;
import screenmatch.models.Movie;
import screenmatch.services.MovieApiServiceInterface;
import screenmatch.services.OMDBservice;
import screenmatch.services.record.MovieData;

import java.io.IOException;


public class TestDAO {

    private MovieDAO dao;

    @BeforeEach
    public void setup(){
        dao = new MovieDAO();
    }

    @Test
    public void addMovieDAO() {
        MovieData data = new MovieData(
                "Harry Potter",
                2001,
                "152 min",
                "Adventure, Family, Fantasy",
                "Chris Columbus"
        );

        Movie movie = dao.newMovie(data);
        Assertions.assertTrue(MovieDAO.getMovieBacklogg().contains(movie));
    }

    @Test
    public void setWatched(){

        MovieData hp = new MovieData(
                "Harry Potter",
                2001,
                "152 min",
                "Adventure, Family, Fantasy",
                "Chris Columbus"
        );

        MovieData avatar = new MovieData(
                "Harry Potter",
                2001,
                "152 min",
                "Adventure, Family, Fantasy",
                "Chris Columbus"
        );

        Movie movie = dao.newMovie(hp);


        MovieDAO.getMovieBacklogg().forEach(movie ->
                System.out.println(movie.toString()));
    }


}

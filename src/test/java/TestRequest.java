import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screenmatch.dao.MovieDAO;
import screenmatch.models.Movie;
import screenmatch.services.OMDBservice;
import screenmatch.services.TMDBservice;
import screenmatch.services.record.MovieData;

import java.io.IOException;

public class TestRequest {

    private OMDBservice omdBservice;
    private TMDBservice tmdBservice;
    private MovieDAO dao;

    @BeforeEach
    public void setup(){
        omdBservice = new OMDBservice();
        tmdBservice = new TMDBservice();
        dao = new MovieDAO();
    }

    @Test
    public void testResquet() throws IOException, InterruptedException {

        String titleRequest = "Toy Story";
        MovieData result = omdBservice.searchByTitle(titleRequest);
        dao.newMovie(result);

        Assertions.assertNotNull(result.title());
        Assertions.assertEquals(titleRequest, MovieDAO.getMovieBacklogg().get(0).getName());
    }

    @Test
    public void TMResquet() throws IOException, InterruptedException {

        String titleRequest = "Matrix";
        MovieData result = tmdBservice.searchByTitle(titleRequest);
        dao.newMovie(result);


//        Assertions.assertNotNull(result.title());
//        Assertions.assertEquals(titleRequest, MovieDAO.getMovieBacklogg().get(0).getName());
    }





}

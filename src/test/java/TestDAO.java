import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screenmatch.dao.MovieDAO;
import screenmatch.models.Movie;
import screenmatch.services.record.MovieData;


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
                "Avatar",
                2009,
                "162 min",
                "Action, Adventure, Fantasy",
                "James Cameron"
        );

        Movie movieHP = dao.newMovie(hp);
        Movie movieAV = dao.newMovie(avatar);

        dao.setWatched(movieHP);

        MovieDAO.getMovieBacklogg().forEach(movie -> System.out.println(movie.toString()));
        Assertions.assertEquals(MovieDAO.getMovieBacklogg().get(1),movieAV);
    }


}

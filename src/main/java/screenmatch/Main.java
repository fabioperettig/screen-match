package screenmatch;

import screenmatch.services.MovieApiServiceInterface;
import screenmatch.services.OMDBservice;
import screenmatch.dao.MovieDAO;

import screenmatch.controller.MovieController;
import screenmatch.services.TMDBservice;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        MovieApiServiceInterface service = new TMDBservice();
        MovieDAO dao = new MovieDAO();

        MovieController controller = new MovieController(service, dao);

        try {
            controller.createMovieFromApi("Harry Potter");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

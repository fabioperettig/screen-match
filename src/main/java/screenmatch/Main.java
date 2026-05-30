package screenmatch;

import screenmatch.services.MovieApiServiceInterface;
import screenmatch.dao.MovieDAO;

import screenmatch.controller.MovieController;
import screenmatch.services.TMDBservice;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        /// Swap implementation: Dependency Injection
        /// MovieApiServiceInterface service = new OMDBservice();
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

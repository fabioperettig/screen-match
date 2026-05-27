package screenmatch.controller;

import screenmatch.dao.MovieDAO;
import screenmatch.models.Movie;
import screenmatch.services.MovieApiServiceInterface;
import screenmatch.services.record.MovieData;

import java.io.IOException;

public class MovieController {

    private MovieApiServiceInterface movieApiService;
    private MovieDAO movieDAO;

    public MovieController(MovieApiServiceInterface movieApiService, MovieDAO movieDAO) {
        this.movieApiService = movieApiService;
        this.movieDAO = movieDAO;
    }

    public Movie createMovieFromApi(String title) throws IOException, InterruptedException {
        MovieData data = movieApiService.searchByTitle(title);
        return movieDAO.newMovie(data);
    }

}

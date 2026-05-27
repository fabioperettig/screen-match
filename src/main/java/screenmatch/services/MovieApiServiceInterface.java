package screenmatch.services;

import screenmatch.services.record.MovieData;

import java.io.IOException;

public interface MovieApiServiceInterface {
    MovieData searchByTitle(String title) throws IOException, InterruptedException;
}

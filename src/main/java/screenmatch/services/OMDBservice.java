package screenmatch.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import screenmatch.services.record.MovieData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OMDBservice implements MovieApiServiceInterface {
    @Override
    public MovieData searchByTitle(String title) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("OMDB_API_KEY");

        if (apiKey == null || apiKey.isBlank()){
            throw new IllegalStateException("MISSING ENVIRONMENT USER API");
        }

        String movieTitle = title.replace(" ", "+");
        String url = "http://www.omdbapi.com/?t="+movieTitle+"&apikey="+apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        MovieData movieData = gson.fromJson(json, MovieData.class);
        System.out.println(response.body());
        return movieData;
    }
}
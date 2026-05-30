package screenmatch.services;

import com.google.gson.*;
import io.github.cdimascio.dotenv.Dotenv;
import screenmatch.services.record.MovieData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TMDBservice implements MovieApiServiceInterface {

    @Override
    public MovieData searchByTitle(String title) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("TMDB_API_KEY");
        String token = dotenv.get("TMDB_TOKEN");

        if (apiKey == null || apiKey.isBlank()){
            throw new IllegalStateException("MISSING ENVIRONMENT USER API");
        }

        if (token == null || token.isBlank()){
            throw new IllegalStateException("MISSING TOKEN");
        }

        String movieTitle = title.replace(" ", "+");
        String url = "https://api.themoviedb.org/3/account/23216271/favorite/movies?" +
                "language=en-US&page=1&sort_by=created_at.asc";

        String searchUrl = "https://api.themoviedb.org/3/search/movie?query=" + movieTitle +
                "&language=pt-BR&page=1&include_adult=false";



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(searchUrl))
                .GET()
                .header("accept", "application/json")
                .header("Authorization", "Bearer "+ token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonArray results = jsonObject.getAsJsonArray("results");

        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("Movie not found in TMDB: " + title);
        }

        int movieId = results.get(0).getAsJsonObject().get("id").getAsInt();

        String detailsUrl = "https://api.themoviedb.org/3/movie/"
                +movieId+"?language=pt-BR&append_to_response=credits";

        HttpRequest detailsRequest = HttpRequest.newBuilder()
                .uri(URI.create(detailsUrl))
                .GET()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token).build();

        HttpResponse<String> detailsResponse = client.send(detailsRequest, HttpResponse.BodyHandlers.ofString());
        JsonObject detailsJson = gson.fromJson(detailsResponse.body(), JsonObject.class);
        String movieName = detailsJson.get("title").getAsString();
        String releaseDate = detailsJson.get("release_date").getAsString();
        int year = Integer.parseInt(releaseDate.substring(0, 4));
        String runtime = detailsJson.get("runtime").getAsInt() + " min";

        JsonArray genresJson = detailsJson.getAsJsonArray("genres");
        StringBuilder genresBuilder = new StringBuilder();

        for (int i = 0; i < genresJson.size(); i++) {
            if (i > 0) {
                genresBuilder.append(", ");
            }

            genresBuilder.append(genresJson.get(i).getAsJsonObject().get("name").getAsString());
        }

        String director = "Unknown";
        JsonArray crewJson = detailsJson.getAsJsonObject("credits").getAsJsonArray("crew");

        for (JsonElement crewMember : crewJson) {
            JsonObject crewObject = crewMember.getAsJsonObject();

            if (crewObject.get("job").getAsString().equalsIgnoreCase("Director")) {
                director = crewObject.get("name").getAsString();
                break;
            }
        }

        MovieData movieData = new MovieData(
                movieName,
                year,
                runtime,
                genresBuilder.toString(),
                director
        );

        System.out.println(movieData);

        return movieData;
    }
}

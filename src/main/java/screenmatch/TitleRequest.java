package screenmatch;

import com.google.gson.Gson;
import screenmatch.models.Movie;
import screenmatch.models.Title;
import screenmatch.methods.Utility;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TitleRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        //instances
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Input your movie title: ");
        var input = URLEncoder.encode(scanner.nextLine(),StandardCharsets.UTF_8);


        //API reader
        String apiKey = System.getenv("OMDB_API_KEY");
        if (apiKey == null || apiKey.isBlank()){
            throw new IllegalStateException("MISSING ENVIRONMENT USER API");
        }

        String url = "http://www.omdbapi.com/?t="+input+"&apikey=" + apiKey;

        //requestAPI
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        Movie title = gson.fromJson(response.body(), Movie.class);
    }

}

package screenmatch;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import screenmatch.dao.Utility;
import screenmatch.records.OMDBTitle;

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
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Input your movie title: ");
        var input = URLEncoder.encode(scanner.nextLine(),StandardCharsets.UTF_8);


        //API reader
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("OMDB_API_KEY");
        if (apiKey == null || apiKey.isBlank()){
            throw new IllegalStateException("MISSING ENVIRONMENT USER API");
        }

        String url = "http://www.omdbapi.com/?t="+input+"&apikey=" + apiKey;

        //requestAPI
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println("\n------------------------\n");

        OMDBTitle title = gson.fromJson(response.body(), OMDBTitle.class);

        System.out.println(title);
    }

}

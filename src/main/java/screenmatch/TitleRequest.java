package screenmatch;

import com.google.gson.Gson;
import screenmatch.models.Movie;
import screenmatch.models.Title;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TitleRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        //instances
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your movie title: ");
        var input = scanner.nextLine();

        //requestAPI
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.omdbapi.com/?t="+input+"&apikey=00000000000")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        Movie title = gson.fromJson(response.body(), Movie.class);
        //System.out.println("HERE: "+title.getName() + " | " + title.getReleaseYear());


        System.out.println(title.printInfo());

    }


}

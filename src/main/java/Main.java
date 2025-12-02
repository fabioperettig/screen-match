import screenmatch.models.Movie;
import screenmatch.methods.ListService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        ArrayList<Movie> favorites = new ArrayList<>();
        ListService listService = new ListService();


        Movie harrypotter1 = new Movie("Harry Potter and the Sorcerer's Stone", 2001, "Fantasy");
        Movie starwars4 = new Movie("Star Wars: A New Hope", 1977, "Science Fiction");
        Movie titanic = new Movie("Titanic", 1997, "Romance");
        Movie batmanDK = new Movie("The Dark Knight", 2008, "Action");
        Movie inception = new Movie("Inception", 2010, "Thriller");
        Movie parasite = new Movie("Parasite", 2019, "Drama");
        Movie her = new Movie("Her", 2013,"Drama");

        favorites.add(her);
        favorites.add(starwars4);
        favorites.add(harrypotter1);
        favorites.add(titanic);


        System.out.printf("%nFavorited movies: %d%n",favorites.size());

        System.out.println(titanic.getId());

        System.out.println("\n---------------");
        //Collections.sort(favorites);
        listService.printMovieList(favorites);

        System.out.println("\n---------------Catalog");
        System.out.println(Movie.getMovieBacklogg().toString());

        System.out.println(parasite);

        listService.printWatchedMovies();

        listService.sortYears(favorites);
        System.out.println(favorites);

    }


}
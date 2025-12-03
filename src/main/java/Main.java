import screenmatch.methods.Utility;
import screenmatch.models.Movie;
import screenmatch.methods.ListService;
import screenmatch.methods.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        ArrayList<Movie> favorites = new ArrayList<>();
        ListService listService = new ListService();
        Utility utility = new Utility();


        Movie harrypotter1 = new Movie("Harry Potter and the Sorcerer's Stone", 2001, "Fantasy", 152);
        Movie starwars4 = new Movie("Star Wars: A New Hope", 1977, "Science Fiction", 121);
        Movie titanic = new Movie("Titanic", 1997, "Romance", 194);
        Movie batmanDK = new Movie("The Dark Knight", 2008, "Action", 153);
        Movie inception = new Movie("Inception", 2010, "Thriller", 148);
        Movie parasite = new Movie("Parasite", 2019, "Drama", 132);
        Movie her = new Movie("Her", 2013,"Drama", 126);


        parasite.movieTime();

    }


}
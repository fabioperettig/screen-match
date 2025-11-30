package screenmatch.methods;
import screenmatch.models.Movie;
import screenmatch.models.Serie;
import java.util.ArrayList;

public class ListService {

    public void checkID(ArrayList<Movie> list, int id){
        String notFound = "Movie not found.";
        boolean found = false;

        for (Movie movie : list) {
            if (movie.getId() == id) {
                System.out.println(id + " | movie name: " + movie.getName());
                found = true;
                break;
            }
        }
        if(!found){System.out.println(notFound);}
    };

    public void printMovieList(ArrayList<Movie> list){
        for (Movie localList : list){
            System.out.printf("%nMovie ID: %d | Title: %s | Category: %s",
                    localList.getId(),
                    localList.getName(),
                    localList.getCategory());
        }
    }

}

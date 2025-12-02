package screenmatch.methods;
import screenmatch.models.Movie;
import screenmatch.models.Serie;
import screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Comparator;

public class ListService {

    public <T extends Title> void checkID(ArrayList<T> list, int id){
        String notFound = "Title not found.";
        boolean found = false;

        for (T item : list) {
            if (item.getId() == id) {
                System.out.println(id + " | name: " + item.getName());
                found = true;
                break;
            }
        }
        if(!found){System.out.println(notFound);}
    };


    public void printList(ArrayList<Movie> list){
        for (Movie localList : list){
            System.out.printf("%nMovie ID: %d | Title: %s | Category: %s",
                    localList.getId(),
                    localList.getName(),
                    localList.getCategory());
        }
    }

    public void printWatchedMovies(){
        System.out.println("--Wachted list--");
        System.out.println(Movie.getMoviewatched());
    }

    public <T extends Title> void sortYears(ArrayList<T> localList){
        localList.sort(Comparator.comparing(Title::getReleaseYear));
    }

}

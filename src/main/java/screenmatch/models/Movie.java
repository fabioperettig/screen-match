package screenmatch.models;
import screenmatch.methods.Utility;
import java.util.ArrayList;

public class Movie extends Title {

    private static ArrayList<Movie> movieBacklogg = new ArrayList<>();
    private static ArrayList<Movie> moviewatched = new ArrayList<>();
    Utility utility = new Utility();

    private int runTime;
    private String leadActor;
    private String category;
    private boolean watched;

    //ctor
    public Movie(String name, int releaseYear, String category, int runTime) {
        super(name, releaseYear);
        this.category = category;
        this.runTime = runTime;

        movieBacklogg.add(this);

    }


    //getterSetter
    public static ArrayList<Movie> getMoviewatched() {
        return moviewatched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
        moviewatched.add(this);
    }

    public static ArrayList<Movie> getMovieBacklogg() {
        return movieBacklogg;
    }

    public String getCategory() {
        return category;
    }
    public int getRunTime() {
        return runTime;
    }
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }


    public void movieTime() {
        System.out.printf("%nTime duration of %s: ", this.getName());
        utility.runTime(this.getRunTime());
    }

    @Override
    public int getTotalTime(){
      return this.runTime;
    };

    /**
     * Method Overrrided
     * @return a string format with relevants Movie atributes;
     * @Deprecated for the overrided method "prinInfo" from Title Class
     */
    @Override
    public String toString() {
        return String.format(
                "id: %d | %s | Year: %d| category: %s\n",
                getId(), getName(), getReleaseYear(), getCategory()
        );
    }

    @Override
    public void printInfo(){
        System.out.printf("id: %d | %s | Year: %d| category: %s%n",
                getId(), getName(), getReleaseYear(), getCategory());
    }

    public int orderMovie(Movie compare){
        return this.getName().compareTo(compare.getName());
    }

}

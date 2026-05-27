package screenmatch.models;

import screenmatch.services.record.MovieData;

public class Movie extends Title {

    private int runTime;
    private String leadActor;
    private String director;
    private String category;
    private boolean watched;


    private Movie(String name, int releaseYear) {
        super(name, releaseYear);
        watched = false;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }


    @Override
    public String toString() {
        return "O FILME É: " + getName()
                + " | Com ano de lançamento: "
                + getReleaseYear() +
                " | Assistido: " + isWatched();
    }

    public static Movie create(String name, int releaseYear){
        return new Movie(name, releaseYear);
    }

    public static Movie fromData(MovieData data){
        Movie movie = create(data.title(), data.year());

        movie.setDirector(data.director());
        movie.setCategory(data.genre());

        return movie;
    }

}

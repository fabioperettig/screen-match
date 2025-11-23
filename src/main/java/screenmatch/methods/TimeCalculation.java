package screenmatch.methods;
import screenmatch.models.Movie;
import screenmatch.models.Serie;
import screenmatch.models.Title;

public class TimeCalculation {

    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

    public void inputTime(Title title){
        if ()
        this.totalTime += movie.getRunTime();
    }

    public void inputTime(Serie serie){
        this.totalTime += (serie.getAverageTime()*serie.getEpisodesPerSeason()*serie.getSeasons());
    }
}
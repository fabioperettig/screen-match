package screenmatch.models;

public class Serie extends Title{

    private int episodesPerSeason;
    private int averageTime;
    private int seasons;
    private boolean complete;


    //ctor
    public Serie(String name, int releaseYear, int seasons) {
        super(name, releaseYear);
        this.seasons = seasons;
    }

    //getterSetter
    public int getSeasons() {
        return seasons;
    }
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }
    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }
    public int getAverageTime() {
        return averageTime;
    }
    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public void totalEpisodes(){
        int totalEp = this.episodesPerSeason * this.seasons;
        System.out.printf("Total episodes: %d",totalEp);
    }

}
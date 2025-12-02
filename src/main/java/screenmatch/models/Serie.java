package screenmatch.models;

public class Serie extends Title{

    private int episodesPerSeason;
    private int minutesEp;
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
        return minutesEp;
    }
    public void setAverageTime(int minutesEp) {
        this.minutesEp = minutesEp;
    }

    public void totalEpisodes(){
        int totalEp = this.episodesPerSeason * this.seasons;
        System.out.printf("Total episodes: %d",totalEp);
    }

    @Override
    public int getTotalTime() {
        return this.getSeasons() * this.getEpisodesPerSeason() * this.getAverageTime();
    }

    @Override
    public void printInfo() {
        System.out.printf("id: %d | %s | Year: %d| seasons: %s%n",
                getId(), getName(), getReleaseYear(), getSeasons());
    }
}
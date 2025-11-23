package screenmatch.models;

public class Movie {

    private String name;
    private int releaseYear;
    private boolean onPlan;
    private double rating;
    private int totalVotes;
    private int runTime;



    //getterSetter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public boolean isOnPlan() {
        return onPlan;
    }
    public void setOnPlan(boolean onPlan) {
        this.onPlan = onPlan;
    }
    public static double getRating() {
        return rating;
    }
    public static void setRating(double rating) {
        Movie.rating = rating;
    }
    public static int getTotalVotes() {
        return totalVotes;
    }
    public static void setTotalVotes(int totalVotes) {
        Movie.totalVotes = totalVotes;
    }
    public int getRunTime() {
        return runTime;
    }
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    /**
     * Created to receive a user rate, increase it on {@link #rating}
     * value, and increase the {@link #totalVotes} value;
     *
     * @param rate determined for the user;
     */
    public void rate(double rate){
        this.rating += rate;
        this.totalVotes ++;
    }

    public void averageRating(){
        System.out.printf("Rate: %.2f", this.rating/this.totalVotes);
    }

}

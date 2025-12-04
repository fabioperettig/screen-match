package screenmatch.models;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class Title implements Comparable<Title> {

    private static int counterID = 100; //Reference for id starts at 101
    private final int id;

    @SerializedName("Title")
    private String name;

    @SerializedName("Year")
    private int releaseYear;
    private boolean onPlan;
    private double rating;
    private int totalVotes;
    private int minutes;

    //ctor
    public Title(String name, int releaseYear) {
        this.id = counterID ++;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    //getterSetter

    public int getId() {
        return id;
    }
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
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getTotalVotes() {
        return totalVotes;
    }
    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
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
        System.out.printf("%nRate: %.2f", this.rating/this.totalVotes);
    }

    //It will be deprecated soon
    public int getTotalTime(){
        return 0;
    }


    @Override
    public int compareTo(Title compare) {
        return this.getName().compareTo(compare.getName());
    }

    public String printInfo(){
        return String.format("id: %d | title: %s%n", id, name);
    }

    /*
    public void printInfo() {
        System.out.printf("id: %d | title: %s%n", id, name);
    }*/
}
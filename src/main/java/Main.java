import screenmatch.models.Movie;

public class Main {

    public static void main(String[] args) {

        Movie m1 = new Movie("Toy Story", 1991, "Animation");
        m1.rate(2d);
        m1.rate(2.5);
        m1.rate(2.3);
        m1.rate(7.5);
        m1.setRunTime(81);

        m1.averageRating();
        m1.runTimeConvert();

    }

}
import screenmatch.models.Movie;

public class Main {

    public static void main(String[] args) {

        Movie m1 = new Movie();
        m1.setName("XXX");
        m1.setReleaseYear(2004);
        m1.rate(2d);

        m1.rate(2.5);
        m1.rate(2.3);
        m1.rate(7.5);


        m1.averageRating();

    }

}
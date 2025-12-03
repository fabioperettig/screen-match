package screenmatch.methods;
import screenmatch.models.Movie;
import screenmatch.models.Serie;
import screenmatch.models.Title;

public class Utility {

    /**
     * Converts the movie runtime (in minutes), following the standard breakdown:
     * <ul>
     *     <li> Hours are calculated by integer division: {@code minutes / 60} </li>
     *     <li> Remaining minutes use the modulo operator: {@code minutes % 60} </li>
     * </ul>
     * <b>Example:</b><br>
     * If {@code runTime = 142}, then:
     * <pre>
     * hours   = 142 / 60 = 2
     * minutes = 142 % 60 = 22
     * </pre>
     * Output:
     * {@code Runtime: 2h 22min}
     *
     * This version *prints* the formatted runtime directly to the console.
     */
    public void runTime(int local){
        int hour = local/60;
        int minutes = local % 60;
        System.out.printf("%dh %dmin", hour, minutes);
    }

}
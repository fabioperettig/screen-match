package screenmatch.models;

public class Movie extends Title {

    private int runTime;
    private String leadActor;
    private String category;

    //ctor
    public Movie(String name, int releaseYear, String category) {
        super(name, releaseYear);
        this.category = category;
    }

    public int getRunTime() {
        return runTime;
    }
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

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
    public void runTimeConvert() {
        int hours = runTime / 60;
        int minutes = runTime % 60;
        System.out.printf("%nRuntime: %dh %dmin", hours, minutes);
    }
}

package screenmatch.services.record;

import com.google.gson.annotations.SerializedName;

public record OMBDMovieData(
    @SerializedName("Title") String title,
    @SerializedName("Year") int year,
    @SerializedName("Runtime")String runtime,
    @SerializedName("Genre")String genre,
    @SerializedName("Director")String director
) {
}

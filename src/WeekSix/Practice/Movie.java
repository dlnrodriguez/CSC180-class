package WeekSix.Practice;

/**
 * Created by Dylon on 8/8/2016.
 */
public class Movie {
    private String title, genre;
    private int year;
    private float rating;

    public Movie(String title, String genre, int year, float rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }
}

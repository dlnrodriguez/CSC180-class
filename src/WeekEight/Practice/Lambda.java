package WeekEight.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Dylon on 8/8/2016.
 */
public class Lambda {
    private static Movie[] movies = {
            new Movie("Raiders of the Lost Arc", "Adventure", 1981, 4.5f)
            , new Movie("Finding Dory", "Animated", 2016, 5f)
            , new Movie("Nutty Professor", "Romantic Comedy", 2000, 3.2f)
            , new Movie("The Shining", "Horror", 1980, 4.8f)
    };

    public static void main(String[] args) {
//        visitMovies(movies, new PrintTitleAndYear());
//        visitMovies(movies, movie -> System.out.println(movie.getTitle() + " x " + movie.getRating()));
//        visitMovies(getMoviesBefore(movies, 1981), movie -> System.out.println(movie.getTitle()));
//        for (Movie m : getMoviesBefore(getMoviesAfter(Arrays.asList(movies), 1981), 2016))
//            System.out.println(m.getTitle());

//        for (Movie m2 : getMoviesByLambda((m) -> m.getYear() > 1980 && m.getYear() < 2016, new MovieList(Arrays.asList(movies))))
//            System.out.println(m2.getTitle());

//        List<Movie> movieList = Arrays.asList(movies);
//        movieList.forEach(m -> System.out.println(m.getTitle()));

        System.out.println(
                Stream.of(new Movie("Raiders of the Lost Arc", "Adventure", 1981, 4.5f)
                        , new Movie("Finding Dory", "Animated", 2016, 5f)
                        , new Movie("Nutty Professor", "Romantic Comedy", 2000, 3.2f)
                        , new Movie("The Shining", "Horror", 1980, 4.8f))
                //.sorted((m1, m2) -> m1.getYear() - m2.getYear())
                //.map(m -> m.getYear())
                //.forEach(m -> System.out.println(m.toString()));
                //.reduce("", (a, b) -> a + b)
        );
    }

    static class PrintTitleAndYear implements MovieVisitor {
        @Override
        public void visit(Movie movie) {
            System.out.println(movie.getTitle() + " + " + movie.getYear());
        }
    }

    public static void visitMovies(ArrayList<Movie> movies, MovieVisitor visitor) {
        for (Movie movie : movies)
            visitor.visit(movie);
    }

    public static void printTitleAndGenre() {
        for (Movie movie : movies)
            System.out.println(movie.getTitle() + " + " + movie.getGenre());
    }

    public static ArrayList<Movie> getMoviesByLambda(Predicate<Movie> p, MovieList movies) {
        ArrayList<Movie> l = new ArrayList<>();
        for (Movie m : movies)
            if (p.test(m))
                l.add(m);
        return l;
    }

    public static ArrayList<Movie> getMoviesBefore(List<Movie> movies, int year) {
        ArrayList<Movie> l = new ArrayList<>();
        for (Movie m : movies)
            if (m.getYear() < year)
                l.add(m);
        return l;
    }

    public static ArrayList<Movie> getMoviesAfter(List<Movie> movies, int year) {
        ArrayList<Movie> l = new ArrayList<>();
        for (Movie m : movies)
            if (m.getYear() > year)
                l.add(m);
        return l;
    }
}

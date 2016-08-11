package WeekEight.Practice;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Dylon on 8/9/2016.
 */
public class MovieList implements Iterable<Movie> {
    private List<Movie> movies;

    MovieList(List<Movie> m) {
        movies = m;
    }

    @Override
    public Iterator<Movie> iterator() {
        return new MovieIterator(movies);
    }

    class MovieIterator implements Iterator<Movie> {
        private List<Movie> movies;
        private int index = 0;

        public MovieIterator(List<Movie> movies) {
            this.movies = movies;
        }

        @Override
        public boolean hasNext() {
            return index < movies.size();
        }

        @Override
        public Movie next() {
            return movies.get(++index);
        }
    }
}

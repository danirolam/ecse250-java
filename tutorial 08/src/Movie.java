/**
 * A movie with a title and a director.
 */
public class Movie {
    private final String title;
    private final String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" directed by %s", title, director);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie movie = (Movie) obj;
        return title.equals(movie.title) && director.equals(movie.director);
    }
}
/**
 * A song with a title and an artist.
 */
public class Song {
    private final String title;
    private final String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s", title, artist);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return title.equals(song.title) && artist.equals(song.artist);
    }
}
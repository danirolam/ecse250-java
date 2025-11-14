import java.util.Iterator;

public interface Playlist<E> extends Iterable<E> {
    /**
     * Adds an item to the playlist.
     * @param e the item to add
     */
    void add(E e);

    /**
     * @param index the index of the item to get
     * @return the item at the specified index
     */
    E get(int index);

    /**
     * @return the number of items in the playlist
     */
    int getSize();

    /**
     * @return an iterator over elements of type {@code E}.
     */
    Iterator<E> iterator();

    /**
     * @return an iterator that returns the items in reverse order.
     */
    Iterator<E> backwardIterator();
}
public interface SortableQueue<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Add an element to the back of the queue.
     */
    void enqueue(E element);

    /**
     * Remove and return the front element.
     */
    E dequeue();

    /**
     * Get the front element without removing it.
     */
    E peek();

    /**
     * Sort the elements in the queue in the order specified by the comparable interface.
     */
    void sort();

    /**
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * @return the number of elements in the queue.
     */
    int getSize();
}
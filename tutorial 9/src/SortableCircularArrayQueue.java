import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic circular array queue with in-place sorting capability.
 */
public class SortableCircularArrayQueue<E extends Comparable<E>> implements SortableQueue<E> {
    private static final int INITIAL_CAPACITY = 4;
    private static final int RESIZE_FACTOR = 2;

    private E[] data;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    /**
     * Create an array of type E.
     * Use this method when you need to create an array of type E.
     */
    private E[] createArray(int capacity) {
        return (E[]) new Comparable[capacity];
    }

    public SortableCircularArrayQueue(int capacity) {
        this.capacity = capacity;
        data = createArray(capacity);
        head = tail = size = 0;
    }

    public SortableCircularArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    private void resize(){
        int newCapacity = capacity * RESIZE_FACTOR;
        E[] tmp = createArray(newCapacity);

        for (int i = 0; i < size; i++) {
            tmp[i] = data[(head + i) % capacity];

        }
        tail = (head + size - 1) % newCapacity;
        data = tmp;
        capacity = newCapacity;
        head = 0;
        tail = size;


    }

    @Override
    public void enqueue(E element) {
        if (size == capacity){
            resize();
        }
        data[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");

        }
        E element = data[head];
        head = (head + 1) % capacity;
        size--;
        return element;


    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return a forward iterator
     */
    public Iterator<E> iterator() {
        return new QueueIterator();


    }
    // Use an inner class to implement iterator
    private  class QueueIterator implements Iterator<E> {
        private int count = 0;
        private int current = head;

        @Override
        public boolean hasNext() {
            return count < size;    // check if there are more elements
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E element = data[current];
            current = (current + 1) % capacity;
            count ++;
            return element;
        }
    }

    @Override
    public void sort() {
        if (size <= 0){
            return;
        }

        E[] newData = createArray(capacity);
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % capacity]; // copyt element from head to tail

        }
        data = newData;
        head = 0;
        tail = size;

        // Insertion sort
        for (int i = 1; i < size; i++) {
            E checking = data[i];    // element to insert
            int j = i-1;        // element before
            // using compare to to move element larger than the value we compare to (checking)
            while (j >= 0 && data[j].compareTo(checking) > 0) {
                data[j+1] = data[j];
                j = j-1;

            }
            data[j+1] = checking;
        }
    }

    /**
     * Display the underlying array (for debugging).
     */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * @return the capacity of the queue (for testing purposes).
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the underlying data array (for testing purposes).
     */
    public E[] getData() {
        return data;
    }
}
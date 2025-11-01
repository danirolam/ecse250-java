import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements Playlist
 * TODO: implement Playlist
 */
public class MyPlaylist<E> implements Playlist<E> {

    private final DNode dummyHead; // Dummy head node
    private final DNode dummyTail; // Dummy tail node
    private int size;

    /**
     * Constructs an empty playlist with dummy head and tail nodes.
     */
    public MyPlaylist() {
        size = 0;
        dummyHead = new DNode();
        dummyTail = new DNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * A node in the doubly linked list.
     */
    private class DNode {
        E element;
        DNode next;
        DNode prev;
    }

    /**
     * An iterator that traverses the playlist forward.
     * TODO: complete this iterator class
     */
    private class ForwardIterator implements Iterator<E> {

        private DNode currentNode;

        public ForwardIterator() {
            this.currentNode = dummyHead.next;      // current element is the one after our first dummy
        }

        @Override
        public boolean hasNext() {
            return currentNode != dummyTail;        // there is something everthing but the dummyTail
        }

        @Override
        public E next() {
            if (hasNext() == false) {
                throw new NoSuchElementException(" There is nothign beyond...");
            }

            E returnElement = currentNode.element;
            currentNode = currentNode.next;
            return returnElement;
        }


    }

    /**
     * An iterator that traverses the playlist backward.
     * TODO: complete this iterator class
     */
    private class BackwardIterator implements Iterator<E> {
        private DNode currentNode;

        public BackwardIterator() {
            this.currentNode = dummyTail.prev;       // current is the element just before the dummyTail

        }

        @Override
        public boolean hasNext() {
            return currentNode != dummyHead;
        }

        @Override
        public E next() {
            if (hasNext() == false) {
                throw new NoSuchElementException(" There is nothign beyond first element (dummyHead)...");
            }

            E returnElement = currentNode.element;
            currentNode = currentNode.prev;
            return returnElement;
        }

    }

    // TODO: implement the Playlist interface
    @Override
    public void add(E element) {
        DNode lastNode = dummyTail.prev;        // find the last node before the dummyTail

        DNode newNode = new DNode();
        newNode.element = element;

        // Make link of newNode the last node
        newNode.prev = lastNode;
        lastNode.next = newNode;

        // Make link of newNode to dummyTail
        newNode.next = dummyTail;
        dummyTail.prev = newNode;

        size++;
    }

    @Override
    public E get(int index) {
        // Check if index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DNode currentNode;

        // Optimize (if index in first half, start form start, if in second, start from tail)
        if (index < size/2){
            currentNode = dummyHead.next;
            for (int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
        }
        else{
            currentNode = dummyTail.prev;
            for (int i = size - 1; i > index; i--){
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }

    @Override
    public int getSize(){
        return this.size;

    }

    @Override
    public Iterator<E> iterator() {
        return new ForwardIterator();
    }

    @Override
    public Iterator<E> backwardIterator() {
        return new BackwardIterator();
    }
}

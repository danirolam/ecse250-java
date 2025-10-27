/**
 * Implementation of a singly linked, doubly-ended list.
 *
 * @param <T> the type of elements held in this list, e.g., {@code SinglyLinkedList<String>}
 */
public class SinglyLinkedList<T> {
    /**
     * A node in the singly linked list.
     *
     * @param <T> the type of element held in the node
     */
    private static class Node<T> {
        /**
         * The element stored in this node.
         */
        T element;

        /**
         * The reference to the next node in the list.
         */
        Node<T> next;
    }

    /**
     * The head (first node) of the list.
     */
    private Node<T> head;

    /**
     * The tail (last node) of the list. Having it allows for O(1) addLast operations.
     */
    private Node<T> tail;

    /**
     * The number of elements in the list. Having it allows for O(1) size operations.
     */
    private int size;

    /**
     * Constructor.
     * The head and tail will be {@code null} and size will be zero.
     */
    public SinglyLinkedList() {}

    /**
     * @return the current size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Add the specified element at the beginning of the list.
     *
     * @param e the element to add.
     */
    public void addFirst(T e) {
        Node<T> newNode = new Node<T>();
        newNode.element = e;
        newNode.next = head;

        head = newNode;
        size++;

        if (size == 1){
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        String msg = "";
        Node<T> node = head;
        for (int i = 0; i < size; i ++){
            msg += node.element + ", ";
            node = node.next;
        }
        return msg;
    }

    /**
     * Add the specified element to the end of the list.
     *
     * @param e the element to add.
     */
    public void addLast(T e) {

        Node<T> newNode = new Node<>();
        newNode.element = e;

        if (size == 0){
            head = newNode;
        }
        else  {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    /**
     * Remove and return the first element from the list.
     *
     * @return the element previously at the head of the list.
     * @throws IllegalStateException if the list is empty
     */
    public T removeFirst() throws IllegalStateException {

        if (size == 0){
            tail = null;
            throw new IllegalStateException("There is nothing to remove in an empty list...");
        }


        // Store the element we are deleting
        T element_deleted = head.element;
        head = head.next;
        size --;
        return element_deleted;

    }

    /**
     * Return the element at the specified position in the list.
     *
     * @param i index of the element to return.
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException if {@code i} is out of range.
     */
    public T get(int i) throws IndexOutOfBoundsException {

        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Out of Bounds");

        }
        Node<T> node = head;
        for (int j = 0; j < i; j++){
            node = node.next;
        }
        return node.element;

    }
}
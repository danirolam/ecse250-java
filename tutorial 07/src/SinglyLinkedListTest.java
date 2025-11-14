import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @BeforeEach
    public void testAddFirst() {
        try {
            SinglyLinkedList<String> list = new SinglyLinkedList<>();

            try {
                list.addFirst("League of Legends");
                list.addFirst("World of Warcraft");
                list.addFirst("The Legend of Zelda");
            } catch (Exception e) {
                fail("addFirst() method failed. Tests won't be run before all prerequisites are implemented.", e);
            }

            assertEquals("The Legend of Zelda, World of Warcraft, League of Legends, ", list.toString(),
                    "addFirst(): The printed list does not match the expected output. " +
                            "Tests won't be run before all prerequisites are implemented.");
            assertEquals(3, list.getSize(),
                    "addFirst(): The size of the list does not match the expected value." +
                            "Tests won't be run before all prerequisites are implemented.");
        } catch (Exception e) {
            fail("constructor failed. Tests won't be run before all prerequisites are implemented.", e);
        }
    }

    @Test
    @Tag("score:1")
    public void testAddLast() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("League of Legends");
        list.addLast("World of Warcraft");
        list.addLast("The Legend of Zelda");

        assertEquals("League of Legends, World of Warcraft, The Legend of Zelda, ", list.toString(),
                "The printed list does not match the expected output. ");

        assertEquals(3, list.getSize(),
                "The size of the list does not match the expected value.");
    }

    @Test
    @Tag("score:1")
    public void testRemoveFirst() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("League of Legends");
        list.addFirst("World of Warcraft");
        list.addFirst("The Legend of Zelda");


        assertEquals("The Legend of Zelda", list.removeFirst(),
                "1st call: The removed element does not match the expected value.");

        assertEquals("World of Warcraft", list.removeFirst(),
                "2nd call: The removed element does not match the expected value.");

        assertEquals("League of Legends", list.removeFirst(),
                "3rd call: The removed element does not match the expected value.");

        assertThrows(IllegalStateException.class, list::removeFirst,
                "4th call: Expected IllegalStateException to be thrown, but it was not.");
    }

    @Test
    @Tag("score:1")
    public void testGet() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.addFirst("League of Legends");
        list.addFirst("World of Warcraft");
        list.addFirst("The Legend of Zelda");

        assertEquals("The Legend of Zelda", list.get(0),
                "get(0): The retrieved element does not match the expected value.");

        assertEquals("World of Warcraft", list.get(1),
                "get(1): The retrieved element does not match the expected value.");

        assertEquals("League of Legends", list.get(2),
                "get(2): The retrieved element does not match the expected value.");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3),
                "get(3): Expected IndexOutOfBoundsException to be thrown, but it was not.");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1),
                "get(-1): Expected IndexOutOfBoundsException to be thrown, but it was not.");
    }
}
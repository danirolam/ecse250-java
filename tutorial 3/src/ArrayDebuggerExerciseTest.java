import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ArrayDebuggerExerciseTest {
    @Test
    @Tag("score:1")
    void testGetFirstLongestString() {
        // Create an array of Strings. Each element in the array is one String value.
        // Arrays in Java use { } for fast initialization, and commas to separate values.
        String[] myStringArray = {
                "abcd",   // element at index 0
                "efg",  // element at index 1
                "hi", // element at index 2
        };

        // Call the method GetLongestString() and pass the array to it.
        // The method is supposed to return the longest string from the array, which we store in `longestString`.
        String longestString = ArrayDebuggerExercise.GetLongestString(myStringArray);

        // assert that the returned value should be "abcd"
        assert longestString.equals("abcd");
    }
}

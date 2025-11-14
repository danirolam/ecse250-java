import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

public class Tutorial03Test {
    @Test
    @Tag("score:1")
    void testStringToInt_baseCases() {
        assertArrayEquals(
            new int[]{13, 15, 17},
            ConvertArray.stringToInt(new String[]{"13", "15", "17"})
        );
        assertArrayEquals(
            new int[]{12, 25},
            ConvertArray.stringToInt(new String[]{" 12", " 25"})
        );
        assertArrayEquals(
            new int[]{},
            ConvertArray.stringToInt(new String[]{})
        );
    }

    @Test
    @Tag("score:1")
    void testStringToInt_exceptions() {
        assertThrows(NumberFormatException.class,
            () -> ConvertArray.stringToInt(new String[]{"1", "#", " 2 ", " 2.2 "})
        );
        assertThrows(NumberFormatException.class,
            () -> ConvertArray.stringToInt(new String[]{""})
        );
        assertThrows(IllegalArgumentException.class,
            () -> ConvertArray.stringToInt(new String[]{"-1", "2"})
        );
    }

    @Test
    @Tag("score:1")
    void testTryConvert() {
        assertArrayEquals(
            new int[]{13, 15, 17},
            ConvertArray.tryConvert(new String[]{"13", "15", "17"})
        );
        assertArrayEquals(
            new int[]{ -100, -100, -100, -100 },
            ConvertArray.tryConvert(new String[]{"1", "#", " 2 ", " 2.2 "})
        );
    }
}

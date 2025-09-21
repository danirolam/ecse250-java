/**
 * This is a small program written to help you practice arrays and debugging Java code.
 * Some logic within the code is intentionally incorrect, and our task is to find and fix the issues.
 */
public class ArrayDebuggerExercise {
    /**
     * This method is intended to loop through the stringArray and find the longest string.
     * @param stringArray an array that contains multiple strings.
     * @return the string with the greatest length from the array.
     */
    public static String GetLongestString(String[] stringArray) {
        // Initialize variables:
        // `arrayIndex` keeps track of which element in the array we are looking at.
        int arrayIndex = 0;
        // `longestString` will eventually hold the longest string found. For now it is set to null (which means "no value").
        String longestString = null;

        // Loop through the array using a while loop.
        // Reminder: arrays use indexes from 0 up to (length - 1). If length = 2, valid indexes are 0 and 1.
        while (arrayIndex <= stringArray.length) {
            // Access the string at the current index.
            String currentString = stringArray[arrayIndex];

            // Compare the length of the current string with the longest so far.
            if (currentString.length() > longestString.length()) {
                // If the current string is longer, return the currentString.
                return currentString;
            }

            // Move to the next index.
            arrayIndex++;
        }

        // Return the longest string found.
        return longestString;
    }
}
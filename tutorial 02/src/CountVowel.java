/**
 * This is a small program written to help you practice conditions, loops, and debugging Java code.
 * Some logic within the code is intentionally incorrect, and our task is to find and fix the issues.
 */
public class CountVowel {
    /**
     *  public static void main(String[] args) is the entry point of a Java application.
     *  This is where the program starts executing.
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create a test string. Reminder that a string is also a sequence of characters.
        String test = "Albert Einstein";

        // Call the method CountVowels and pass the string into it.
        // The method is supposed to return the number of vowels in the string.
        int result = GetNumberOfVowels(test);

        // "apple" contains 2 vowels: 'a' and 'e'
        // print the returned value from the method to the console.
        System.out.println("'" + test + "' contains " + result + " vowels.");
    }

    /**
     * This method is intended to loop through the string and count how many vowels it contains.
     * Vowels are the characters a, e, i, o, u (case-insensitive).
     * @param str the input string
     * @return the number of vowels in the string
     */
    public static int GetNumberOfVowels(String str) {
        // Initialize variables:
        // `vowelCount` will hold the number of vowels found so far.
        int vowelCount = 0;

        // Loop through the string using a for loop.
        // Reminder: valid indexes go from 0 up to (length - 1).
        for (int i = 0; i < str.length(); i++) {
            // Access the character at the current index.
            // For example, if i is 0, this gets the first character.
            char c = Character.toLowerCase(str.charAt(i)); // Count capital letters too

            // Check if the character is a vowel.
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                // If the character is a vowel, increase the count.
                vowelCount++;
                System.out.println(c);
            }
        }

        // Return the total number of vowels found.
        return vowelCount;
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

     */

    @Test
    public void testWordToDeque() {
        Deque d = Palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String origin1 = "a";
        assertTrue("the method has error for a", Palindrome.isPalindrome("a"));

        String origin2 = "";
        assertTrue("the method has error for empty string", Palindrome.isPalindrome(""));

        String origin3 = "racecar";
        assertTrue("the method has error for racecar", Palindrome.isPalindrome("racecar"));

        String origin4 = "aaaaab";
        assertFalse("the method has error for aaaaab", Palindrome.isPalindrome("aaaaab"));
    }

    @Test
    public void testOverloadIsPalindrome() {
        String origin1 = "a";
        CharacterComparator cc = new OffByOne();
        assertTrue("the method has error for a", Palindrome.isPalindrome(origin1, cc));

        String origin2 = "";
        assertTrue("the method has error for empty string", Palindrome.isPalindrome(origin2, cc));

        String origin3 = "flake";
        assertTrue("the method has error for flake", Palindrome.isPalindrome(origin2, cc));

    }
}

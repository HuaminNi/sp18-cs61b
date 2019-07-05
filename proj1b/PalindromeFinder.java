/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/library-sp18/data/words.txt");
        In in2 = new In("../library-sp18/library-sp18/data/words.txt");
        In in3 = new In("../library-sp18/library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByOne();
        CharacterComparator cc2 = new OffByN(5);

        /** find palindrome */
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        /** find off-by-one palindrome */
        while (!in2.isEmpty()) {
            String word = in2.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }

        /** find off-by-five palindrome */
        while (!in3.isEmpty()) {
            String word = in3.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc2)) {
                System.out.println(word);
            }
        }
    }
}

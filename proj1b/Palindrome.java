public class Palindrome {

    /** transfer the string to a list of characters */
    public static Deque<Character> wordToDeque(String word) {
        // use an empty dllist to load the characters//
        Deque<Character> characters = new LinkedListDeque<>();
        for (int i = 0; i < word.length();i++) {
            char solo = word.charAt(i);
            characters.addLast(solo);
        }
        return characters;
    }


    /** check the string to see if it is palindrome */
    //the recommended solution is recursion. However, I do not have enough time to figure out how to implement
    //by this method. So I offered below method.
    public static boolean isPalindrome(String word) {
        Deque<Character> string = Palindrome.wordToDeque(word);
        flag = true;
        if (string.size() == 0 || string.size() ==1) {
            return flag;
        } else {
            while (string.size() > 1) {
                char f = string.removeFirst();
                char l = string.removeLast();
                if (f == l) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            return flag;
        }


    }

    /** overload */
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> string = Palindrome.wordToDeque(word);
        flag = true;
        if (string.size() == 0 || string.size() ==1) {
            return flag;
        } else {
            while (string.size() > 1) {
                char f = string.removeFirst();
                char l = string.removeLast();
                if (cc.equalChars(f,l)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

    }
    private static boolean flag = true;

}

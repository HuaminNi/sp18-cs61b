import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();*/

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. //
    //currently I do not test the capital letters and will add here later//
    @Test
    public void testEqualChars() {
        char origin1 = 'a';
        char origin2 = 'b';
        char origin3 = 'e';
        char origin4 = 'A';
        OffByOne text =  new OffByOne();
        assertTrue("the method reports an error", text.equalChars(origin1, origin2));
        assertFalse("the method reports an error", text.equalChars(origin1, origin3));
        assertFalse("the method reports an error", text.equalChars(origin1, origin4));
    }

}

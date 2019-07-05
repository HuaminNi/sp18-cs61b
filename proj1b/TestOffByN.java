import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    @Test
    public void testOffByN() {
        OffByN first = new OffByN(5);
        assertTrue("report error", first.equalChars('a','f'));
        assertTrue("report error", first.equalChars('f','a'));
        assertFalse("report error", first.equalChars('f','h'));
    }

}

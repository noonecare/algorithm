import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by T440P on 2017/9/13.
 */
public class RandomizedSelectTest extends TestCase {
    @Test
    public void testRandomizedSelect() throws Exception {
        int a[] = {1, 4, 2, 30, 28, 29, 57};
        assertEquals(RandomizedSelect.randomizedSelect(a, 0, a.length - 1, 3), 4);
    }

}
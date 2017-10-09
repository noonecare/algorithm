import junit.framework.TestCase;

/**
 * Created by T440P on 2017/9/10.
 */
public class CountingSortTest extends TestCase {
    public void testCountingSort() {
        int[] a = {12, 3, 72, 1, 5, 20, 92};
        int[] b = new int[a.length];
        int k = 93;
        CountingSort.countingSort(a, b, k);
        int[] expectedResult = {1, 3, 5, 12, 20, 72, 92};
        for (int i=0; i<b.length; i++)
        {
            assert(b[i] == expectedResult[i]);
        }
    }
}
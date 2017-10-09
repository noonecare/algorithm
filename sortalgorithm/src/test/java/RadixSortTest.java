import junit.framework.TestCase;

/**
 * Created by T440P on 2017/9/10.
 */
public class RadixSortTest extends TestCase {

    public void testRadixSort() {
        // 测试 RadixSort

        int[][] A = {{1, 2, 3}, {1, 3, 2},
                {2, 3, 1}, {3, 1, 2}, {3, 2, 1}, {2, 1, 3}};

        RadixSort.radixSort(A, 3, 4);


        int[][] expectedResult = {{3, 2, 1}, {2, 3, 1}, {3, 1, 2}, {1, 3, 2}, {2, 1, 3}, {1, 2, 3}};

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                assert (A[i][j] == expectedResult[i][j]);
            }
        }
    }
}
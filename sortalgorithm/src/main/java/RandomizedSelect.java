/**
 * Created by T440P on 2017/9/13.
 */
public class RandomizedSelect {




    static public int randomizedSelect(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }

        int q = QuickSort.randomizedPartition(A, p, r);

        int k = q - p + 1;
        if (i == k) {
            return A[q];
        } else {
            if (i < k) {
                return randomizedSelect(A, p, q - 1, i);
            } else {
                return randomizedSelect(A, q + 1, r, i - k);
            }
        }
    }
}

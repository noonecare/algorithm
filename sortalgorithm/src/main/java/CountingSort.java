/**
 * Created by T440P on 2017/9/10.
 */

interface KeyAndSatlite {
    int getKey();
}


public class CountingSort {
    /**
     * 这里和算法导论书中略有不同，我这里是自然数，数组从0开始计数。算法导论书中，是正整数，数组从 1 开始计数
     *
     * @param A 待排序的序列
     * @param B 存放排序结果的序列
     * @param k A 中的数是自然数，正整数的上界是 k - 1
     */
    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        for (int i = 0; i < k; i++) {
            if (i != 0) {
                C[i] = C[i] + C[i - 1];
            }
        }

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }


    // Stable 只有在带 Satlite 数据时，才能感受出 countingSort 是 stable 的
    public static void countingSortWithSatlite(KeyAndSatlite[] A, KeyAndSatlite[] B, int k) {
        int[] C = new int[k];
        for (int j = 0; j < A.length; j++) {
            C[A[j].getKey()] = C[A[j].getKey()] + 1;
        }

        for (int i = 0; i < k; i++) {
            if (i != 0) {
                C[i] = C[i] + C[i - 1];
            }
        }
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j].getKey()] - 1] = A[j];
            C[A[j].getKey()] = C[A[j].getKey()] - 1;
        }
    }
}

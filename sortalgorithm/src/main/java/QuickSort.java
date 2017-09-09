/**
 * 实现快排算法，下面的命名采用算法导论中文版的命名。
 */
public class QuickSort {

    public static void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i += 1;
                exchange(A, i, j);
            }
        }
        exchange(A, i + 1, r);
        return i + 1;
    }

    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }
}

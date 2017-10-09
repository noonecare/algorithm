/**
 * Created by T440P on 2017/9/10.
 */

class ArrayKeyAndSatilite implements KeyAndSatlite {
    private int k;
    private int[] a;

    public ArrayKeyAndSatilite(int[] a, int k) {
        this.a = a;
        this.k = k;
    }

    public int getKey() {
        return this.a[this.k];
    }

    public int[] getSatilite() {
        return this.a;
    }
}

public class RadixSort {


    public static void radixSort(int[][] A, int d, int k) {
        int length = A.length;
        ArrayKeyAndSatilite[] B = new ArrayKeyAndSatilite[length];
        ArrayKeyAndSatilite[] temp = new ArrayKeyAndSatilite[length];


        for (int i = 0; i < d; i++) {
            // use a stable sort to sort array A on digit i.
            // countingSort 是 stable 的，所以这里用 countingSort 去实现 raidxSort
            // stable 稳定的： 具有相同值的元素在输出数组中相对次序与他们在输入数组中的相对次序相同
            for (int j = 0; j < length; j++) {
                temp[j] = new ArrayKeyAndSatilite(A[j], i);
            }
            CountingSort.countingSortWithSatlite(temp, B, k);
            // 把 B 中得到的数值写进 A 中
            for (int j = 0; j < length; j++) {
                A[j] = B[j].getSatilite();
            }
        }

    }
}

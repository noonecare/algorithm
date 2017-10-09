import java.util.LinkedList;

/**
 * Created by T440P on 2017/9/10.
 */
public class BucketSort {
    public static void bucketSort(float[] A)
    {
        int n = A.length;
        LinkedList<Float>[] a = new LinkedList[n];

        for (int i=0; i < n; i++)
        {
            a[(int)(A[i] * n)].addLast(A[i]);
        }

        for (int i=0; i < n; i++)
        {
            //insertSort(a[i]);
        }



    }
}

/**
 * Created by T440P on 2017/10/6.
 */
public class OptimalBST {
    public static void optimalBST(int[] p, int[] q, int n) {
        int[][] e = new int[1 + n][1 + n];
        int[][] w = new int[1 + n][1 + n];
        int[][] root = new int[n][n];

        for (int i=0; i<=n+1; i++) {
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }

        for (int l=1; l<=n; l++) {

        }
    }
}

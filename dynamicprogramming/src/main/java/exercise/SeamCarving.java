package exercise;

/**
 * 15-8
 * A 是所有 seam 组成的集合，
 * 从 A 中找出所有 满足 (a_1, a_2...a_m) 中 a_1 最小的序列，这样的子集B一共有 k 个
 * 对于任何 B 中的序列，(a_2, ...a_m, a_1)...(a_m, a_1, ...a_{m-1}) 也都是 stream
 * 中上所述，一共有 m^{k} 个 stream.
 */


public class SeamCarving {
    public static int seamCarving(int[][] d) {
        // 算法非常简单，就是算出以特点点为起点的所有 stream 中最小的 stream
        int m = d.length;
        int n = d[0].length;
        int[][] w = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    w[i][j] = d[i][j];
                } else {
                    for (int k = Math.max(0, j - 1); k <= j + 1; k++) {
                        int q = Integer.MIN_VALUE;
                        if (w[i - 1][k] > q) {
                            q = w[i - 1][k];
                        }
                        w[i][j] = q + d[i][j];
                    }
                }
            }
        }
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (w[m - 1][i] > q) {
                q = w[m - 1][i];
            }
        }
        return q;
    }
}

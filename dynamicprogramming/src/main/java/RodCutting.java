import static java.lang.Math.max;

/**
 * 相对于递归，dynamicProgramming 把中间结果保存了起来，避免重复计算，从而提高了效率。
 * dynamicProgramming 是一种用存储空间换运算时间的算法。
 */
public class RodCutting {
    /**
     * 直接递归，很容易理解，但是计算机通常会算的比较慢
     * @param p i 英尺的钢管对应 p[i] 元
     * @param n 一共有 n 英尺的钢管
     * @return 可以得到的最大价格
     */
    public static int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = max(q, p[i] + cutRod(p, n - i));
        }
        return q;
    }

    /**
     * 感觉 bottomUpCutRod 是最简洁的写法
     * @param p
     * @param n
     * @return
     */
    public static int bottomUpCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int j=1; j<=n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i=1; i<=j; i++) {
                q = max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];
    }

    /**
     * topBottom 方式写 cutRod,
     * 写起来不简洁，但是比较容易想到
     */
    public static int memoizedCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        for (int i=0; i<=n; i++)
        {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedCutRodAux(p, n, r);
    }

    public static int memoizedCutRodAux(int[] p, int n, int[] r) {
        if ( r[n] >= 0 ) {
            return r[n];
        }
        int q = 0;
        if ( n != 0 ) {
            q = Integer.MIN_VALUE;
            for (int i=1; i<=n; i++) {
                q = max(q, p[i] + memoizedCutRodAux(p, n - i, r));
            }
            r[n] = q;
        }
        return q;
    }

    public static int[][] extendedBottomUpCutRod(int[] p, int n) {
        int h[][] = {new int[n + 1], new int[n+1]};

        int r[] = h[0];
        int s[] = h[1];
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i=1; i<=j;i++) {
                if ( q < p[i] + r[j - i] ) {
                    q = p[i] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        return h;
    }

    public static void printCutRodSolution(int[] p, int n) {
        int[][] h = extendedBottomUpCutRod(p, n);
        int[] r = h[0];
        int[] s = h[1];
        while (n > 0) {
            System.out.println(s[n]);
            n = n - s[n];
        }
    }


    public static void main(String[] args) {
        int p[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(bottomUpCutRod(p, 4));
        System.out.println(cutRod(p, 4));
        System.out.println(memoizedCutRod(p, 4));
        printCutRodSolution(p, 4);
    }
}

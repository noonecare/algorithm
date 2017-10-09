package exercise;

/**
 * 15.1-3
 */
public class RodCutingWithCost {
    /**
     *
     * @param p
     * @param n
     * @param cost 每次切割需要花费 cost 元
     * @return
     */
    public static int RodCutWithCost(int[] p, int n, int cost) {
        int[] r = new int[n+1];
        for (int i=0; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            int j=1;
            for (; j<= i - 1; j++) {
                q = Math.max(q, p[j] + r[i - j] - cost);
            }
            j += 1;
            q = Math.max(q, p[j]);
            r[i] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {
    }
}

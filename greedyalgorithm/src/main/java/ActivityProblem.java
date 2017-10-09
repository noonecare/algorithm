/**
 * Created by T440P on 2017/10/7.
 */
public class ActivityProblem {
    // A 是用来保存结果的
    // 这里假设 f （结束时间）是按照从小到大排列好的
    public static int greedyActivitySelector(int[] s, int[] f, int[] A)
    {
        int n = s.length;
        int valid = 0;
        A[0] = 0;
        int k = 0;
        for (int m = 1; m <n; m++) {
            if ( s[m] >= f[k] )
            {
                valid += 1;
                A[valid] = m;
                k = m;
            }
        }
        return valid;
    }
}

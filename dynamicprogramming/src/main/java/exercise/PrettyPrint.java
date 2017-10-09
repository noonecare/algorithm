package exercise;

/**
 * Created by T440P on 2017/10/6.
 */
public class PrettyPrint {

    // 如果返回值为 right + 1, 表示， l[left..right] 中的所有字符都可以放到一行中
    // 否则，表示 l[left..result] 可以放在一行中，l[left..right+1] 不能放在一行中
    public static int inALine(int[] l, int left, int right, int M) {
        int i = left;
        int sum = -1;
        for (; i <= right; i++) {
            sum += l[i] + 1;
            // 最后的换行符相当于是个空格
            if (sum > M) {
                break;
            }
        }
        // 如果 i == right + 1 表示所有字符加起来也没有超过一行，如果 i < right + 1 表示 加到 i 时，已经超过了一行。
        return i;
    }

    public static int calculateError(int[] l, int left, int right, int M) {
        int sum = 0;
        for (int i=left; i<=right;i++) {
            sum += l[i];
        }
        int error = M - right + left - sum;
        return error * error * error;
    }

    public static int prettyPrint(int[] l, int M) {
        int length = l.length;

        // 第一行的切分点
        int[] cutLines = new int[length];
        int[] errorSquares = new int[length];

        for (int k = 1; k <= length; k++) {
            int left = length - k;
            int i = inALine(l, left, length - 1, M);
            if (i == length ) {
                cutLines[left] = length - 1;
                errorSquares[left] = 0;
            } else {
                int q = Integer.MAX_VALUE;
                for (int j= i - 1; j >=left; j--) {
                    int error = calculateError(l, left, j, M);
                    error += errorSquares[j + 1];
                    if (q > error) {
                        q = error;
                        cutLines[left] = j;
                        errorSquares[left] = q;
                    }
                }
            }
        }
        return cutLines[0];

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 4, 2, 7, 1, 3};
        int M = 20;
        System.out.println(prettyPrint(a, M));
        System.out.println(inALine(a, 0, a.length - 1, M));
        System.out.println(calculateError(a, 0, inALine(a, 0, a.length - 1, M) - 1, M));

    }
}

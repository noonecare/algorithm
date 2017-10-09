package exercise;

/**
 * 给出最长回文子字符串
 * 15-2 的答案
 * 时间复杂度为：
 */

class Result {
    public int start;
    public int length;

    public Result(int start, int length) {
        this.start = start;
        this.length = length;
    }
}

public class Palindrome {

    /**
     * @param query  输入的字符串
     * @param length query 包含的字符数
     * @return 从 query 的最开头开始的最长回文字符串
     */
    public static int maxStartPalindrome(String query, int length) {
        for (; length >= 1; length--) {
            int halfLength = length / 2;
            int j = 0;
            for (; j < halfLength; j++) {
                if (query.charAt(j) != query.charAt(length - j - 1)) {
                    break;
                }
            }
            if (j == halfLength) {
                break;
            }
        }
        return length;
    }

    public static Result maxPalindrome(String query) {
        int length = query.length();

        Result[] results = new Result[length];

        for (int i = 1; i <= length; i++) {
            if (i == 1) {
                results[i - 1] = new Result(length - 1, i);
            } else {
                int lastStart = results[i - 2].start;
                int lastLength = results[i - 2].length;

                int startLength = maxStartPalindrome(query.substring(length - i), i);
                if (startLength > lastLength) {
                    results[i - 1] = new Result(length - i, startLength);
                } else {
                    results[i - 1] = new Result(lastStart, lastLength);
                }
            }
        }
        return results[length - 1];
    }

    public static void prettyPrint(Result result, String query) {
        int length = result.length;
        int start = result.start;
        System.out.println(query.substring(start, start + length));
    }

    public static void main(String[] args) {
        String[] testQueries = {"civic", "racecar", "aibohphobia", "character"};
        for (String query : testQueries) {
            System.out.println(query.substring(0, maxStartPalindrome(query, query.length())));
            prettyPrint(maxPalindrome(query), query);
        }
    }
}

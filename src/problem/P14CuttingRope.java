package problem;

/**
 * Title: 剪绳子
 * Desc: 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1) (m 并不是指定的)
 * 每段绳子的长度记为 k[0],k[1],...,k[m-1]. 请问 k[0]*k[1]*...*k[m-1]可能的最大乘积是多少？
 * Created by Myth on 5/12/2019
 */
public class P14CuttingRope {
    // 贪心解法
    public static int greedySolution(int n) {
        // n > 5时，尽可能多的 分割成长度为 3 的段儿
        if (n <= 1) return 0;
        if (n == 2 || n == 3) return n;
        int ret = 1;
        while(n > 4) {
            n -= 3;
            ret *= 3;
        }
        return ret * n;
    }
    // TODO: 动态规划解法
    public int dpSolution(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(P14CuttingRope.greedySolution(8));
    }
}

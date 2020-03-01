package problem;

/**
 * Title: 60. n 个骰子的点数
 * Desc: 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s，输入 n，打印出 s 的所有可能的值出现的概率
 * Created by Myth on 7/12/2019
 */
public class P60DicesProbability {
    // 
    public double[] twoSum(int n) {
        //  1*n <= s <= 6*n
        double all = Math.pow(6, n);
        int m = 6*n;
        double[] ret = new double[5*n+1];
        int[] dp = new int[6*n];
        for (int i = 1; i < 6; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 6*n; j > 0; j--) {
                int sum = 0;
                for (int k = 1; k <= 6 && k <= j; k++) {
                    sum = sum + dp[j-k];
                }
                dp[j] = sum;
            }
        }
        for (int i = n; i <= m; i++) {
            ret[i-n] = dp[i] / all; 
        }
        return ret;
    }
    public static void main(String[] args) {
        P60DicesProbability p60 = new P60DicesProbability();
        p60.twoSum(2);
    }
}

package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 60. n 个骰子的点数
 * Desc: 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s，输入 n，打印出 s 的所有可能的值出现的概率
 * Created by Myth on 7/12/2019
 */
public class P60DicesProbability {
    // DP
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
        //  1*n <= s <= 6*n
        for (int i = n; i <= m; i++) {
            ret[i-n] = dp[i] / all; 
        }
        return ret;
    }
    // 记忆化递归(注意备忘录里面存的是什么东西)
    Map<String, Integer> mem = new HashMap<>();
    public double[] twoSum2(int n) {
        int m = 6*n;
        double all = Math.pow(6, n);
        double[] ret = new double[5*n+1];
        
        for (int i = 1; i <= 6; i++) {
            mem.put("1"+i, 1);
        }
        for (int i = n; i <= m; i++) {
            ret[i-n] = helper(n, i) / all; 
        }
        return ret;
    }
    // n个骰子，m点
    private int helper(int n, int m){
        if(m < n || m < 0|| n < 0) return 0;
        if(m == 0 && n == 0) return 1;
        String key = Integer.toString(n)+Integer.toString(m);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += helper(n-1, m-i);
        }
        mem.put(key, sum);
        return sum;
    }
    public static void main(String[] args) {
        P60DicesProbability p60 = new P60DicesProbability();
        System.out.println(Arrays.toString(p60.twoSum2(2)));
    }
}

package problem;

/**
 * Title: 46. 把数字翻译成字符串
 * Desc:
 * Created by Myth on 6/23/2019
 */
public class P46TranslateNumber {
    // 
    public int translateNum(int num) {
        if (num < 10) return 1;
        if (num <= 25) return 2;
        String str = String.valueOf(num);
        int dp0, dp1, cur;
        dp0 = 1;
        dp1 = ((str.charAt(0)-'0')*10+(str.charAt(1)-'0') <= 25) ? 2 : 1;
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i-1) != '0' && (str.charAt(i-1)-'0')*10+(str.charAt(i)-'0') <= 25) cur = dp0 + dp1;
            else cur = dp1;
            dp0 = dp1;
            dp1 = cur;
        }
        return dp1;
    }

}

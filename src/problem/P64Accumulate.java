package problem;

/**
 * Title: 64. 不用循环判断等语句求累加
 * Desc: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by Myth on 7/14/2019
 */
public class P64Accumulate {
    // 使用递归，终止条件使用短路求值！！！
    public int accumulate(int n) {
       int ans = n;
       // 递归的终止条件
       boolean b = (ans != 0) && ((ans += accumulate(n - 1)) != 0);
       return ans;
    }
}

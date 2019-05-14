package problem;

/**
 * Title: 数值的整数次方
 * Desc: 不使用库函数，求 double pow(int base, int exponent)  , 不用考虑大数情况
 * Created by Myth on 5/14/2019
 */
public class P16Pow {
    // 公式： a^n = a^(n/2) * a^(n/2)
    //            = a^((n-1)/2) * a^((n-1)/2) * a
    public static double pow(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;

        double result = powWithPositiveExp(base, Math.abs(exponent));
        if (exponent < 0) result = 1.0 / result;
        return result;
    }
    // 求正数次幂
    public static double powWithPositiveExp(double base, int exponent) {
        if (exponent == 0) return 0.0;
        if (exponent == 1) return base;
        double result = powWithPositiveExp(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(P16Pow.pow(0, 0));
    }
}

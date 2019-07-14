package problem;

import java.util.Arrays;

/**
 * Title: 66. 构建乘积数组
 * Desc: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 注：n=1时候，B={1}
 * Created by Myth on 7/14/2019
 */
public class P66ConstructArray {
    public int[] multiply(int[] A) {
        if (A == null) return null;
        int len = A.length;
        int[] B = new int[len];
        if (len == 0) return B;
        // 下三角形，从上往下计算
        int[] C = new int[len];
        // 上三角形，从下往上计算
        int[] D = new int[len];
        C[0] = 1;
        D[len-1] = 1;
        for (int i = 1; i < len; i++) {
            C[i] = C[i-1] * A[i-1];
        }
        for (int i = len-2; i >= 0; i--) {
            D[i] = D[i+1] * A[i+1];
        }
        for (int i = 0; i < len; i++) {
            B[i] = C[i] * D[i];
        }
        return B;
    }
    // 不使用 C 和 D
    public int[] multiply2(int[] A) {
        if (A == null) return null;
        int len = A.length;
        int[] B = new int[len];
        if (len == 0) return B;
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int i = len-2; i >= 0; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
        P66ConstructArray p66 = new P66ConstructArray();
        int[] arr = {0};
        System.out.println(Arrays.toString(p66.multiply2(arr)));
    }
}

package problem;

/**
* Title: 
* Desc: 
* Created by Myth-PC on 28/01/2020 in VSCode
*/
public class P10Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + a;
        }
        return b;
    }
}
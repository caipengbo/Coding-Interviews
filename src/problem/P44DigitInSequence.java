package problem;

/**
 * Title: 42. 数字序列中某一位的数字
 * Desc: 数字以0123456789101112131415161718192021222324252627282930...，问该序列的 第 n(从0开始) 位置是什么数字
 * Created by Myth on 6/21/2019
 */
public class P44DigitInSequence {
    // 10 ((9-0+1)*1)位是 0 ~ 9 一位数字
    // 180 ((99-10+1)*2)位是 10 ~ 99 二位数字
    // 2700 ((999-100+1)*3)位 100 ~ 999 三位数字
    public int solution(int n) {
        //if (n < 10) return n;
        int i = 1;
        int curNum = 0;
        int nextNum = countPlace(i);
        // 每次减去 当前位数时 获得的数目
        while (n - curNum >= nextNum) {
            n = n - curNum;
            curNum = nextNum;
            nextNum = countPlace(++i);
        }
        int temp = n - curNum;
        // System.out.println(temp);
        return getNum(i, temp/i, temp%i);
    }
    // n 位数字 位数（10 180 2700 ...）
    public int countPlace(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 10;
        int maxNum = 0;
        int minNum = (int) Math.pow(10, n-1);
        for (int i = 0; i < n; i++) {
            maxNum = maxNum * 10 + 9;
        }
        return (maxNum-minNum+1)*n;
    }
    // 第placeNum 位， 第index个数，第position位
    public int getNum(int placeNum, int index, int position) {
        if (placeNum == 1) {
            return index;
        }
        int start = (int) Math.pow(10, placeNum-1);
        int num = start + index;
        return (num / (int)(Math.pow(10, placeNum-position-1))) % 10;
    }
    public void test(String testName, int inputIndex, int expectedOutput)
    {
        if(solution(inputIndex) == expectedOutput)
            System.out.println(testName + " passed.");
        else
            System.out.println(testName + " FAILED.");
    }

    public static void main(String[] args) {
        P44DigitInSequence p44 = new P44DigitInSequence();
        p44.test("Test1", 0, 0);
        p44.test("Test2", 1, 1);
        p44.test("Test3", 9, 9);
        p44.test("Test4", 10, 1);
        p44.test("Test5", 189, 9);  // 数字99的最后一位，9
        p44.test("Test6", 190, 1);  // 数字100的第一位，1
        p44.test("Test7", 1000, 3); // 数字370的第一位，3
        p44.test("Test8", 1001, 7); // 数字370的第二位，7
        p44.test("Test9", 1002, 0); // 数字370的第三位，0
        // System.out.println(p44.solution(1001));
    }

}

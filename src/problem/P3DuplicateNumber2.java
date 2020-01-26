package problem;

/**
* Title: 3.2 数组中的重复元素2 
* Desc: 不修改数组找到该元素（二分查找）
* Created by Myth-PC on 26/01/2020 in VSCode
*/
public class P3DuplicateNumber2 {
    private int count(int numbers[], int l, int r) {
        int ret = 0;
        // 注意是整个范围
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= l && numbers[i] <= r) ret++; 
        }
        return ret;
    }

    public int duplicate(int numbers[]) {
        int l = 0, r = numbers.length-1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (count(numbers, l, m) > (m-l+1)) r = m;  // 左侧
            else l = m + 1;
        }
        // 如果不确定是否一定存在 dup, 那么就判断 count(l, l) == 1 ? 
        return l;
    }
    // test case：{1,1} --- r = n 与 r = n-1结果不一致，
    public int duplicate2(int numbers[]) {
        int l = 0, r = numbers.length, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (count(numbers, l, m) > (m-l+1)) r = m;  // 左侧
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        P3DuplicateNumber2 p3 = new P3DuplicateNumber2();
        int[] numbers0 = {1, 3, 2, 4, 5, 7, 6, 7};
        int[] numbers1 = {1};
        int[] numbers2 = {1,1};
        int[] numbers3 = {1,2};
        System.out.println(p3.duplicate(numbers0)); 
        System.out.println(p3.duplicate(numbers1)); 
        System.out.println(p3.duplicate(numbers2)); 
        System.out.println(p3.duplicate(numbers3)); 
    }
}
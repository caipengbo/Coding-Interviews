package problem;

/**
* Title: 11. 旋转数组的最小值
* Desc: 
* Created by Myth-PC on 29/01/2020 in VSCode
*/
public class P11MinInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (array[m] < array[r]) r = m;
            else if (array[m] > array[r]) l = m + 1;
            else r--;
        }
        return array[l];
    }
    public static void main(String[] args) {
        P11MinInRotateArray p11 = new P11MinInRotateArray();
        int[] arr = {3,4,5,1,2};
        System.out.println(p11.minNumberInRotateArray(arr));
    }
}
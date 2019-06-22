package problem;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Title: 45. 把数组排成最小的数
 * Desc: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323{321,32,3}。
 * Created by Myth on 6/22/2019
 */
public class P45SortArrayForMinNumber {
    // mn < nm 定义 m 小于 n 说明 m 应该 排在 n 前面
    // mn > nm 定义 m 大于 n
    // mn = nm 定义 m 等于 n
    // 本题就是排序（自定义排序规则）这个数组，然后最后排序后的结果
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        // 将数组中的元素转换成字符串（所有字符串组合有溢出风险）
        for (int i = 0; i < numbers.length; i++) {
            stringArrayList.add(String.valueOf(numbers[i]));
        }
        stringArrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        // System.out.println(stringArrayList.toString());
        // String ret = "";
        StringBuilder ret = new StringBuilder();
        for (String str : stringArrayList) {
            ret.append(str);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        P45SortArrayForMinNumber p45 = new P45SortArrayForMinNumber();
        int[] number = {3,32,321};
        System.out.println(p45.PrintMinNumber(number));
    }
}

package problem;

import java.util.ArrayList;

/**
 * Title: 49. 丑数
 * Desc: 把只包含质因子2、3和5的数称作丑数（Ugly Number）
 * 例如 6、8 都是丑数，但 14 不是，因为它包含质因子 7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 * Created by Myth on 6/23/2019
 */
public class P49UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        ArrayList<Integer> uglyArray = new ArrayList<>();
        uglyArray.add(1);
        int i = 0, j = 0, k = 0;
        int minNum;
        while (uglyArray.size() <= index) {
            minNum = Math.min(Math.min(uglyArray.get(i)*2, uglyArray.get(j)*3), uglyArray.get(k)*5);
            if (minNum == uglyArray.get(i)*2) i++;
            if (minNum == uglyArray.get(j)*3) j++;
            if (minNum == uglyArray.get(k)*5) k++;
            uglyArray.add(minNum);
        }
        return uglyArray.get(index-1);
    }
}

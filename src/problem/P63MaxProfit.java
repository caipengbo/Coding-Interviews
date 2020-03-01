package problem;

/**
 * Title: 63. 股票的最大利润
 * Desc: 把股票的价格按照时间先后顺序存储在数组中，请问买卖该股票 1 次可以获得的最大利润是多少？
 * 例如：一只股票在某时间节点的价格是{9,11,8,5,7,12,16,14}，在价格为5 的时候买入并在价格为16 的时候卖出，最大利润为11。
 * Created by Myth on 7/13/2019
 */
public class P63MaxProfit {
    // 扫描一遍，记住当前位置之前的元素最小值
    public int MaxDiff(int[] numbers) {
        if (numbers == null) return -1;
        int len = numbers.length;
        if (len < 2) return -1;
        int profit = Integer.MIN_VALUE;
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if ((numbers[i]-min) > profit) profit = numbers[i]-min;
            if (numbers[i] < min) min = numbers[i];
        }
        return profit;
    }

    // 第二遍
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0], profit = 0, n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] - min > profit) profit = prices[i] - min;
            if (prices[i] < min) min = prices[i]; 
        }
        return profit;
    }

    public static void main(String[] args) {
        P63MaxProfit p63 = new P63MaxProfit();
        int[] arr1 = {9,11,8,5,7,12,16,14};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr3 = {7, 6, 5, 4, 3, 2, 1};
        int[] arr4 = {1, 6};
        int[] arr5 = {6, 1};
        System.out.println(p63.MaxDiff(arr1));
        System.out.println(p63.MaxDiff(arr2));
        System.out.println(p63.MaxDiff(arr3));
        System.out.println(p63.MaxDiff(arr4));
        System.out.println(p63.MaxDiff(arr5));
    }
}

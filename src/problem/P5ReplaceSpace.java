package problem;

/**
* Title: 5. 替换空格
* Desc: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* Created by Myth-PC on 27/01/2020 in VSCode
*/
public class P5ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') count++;
        }
        if (count == 0) return str.toString();
        int n = str.length()+2*count, i = n-1;
        char[] ret = new char[n];
        for (int j = str.length()-1; j >= 0; j--) {
            if (str.charAt(j) != ' ') ret[i--] = str.charAt(j);
            else {
                ret[i--] = '0';
                ret[i--] = '2';
                ret[i--] = '%';
            }
        }
        return String.valueOf(ret);
    }
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("I am Myth");
        P5ReplaceSpace p5 = new P5ReplaceSpace();
        System.out.println(p5.replaceSpace(stringBuffer));
    }
}
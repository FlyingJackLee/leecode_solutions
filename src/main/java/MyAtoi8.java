public class MyAtoi8 {
    public static int myAtoi(String s) {
        char[] sNoSpace = s.stripLeading().toCharArray();
        boolean sign = true; //表示正负数

        int result = 0;
        for (int i = 0; i < sNoSpace.length; i++) {
            if (i == 0 && sNoSpace[i] == '-') {
                sign = false;
                continue;
            }
            if (i == 0 && sNoSpace[i] == '+') {
                continue;
            }

            // 如果不是数字字符，退出循环
            if (sNoSpace[i] > 57 || sNoSpace[i] < 48) {
                break;
            }

            // 如果正数超过范围
            if (sign && ((result > Integer.MAX_VALUE/10 )|| (result == Integer.MAX_VALUE/10 && sNoSpace[i] - 48 > 7))){
                return Integer.MAX_VALUE;
            }

            // 如果负数超过范围
            if (!sign && ((result * -1 < Integer.MIN_VALUE/10 ) || (result * -1 == Integer.MIN_VALUE/10 && sNoSpace[i] - 48 > 8))){
                return Integer.MIN_VALUE;
            }

            result = result * 10 + (sNoSpace[i] - 48);
        }
        return result * (sign ? 1: -1);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }
}

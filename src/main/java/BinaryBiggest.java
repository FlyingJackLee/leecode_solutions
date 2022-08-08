public class BinaryBiggest {
    // 待实现函数，在此函数中填入答题代码
    private static int getLongestNum(long num) {

        char[] binaryCharArr = Long.toBinaryString(num).toCharArray();

        //初始化参数
        int biggestLength = 1;
        char pre = binaryCharArr[0];

        int count = 1;
        for (int i = 1; i < binaryCharArr.length; i++) {
            if (binaryCharArr[i] == pre){
              count ++;
            }
            else {
                count = 1;
                pre = binaryCharArr[i];
            }

            biggestLength = Math.max(count,biggestLength);

        }

        // 在此补充你的代码
        return biggestLength;
    }

    public static void main(String[] args) {
        System.out.println(getLongestNum(0));
    }
}

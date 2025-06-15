package medium;

/**
 * @author Zumin Li
 * @date 2025/6/15 12:01
 */
public class BrokenCalc991 {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;

        // 1. 先使得数比target大
        while (startValue < target) {
            ans++;

            // 奇数只能进行+
            if (target % 2 == 1) {
                target ++;
            }
            else {
                // 偶数时：
                // 1. a.+变奇 b.奇+变回相同偶数 - 无效重复操作
                // 2. 除以2
                // 所以只能除以2
                target = target >> 1;
            }
        }

        // 2. 剩下的步骤就一定都是减
        // * 如果一开始就比target大，那么就不可能进行*算法（会不断溢出）
        return ans + startValue - target;
    }

    public static void main(String[] args) {
        BrokenCalc991 calc = new BrokenCalc991();
        System.out.println(calc.brokenCalc(2, 3));
    }
}

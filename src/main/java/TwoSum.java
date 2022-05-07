/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 9:14 PM
 * 4
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;

        while (l < r){
            if ((numbers[l] + numbers[r] ) > target ){
                r--;
            }
            else if ((numbers[l] + numbers[r] ) == target){
                break;
            }
            else {
                l ++;
            }
        }

        return new int[]{l,r};

    }
}

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/1/23 10:20 PM
 * 4 https://leetcode-cn.com/problems/check-array-formation-through-concatenation/
 */
public class CanFormArray {
    public  boolean canFormArray(int[] arr, int[][] pieces) {
        int[] arrCopy = Arrays.copyOf(arr,arr.length);

        while (true){
            outloop:
            for (int i = 0; i < pieces.length; i++) {

                if (arrCopy.length == 0){
                    return true;
                }

                //查看是否和开头一致
                boolean isHead = true;

                headlood:
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] != arrCopy[j]){
                        isHead = false;
                        break headlood;
                    }
                }

                //如果当前数组与开头一致
                if (isHead){
                    //从开头移除
                    arrCopy = copyFromSlice(arrCopy,0,pieces[i].length-1);
                    break outloop;
                }

                //如果最后都没发现匹配的，直接返回false
                if (i == pieces.length - 1){
                    return false;
                }
            }
        }
    }

    static int[] copyFromSlice(int[] arr,int start,int end){
        //新长度为原长度减去slice的
        int[] newArr = new int[arr.length - (end - start + 1)];

        int point = 0;
        //从end+1开始复制给新的数组
        for (int i = end + 1; i < arr.length; i++) {
            newArr[point] = arr[i];
            point++;
        }

        return newArr;

    }







//    static boolean arrContainTwoArr(int[] a,int[] b, int[] target){
//
//        //长度不一样直接返回false
//        if (a.length + b.length != target.length){
//            return false;
//        }
//
//        boolean result = true;
//
//        //正向遍历
//        for (int i = 0; i < target.length; i++) {
//            //遍历a的时候，并且不相等
//            if (i < a.length && a[i] != target[i]){
//                result = false;
//                break;
//            }
//            //遍历b
//            else if (i >= a.length && b[i-a.length] != target[i] ){
//                result = false;
//                break;
//            }
//        }
//
//        if (result){
//            return true;
//        }
//
//        result = true;
//
//        //反向遍历
//        for (int i = 0; i < target.length; i++) {
//            //先遍历b的时候，并且不相等
//            if (i < b.length && b[i] != target[i]){
//                result = false;
//                break;
//            }
//            //遍历a
//            else if (i >= b.length + b.length && a[i-b.length] != target[i] ){
//                result = false;
//                break;
//            }
//        }
//
//        return result;
//
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{91,4,64,78};

        int[][] peices = new int[3][];

        peices[0] = new int[]{
                78
        };

        peices[1] = new int[]{
                4,64
        };

        peices[2] = new int[]{
                91
        };


    }

}

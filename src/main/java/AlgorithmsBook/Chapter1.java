package AlgorithmsBook;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/5/7 14:10
 * 4
 */
public class Chapter1 {
    public static double Dijkstra(String operation){
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (char c:operation.toCharArray()) {
            switch (c){
                case '(','+','-','*','/':
                    ops.push(c);
                    break;
                case ')':
                    char op = ops.pop();
                    double v = vals.pop();
                    switch (op){
                        case '+':
                            v = vals.pop() + v;
                            break;
                        case '-':
                            v = vals.pop() - v;
                            break;
                        case '*':
                            v = vals.pop() * v;
                            break;
                        case '/':
                            v = vals.pop() / v;
                            break;
                        default:
                    }
                    vals.push(v);
                    break;
                case ' ':
                    break;
                default:
                    vals.push(Double.parseDouble(String.valueOf(c)));
            }
        }

        return vals.pop();
    }

    public static int threeSum(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Arrays.binarySearch(a,-a[i]-a[j]) > j){
                    cnt++;
                }
            }

        }

        return cnt;
    }

    public static int twoSum(int[] a){
        Arrays.sort(a);

        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            //如果查找到了可以为0
            if (Arrays.binarySearch(a,-a[i]) > i){
                cnt ++;
            }
        }

        return cnt;

    }

    public static void main(String[] args) {

        int[] test = In.readInts(Chapter1.class.getClassLoader().getResource("data/4Kints.txt").getPath());
        StdOut.println(threeSum(test));
    }

}

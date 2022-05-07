import java.util.Scanner;
import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/19 15:09
 * 4
 */
public class Choujiang360 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt() + n;
//
//        double[][] dp = new double[n+1][m+1];
//
//        for (int i = 1; i < n + 1; i++) {
//            dp[i][i] = 1;
//        }
//
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = i; j < m + 1; j++) {
//                if (dp[i][j] > 0){
//                    continue;
//                }
//
//                //第一回合抽到的概率
//                dp[i][j] = ((double)i)/(j);
//
//
//                if (j-3 <= 1){
//                    continue;
//                }
//
//                //第一回合A抽不到的概率， 第二回合B也抽不到
//                double temp = (j-i)/(double)j *  (j-1-i)/(double)(j-1);
//
//
//                dp[i][j] +=
//                        //额外回合B没抽到时，之后A抽到
//                        temp *  dp[i][j-3] +
//                                //额外回合B抽到时，之后A抽到
//                                temp * dp[i-1][j-3];
//            }
//
//        }

//        System.out.println(dp[n][m]);

//
//        Stack<Integer> test = new Stack<>();
//        test.push(2);
//        test.push(1);
//
//        System.out.println(test.pop());
//
//        test.push(1);
//        test.push(2);
//        System.out.println(test.pop());
//
//        System.out.println(test.pop());
//
//        System.out.println(test.pop());
//
//        test.push(2);
//        System.out.println(test.pop());


        recur(10);


//        char ch = 'b';

        int count = 0;


        System.out.println((int)'a');

        System.out.println((int)'z');


        int ch = (int) 'b';


        while (ch >= (int)'a' && ch <= (int)'z'){
            System.out.println("第"+ (ch - 98) + "次" + (char) ch);
            count++;
            ch++;
        }

        System.out.println(count);

//
//        int a = 1;
//        int b = 1;
//        int c = ++a + b;
//
//        System.out.print(a);
//        System.out.print(b);
//        System.out.print(c);

    }



    public static void recur(int n ){
        if (n == 0){
            return;
        }

        recur(n-1);
        System.out.println(n);

    }


}

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/2/27 7:27 PM
 * 4
 */
public class Review {

    //返回什么类型|函数名字|函数要输入哪些参数
    static int sum(int a, int b){
        int sum = a + b;
        return  sum;
    }


    public static void main(String[] args) {
        //创建一个新的名字为i的int值
        int a  = 1;
        int b = 3;

        //a + (a+b)
        System.out.println(
                a + sum(a,b)
        );

    }
}

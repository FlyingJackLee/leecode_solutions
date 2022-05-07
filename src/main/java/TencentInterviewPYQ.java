import java.lang.reflect.Array;
    import java.util.*;
import java.util.stream.Collectors;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/13 4:01 PM
 * 4
 */
public class TencentInterviewPYQ {


       // 6/n
       //+ 2/n
       // 1/n
       // 2/n

       //2 3
//       int a = sc.nextInt();
//        int b = sc.nextInt();
//        sc.nextLine();




    public static void main(String[] args) {


//            Scanner sc = new Scanner(System.in);
//            //|6 => |
//            // 2
//            int n = sc.nextInt();
//            //换行
//            //| 2 每一次到末尾，如果从来没有nextLine过，记得换行
//            sc.nextLine();
//
//            int[] data = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                data[i] = sc.nextInt();
//                sc.nextLine();
////                data[i] = Integer.parseInt(sc.nextLine());
//            }
//
//
//            for (int i = 0; i < data.length; i++) {
//                System.out.println(data[i] * data[i]);
//            }

            Scanner scanner = new Scanner(System.in);
            //5
            int n = scanner.nextInt();
            scanner.nextLine();
            //abcaac [1,3,1,1,3]
            //[1,3] = 2
            char[] str = scanner.nextLine().toCharArray();

            for (int i = 0; i < str.length; i++) {
                 int curr =  (int) str[i] - 96;

                 System.out.println(curr);
            }

        //a + b
        //'a' 'c' => a-1 b-2 c-3



        //k =10
            int k = scanner.nextInt();
            scanner.nextLine();

             System.out.println();


             //'a' 'b' 'd' ==> 40 41 43

            //8 n字符串长度
            //adadsada
    }







//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        //获取字符串
//        String str = scanner.nextLine();
//        int index = scanner.nextInt();
//
//        String[][] dp = new String[str.length()][str.length()];
//
//        List<String> result = new ArrayList<>();
//
//
//        for (int i = 0; i < str.length(); i++) {
//            dp[i][i] = str.substring(i,i+1);
//            result.add(dp[i][i]);
//
//            sortList(result,index);
//        }
//
//
//        for (int i = 0; i < str.length() - 1; i++) {
//            for (int j = i + 1; j < str.length(); j++) {
//                if (dp[i][j] == null){
//                    dp[i][j] = dp[i][j-1] + dp[j][j];
//                }
//
//                result.add(dp[i][j]);
//                result.sort(String.CASE_INSENSITIVE_ORDER);
//
//                sortList(result,index);
//
//
//            }
//        }
//
//
//        System.out.println(result.get(index-1));
//
//
//    }
//
//    public static void sortList( List<String> result,int n){
//        result.sort(String.CASE_INSENSITIVE_ORDER);
//        while (result.size() > n){
//            result.remove(result.size() - 1);
//        }
//
//    }


}

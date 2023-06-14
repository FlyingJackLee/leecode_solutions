import java.util.ArrayList;
import java.util.List;

public class RotateString796 {
    public boolean rotateString(String s, String goal) {

//        int m = s.length(), n = goal.length();
//        if (m != n) {
//            return false;
//        }
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                // 偏移后位置刚好对的上goal的值，i其实就是shift的断点
//                if (s.charAt((i + j) % n) != goal.charAt(j)) {
//                    System.out.println((i + j) % n);
//                    System.out.println(j);
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return true;
//            }
//        }
//        return false;


          return s.length() == goal.length() && (s + s).contains(goal);
    }
}

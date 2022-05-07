import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/20 11:02
 * 4
 */
public class AllBracketsClosed {

    public static boolean is_all_brackets_closed(String text){

        Stack<Character> buffer = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char lizi = text.charAt(i);

            if (lizi == '(' || lizi == '{' || lizi == '[' ){
                buffer.push(lizi);
            }
            //如果是后半部分括号
           else{
                //如果不闭合
                if (lizi == ')' && '(' != buffer.pop()){
                   return false;
               }
                if (lizi == ']' && '[' != buffer.pop()){
                    return false;
                }
                if (lizi == '}' && '{' != buffer.pop()){
                    return false;
                }

            }

        }
        return true;
    }


    public static List<Integer> find( List<Integer> array1, List<Integer> array2){
        //用set去重
        Set<Integer> set1 = new HashSet<>(array1);

        Set<Integer> set2 = new HashSet<>(array2);

        List<Integer> result = new ArrayList<>();

        for (Integer ele:set1) {
            if (set2.contains(ele)){
                result.add(ele);
            }
        }
        return result;

    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(1);
//        list1.add(2);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);


        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);


        System.out.println( find(list1,list2));


//
//        System.out.println(is_all_brackets_closed("(){}[]"));
//        System.out.println(is_all_brackets_closed("({[}])"));
//
//        List<Integer> result = new ArrayList<>();
//        Set<Integer> current = new HashSet<>();
//
//        current.addAll(result);
//        result = new ArrayList<>();
//        result.addAll(current);

    }
}

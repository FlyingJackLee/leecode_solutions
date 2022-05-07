import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 9:40 PM
 * 4
 */
public class Postorder590 {

    public List<Integer> postorder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }


        Stack<Node> path = new Stack<>();
        List<Node> visited = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        path.push(root);
        visited.add(root);

        loop:
        while (!path.isEmpty()){

            //获取路径最后一个
            Node node = path.peek();

            //路径到头
            if (node.children == null || node.children.size() == 0){
                //添加进遍历中, 并弹出
                result.add(path.pop().val);
                continue loop;
            }

            for (Node curr:node.children) {
                //如果没有遍历过,推入stack，加入访问历史,并直接下一次
                if (!visited.contains(curr)){
                    path.push(curr);
                    visited.add(curr);
                    continue loop;
                }
            }

            //如果进行到这里，证明children都访问过了,弹出当前并加入list
            result.add(path.pop().val);
        }

        return result;
    }
}

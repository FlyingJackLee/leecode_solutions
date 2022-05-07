import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 9:34 PM
 * 4
 */
public class Preorder589 {

    public List<Integer> preorder(Node root) {

        if (root == null){
            return new ArrayList<>();
        }


        Stack<Node> path = new Stack<>();
        Map<Node,Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        path.push(root);
        visited.put(root,true);
        result.add(root.val);


        loop:
        while (!path.isEmpty()){
            Node node = path.peek();

            //到头了
            if (node.children == null || node.children.size() == 0){
                path.pop();
                continue loop;
            }

            for (Node child:node.children) {
                if (visited.get(child) != null){
                    path.push(child);
                    visited.put(child,true);
                    result.add(child.val);
                    continue loop;
                }
            }

            path.pop();


        }

        return result;

    }



//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//
//        dfs(root,result);
//
//        return result;
//
//    }
//
//    public void dfs(Node root,List<Integer> result){
//        if (root != null){
//            result.add(root.val);
//            for (int i = 0; i < root.children.size(); i++) {
//                dfs(root.children.get(i),result);
//            }
//        }
//    }
}

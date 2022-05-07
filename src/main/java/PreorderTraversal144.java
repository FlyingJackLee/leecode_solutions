import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 9:26 PM
 * 4
 */
public class PreorderTraversal144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root,result);

        return result;
    }

    public static void dfs(TreeNode root, List<Integer> result){

        if (root != null){
            dfs(root.left,result);
            dfs(root.right,result);
            result.add(root.val);

        }
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1,
                null,new TreeNode(2,new TreeNode(3),null));

        preorderTraversal(test);

    }
}

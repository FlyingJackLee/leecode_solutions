/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 3:26 PM
 * 4
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode right = invertTree(root.right);

        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;

    }
}

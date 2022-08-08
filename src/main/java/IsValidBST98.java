import edu.princeton.cs.algs4.Stack;

public class IsValidBST98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long low,long high){
        if (root == null){
            return true;
        }
        if (root.val <= low || root.val >= high ){
            return false;
        }

        return dfs(root.left,low,root.val) && dfs(root.right,root.val,high);

    }

}

package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<List<Integer>> ans;
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>(1);
        this.targetSum = targetSum;

        if (root == null) {
            return ans;
        }

        List<Integer> path = new ArrayList<>(1);
        dfs(root, path);

        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path){
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (path.stream().mapToInt(Integer::intValue).sum() == this.targetSum) {
                ans.add(List.copyOf(path));
            }
        }

        if (node.left != null) {
            dfs(node.left, path);
        }

        if (node.right != null) {
            dfs(node.right, path);
        }
        path.removeLast();
    }
}



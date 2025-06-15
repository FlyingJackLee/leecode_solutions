package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zumin Li
 * @date 2025/6/13 13:25
 */
public class Rob337 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }


    public int rob(TreeNode root) {
        int[] fg = dfs(root);
        return Math.max(fg[0], fg[1]);
    }


    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] fgl = dfs(node.left);
        int[] fgr = dfs(node.right);

        int f = node.val + fgl[1] + fgr[1];
        int g = Math.max(fgl[0], fgl[1]) + Math.max(fgr[0], fgr[1]);
        return new int[]{f, g};
    }
}

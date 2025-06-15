public class RangeSumBST938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val <= high && root.val >= low) {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
        }
        else {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}

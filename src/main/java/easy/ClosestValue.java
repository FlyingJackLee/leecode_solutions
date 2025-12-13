package easy;


public class ClosestValue {
    private double min = Integer.MAX_VALUE;;
    private int res = Integer.MAX_VALUE;;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return this.res;
    }

    private void dfs(TreeNode node, double target){
        if (node == null) return;

        double difference = Math.abs(node.val - target);
        if (difference < this.min || (difference == this.min && node.val < this.res)) {
            this.min = Math.abs(target - (double) node.val);
            this.res = node.val;
        }

        dfs(node.left, target);
        dfs(node.right, target);
    }

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
}

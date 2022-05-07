/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/6 3:45 PM
 * 4
 */
public class MinDepth111 {
    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;

        if (root.left != null){
            min_depth = Math.min(minDepth(root.left),min_depth);
        }
        if (root.right !=null){
            min_depth = Math.min(minDepth(root.right),min_depth);
        }

        return min_depth + 1;

    }

    public int minDepth(TreeNode root,int deep) {
        if (root == null){
            return deep;
        }

        int leftMin = minDepth(root.left,deep + 1);
        int rightMin = minDepth(root.right,deep + 1);

        boolean isLeftNull = root.left == null;
        boolean isRightNull = root.left == null;

        if (root.left != null && root.right == null){
            return leftMin;
        }
        else if (root.left == null && root.right != null){
            return rightMin;
        }
        else if (root.left != null && root.right != null){
            return Math.min(leftMin,rightMin);
        }

        return deep + 1;


    }

}

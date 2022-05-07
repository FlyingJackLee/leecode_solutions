import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 4:07 PM
 * 4
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    public boolean dfs(TreeNode left,TreeNode right){

        if (left == null || right ==null){
           return left == right;
        }

        if (left.val != right.val){
            return false;
        }

        //到头了
        if (left.left == null && left.right == null){
            return true;
        }

        return dfs(left.left,right.right) && dfs(left.right,right.left);

    }


//    public static boolean isSymmetric(TreeNode root) {
//        List<TreeNode> curr = new LinkedList<>();
//
//        curr.add(root.left);
//        curr.add(root.right);
//
//        boolean isContinue = true;
//
//        while (isContinue){
//            isContinue = false;
//
//            List<TreeNode> pre = curr;
//            curr = new ArrayList<>();
//
//            for (int i = 0; i < pre.size(); i++) {
//
//                TreeNode start = pre.get(i);
//                TreeNode end =  pre.get(pre.size() - i - 1);
//
//                if (end == null && start == null ){
//                    continue;
//                }else if (end == null ^ start == null){
//                    return false;
//                }
//
//                //是否和对称点相同
//                if ( start.val != end.val) {
//                    return false;
//                }
//                if ((pre.get(i).left != null) || (pre.get(i).right != null)){
//                    isContinue = true;
//                }
//
//                curr.add(pre.get(i).left);
//                curr.add(pre.get(i).right);
//            }
//
//        }
//
//        return true;
//
//    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(
                1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(2,new TreeNode(4),new TreeNode(3))
        );

    }
}

import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 8:46 PM
 * 4
 */
public class SumNumbers129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root,int previousSum){

        if (root.left == null && root.right == null){
            return previousSum * 10 + root.val;
        }

        //如果左节点为空，证明往下走不是一条合理的路径
        if (root.left == null){
            return dfs(root.right, previousSum * 10 + root.val);
        }
        if (root.right == null){
            return dfs(root.left,previousSum * 10 + root.val);
        }

        return dfs(root.left,previousSum * 10 + root.val)
                + dfs(root.right, previousSum * 10 + root.val);
    }



//
//    public int dfs(TreeNode root,int prevSum){
//        if (root.left == null && root.right == null){
//            return prevSum * 10 + root.val;
//        }
//
//        if (root.left == null){
//           return  dfs(root.right,prevSum * 10 + root.val);
//        }
//
//        if (root.right == null){
//            return   dfs(root.left,prevSum * 10 + root.val);
//        }
//
//        return dfs(root.left,prevSum * 10 + root.val)
//                + dfs(root.right,prevSum * 10 + root.val);
//
//    }

//    public int sumNumbers(TreeNode root) {
//
//        Stack<TreeNode> path = new Stack<>();
//        List<TreeNode> visited = new ArrayList<>();
//
//        int sum =  0;
//        int pathSum = root.val;
//
//
//        path.push(root);
//        visited.add(root);
//
//
//        while (!path.isEmpty()){
//
//            TreeNode node = path.peek();
//
//            if (node.left == null && node.right == null){
//                sum += pathSum;
//                pathSum = (pathSum - path.pop().val)/10;
//                continue;
//            }
//
//
//            if (node.left != null && !visited.contains(node.left)){
//                path.push(node.left);
//                visited.add(node.left);
//
//                pathSum = pathSum * 10 + node.left.val;
//
//            }
//            else if(node.right != null && !visited.contains(node.right)){
//                path.push(node.right);
//                visited.add(node.right);
//
//                pathSum = pathSum * 10 + node.right.val;
//            }
//            else {
//                path.pop();
//                pathSum = (pathSum - node.val) / 10;
//            }
//
//        }
//
//        return sum;
//
//    }


}

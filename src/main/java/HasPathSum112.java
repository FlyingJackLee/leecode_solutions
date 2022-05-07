import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/6 4:13 PM
 * 4
 */
public class HasPathSum112 {

    public int functional(int n){
        if (n == 1){
            return 1;
        }

        return n * functional(n-1);
    }

   public boolean hasPathSum(TreeNode root, int targetSum) {

       if (root==null){
           return false;
       }

       //储存当前路径
       Stack<TreeNode> path = new Stack<>();
       //储存访问过的路径
       List<TreeNode> visited = new ArrayList<>();

       TreeNode node = root;
       int sum = root.val;
       path.push(root);
       visited.add(root);

       //当队列不为空时
       while (!path.isEmpty()){
           // 或者最顶上的
           node = path.peek();

           if (node.right == null && node.left == null){
               if (sum == targetSum){
                   return true;
               }
               //移除当前节点，以进行回溯
               path.pop();
               sum -= node.val;
               continue;
           }

           //不为null，而且没有访问过
           if (node.left != null && !visited.contains(node.left)){
               path.push(node.left);
               visited.add(node.left);
               sum += node.left.val;
           }
           else if (node.right != null && !visited.contains(node.right)){
               path.push(node.right);
               visited.add(node.right);
               sum += node.right.val;
           }
           else {
               //如果左右都访问过，回溯
               path.pop();
               sum -= node.val;
           }

       }

       return false;
   }


//       public boolean hasPathSum(TreeNode root, int sum) {
//           //如果为空， 直接返回false
//            if (root == null){
//                return false;
//            }
//
//           Queue<TreeNode> queNode = new LinkedList<>();
//           Queue<Integer> queVal = new LinkedList<>();
//
//           queNode.offer(root);
//           queVal.offer(root.val);
//
//           while (!queNode.isEmpty()){
//               //推出最后一个
//               TreeNode now = queNode.poll();
//               int temp = queVal.poll();
//
//               //如果当前没有子节点了,到头来
//               if (now.left == null && now.right == null){
//                   //相等则返回ture
//                   if(temp == sum){
//                       return true;
//                   }
//                   //否则继续
//                   continue;
//               }
//
//               if (now.left !=null){
//                   //推入新节点
//                   queNode.offer(now.left);
//                   //推入新值
//                   queVal.offer(now.left.val + temp);
//               }
//
//               if (now.right != null){
//                   //推入新节点
//                   queNode.offer(now.right);
//                   //推入新值
//                   queVal.offer(now.right.val + temp);
//               }
//           }
//
//           return false;
//
//       }

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null){
//            return  false;
//        }
//        if (root.left == null && root.right == null){
//            return sum == root.val;
//        }
//
//        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
//    }
//    public static boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null){
//            return false;
//        }
//
//        int sum = 0;
//        List<TreeNode> visited = new ArrayList<>();
//        List<TreeNode> path = new ArrayList<>();
//
//        TreeNode node = root;
//
//        while (true){
//
//            //如果到头了
//            if (node == null && visited.get(visited.size()-1) != root){
//                if (sum == targetSum){
//                    return true;
//                }
//
//                //回走
//                for (int i = visited.size() - 1; i >= 0; i--) {
//
//                    TreeNode left = visited.get(i).left;
//                    TreeNode right = visited.get(i).right;
//
//
//                    //如果该节点左边，或者右边没有遍历完
//                    if (left != null && !visited.contains(left)){
//                        node = left;
//                        break;
//                    }
//                    else if(right != null && !visited.contains(right)){
//                        node = right;
//                        break;
//                    }
//
//                    //如果不能继续下去了,路径中移除该节点
//                    path.remove(visited.get(i));
//                    sum -= visited.get(i).val;
//
//                    if (path.size() == 0){
//                        return false;
//                    }
//
//                    //node等于上一个节点
//                    node = path.get(path.size() - 1);
//
//                }
//            }
//
//
//            //记录遍历过
//            visited.add(node);
//            path.add(node);
//
//            sum += node.val;
//
//            //如果左侧没有遍历过
//            if (!visited.contains(node.left)){
//                node = node.left;
//            }
//            //如果右侧没有遍历过
//            else if (!visited.contains(node.right)){
//                node = node.right;
//            }
//
//
//
//        }
//    }

    public static void main(String[] args) {
//        TreeNode test = new TreeNode(
//                5, new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),
//                new TreeNode(8,new TreeNode(13),new TreeNode(4,null,new TreeNode(1)))
//        );

    }

}

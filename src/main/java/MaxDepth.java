/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/5 5:27 PM
 * 4
 */
public class MaxDepth {
    public  int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    public int maxDepth(TreeNode root,int deep) {

        //已经超过树了，不能继续算作一层了，返回之前的最大
        if (root ==null){
            return deep;
        }

        //Math.max(int num1,int num2);返回num1和num2中的较大值

        return Math.max(
                //返回左节点最大值
                maxDepth(root.left,deep + 1),
                //返回右节点最大值
                maxDepth(root.right,deep + 1)
                );

    }

}

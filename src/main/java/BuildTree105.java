import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/5 4:14 PM
 * 4
 */
public class BuildTree105 {
    private Map<Integer,Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        for (int i = 0; i < inorder.length; i++) {
            this.inorderMap.put(inorder[i],i);
        }


        return subTree(0,preorder.length -1 ,0,inorder.length -1 ,preorder,inorder);

    }

    // left- 根 | 左节点  ｜ 右节点 - right  => preorder
    // 左节点 ｜ 根 ｜ 右节点  => inorder
    //两总排序在最后一定是相同结尾（右节点）
    public TreeNode subTree( int leftPreOder,int rightPreOrder,
                            int leftInOrder,int rightInOrder,
                            int[] preorder, int[] inorder){



        //如果到头了，直接返回节点
        if (leftPreOder > rightPreOrder){
            return null;
        }

        //根节点
        TreeNode node = new TreeNode(preorder[leftPreOder]);


        //根节点在inorder中位置
        int rootInOrderPosition = inorderMap.get(preorder[leftPreOder]);

        //左节点长度
        int leftNodeLength = rootInOrderPosition - leftInOrder;



        //迭代左节点
        node.left = subTree(leftPreOder + 1, leftPreOder + leftNodeLength,
                leftInOrder,rootInOrderPosition - 1,
                preorder,inorder
                );

        //迭代右节点
        node.right = subTree(leftPreOder + leftNodeLength + 1,rightPreOrder,
                rootInOrderPosition  + 1, rightInOrder,
                preorder,inorder
        );

        return node;

    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildTree105 buildTree105 = new BuildTree105();
        buildTree105.buildTree(preorder,inorder);

    }
}

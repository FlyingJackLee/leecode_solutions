import java.util.HashMap;
import java.util.Map;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/6 3:29 PM
 * 4
 */
public class BuildTree106 {

    private Map<Integer,Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i],i);
        }

        return buildTree(inorder,postorder,0,inorder.length - 1, 0,postorder.length -1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                              int leftInOrder,int rightInOrder,
                              int leftPostOder,int rightPostOrder
    ) {

        if (leftInOrder > rightInOrder){
            return null;
        }

        int rootVal = postorder[rightPostOrder];

        TreeNode node = new TreeNode(rootVal);

        int rootInInorderPosition = this.inOrderMap.get(rootVal);

        int leftNodeLength = rootInInorderPosition - leftInOrder;

        node.left = buildTree(inorder,postorder,
                    leftInOrder, rootInInorderPosition -1,
                    leftPostOder,leftPostOder + leftNodeLength -1
                );

        node.right = buildTree(inorder,postorder,
                rootInInorderPosition + 1, rightInOrder,
                leftPostOder + leftNodeLength, rightPostOrder - 1
                );

        return node;


    }
}

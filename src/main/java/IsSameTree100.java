import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 3:33 PM
 * 4
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果任意到头了，判断另一个是否到头
        if (p == null || q ==null){
            return p == q;
        }

        return p.val == q.val &&
                isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}

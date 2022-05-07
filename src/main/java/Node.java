import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/7 9:34 PM
 * 4
 */

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


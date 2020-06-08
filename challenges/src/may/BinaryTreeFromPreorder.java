package may;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class BinaryTreeFromPreorder {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length ==0) {
            return null;
        }

        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int minValue, int maxValue) {
        if(index >=preorder.length) {
            return null;
        }

        int root = preorder[index];
        TreeNode node = null;
        if (root > minValue && root < maxValue) {
            node = new TreeNode(root);
            index ++;
            node.left = helper(preorder, minValue, root);
            node.right = helper(preorder, root, maxValue);
        }

        return node;
    }
}

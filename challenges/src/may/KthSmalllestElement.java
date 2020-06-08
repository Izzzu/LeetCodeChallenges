package may;

import java.util.ArrayList;
import java.util.List;

public class KthSmalllestElement {
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inOrder(root, list, k);
        return list.get(list.size()-1);
    }

    private void inOrder(TreeNode root, List<Integer> list, int k) {
        if (list.size() == k) {
            return;
        }
        if (root == null) {
            return;
        }
        inOrder(root.left, list, k);
        if (list.size() == k) {
            return;
        }
        list.add(root.val);
        inOrder(root.right, list, k);

    }
}

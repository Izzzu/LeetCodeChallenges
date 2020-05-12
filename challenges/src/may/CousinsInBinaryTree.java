package may;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Pair {
    int parent;
    int depth;
    Pair(int p, int d) {
        this.depth = d;
        this.parent = p;
    }
}

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        int d1 = inorderTraversal(root, x, 0);
        int d2 = inorderTraversal(root, y, 0);
        if (d1 != -1 && d1 == d2 && !isSiblings(root, x, y)) {
            return true;
        }
        return false;

    }

    private boolean isSiblings(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        return (root.right!= null && root.left != null &&
                ((root.right.val == x && root.left.val == y) || (root.right.val == y && root.left.val == x)))
                || isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
    }

    public int inorderTraversal(TreeNode A, int val, int d) {

        if (A == null) {
            return -1;
        }
        if ( A.val == val) {
            return d;
        }

        int left = inorderTraversal(A.left, val, d + 1);
        if (left != -1) {
            return left;
        }
        return inorderTraversal(A.right, val,  d+1);
    }
}

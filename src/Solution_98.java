
class Solution_98 {

  /*Given a binary tree, determine if it is a valid binary search tree (BST).

  Assume a BST is defined as follows:

  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees.
  Example 1:

  Input:
      2
     / \
    1   3
  Output: true*/
  public boolean isValidBST(TreeNode root) {
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

  }

  private boolean helper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }
    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}
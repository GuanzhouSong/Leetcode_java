public class Solution_236 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //if both side is null, then p, q is not exist in the tree
    if (left == null && right == null) {
      return null;
    } else if (left != null && right != null) {
      //if both is not null, then p,q exist in each side, and root is the common ancestor.
      return root;
    } else {//if only one is not null, then must be it.
      return left == null ? right : left;
    }
  }

}

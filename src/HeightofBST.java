public class HeightofBST {

  public int getHeightOfBST(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int lDepth = getHeightOfBST(root.left);
      int rDepth = getHeightOfBST(root.right);
      return Math.max(lDepth, rDepth) + 1;
    }

  }

}

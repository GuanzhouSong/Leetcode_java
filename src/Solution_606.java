public class Solution_606 {

  public String tree2str(TreeNode t) {
    return helper(t);
  }

  private String helper(TreeNode root) {
    if (root == null) {
      return "";
    }
    String result = root.val + "";

    String right = helper(root.right);
    String left = helper(root.left);

    if (left == "" && right == "") {
      return result;
    }
    if (left == "") {
      return result + "()" + "(" + right + ")";
    }
    if (right == "") {
      return result + "(" + left + ")";
    }
    return result + "(" + left + ")" + "(" + right + ")";
  }

}

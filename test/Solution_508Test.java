import org.junit.Test;

public class Solution_508Test {

  @Test
  public void findFrequentTreeSum() {
    Solution_508 s = new Solution_508();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-3);
    s.findFrequentTreeSum(root);
  }
}
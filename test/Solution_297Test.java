import org.junit.Test;

public class Solution_297Test {

  @Test
  public void serialize() {
    Solution_297 s = new Solution_297();
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    one.left = two;
    one.right = three;
    three.left = four;
    three.right = five;
    System.out.println(s.serialize(one));
  }

  @Test
  public void deserialize() {
  }
}
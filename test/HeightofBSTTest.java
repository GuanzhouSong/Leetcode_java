import org.junit.Test;

public class HeightofBSTTest {

  HeightofBST h = new HeightofBST();

  @Test
  public void getHeightOfBST() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(6);
    System.out.println(h.getHeightOfBST(root));
  }
}
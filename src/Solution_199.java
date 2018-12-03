import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_199 {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    res.add(root.val);
    while (!queue.isEmpty()) {
      int count = queue.size();
      int last = 0;
      for (int i = 0; i < count; i++) {
        TreeNode temp = queue.poll();
        if (temp.left != null) {
          queue.offer(temp.left);
          last = temp.left.val;
        }
        if (temp.right != null) {
          queue.offer(temp.right);
          last = temp.right.val;
        }
      }
      res.add(last);
    }
    res.remove(res.size() - 1);
    return res;
  }
}

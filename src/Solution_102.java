import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
    if (root == null) {
      return wrapList;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      LinkedList<Integer> subList = new LinkedList<>();
      int levelNUm = queue.size();
      for (int i = 0; i < levelNUm; i++) {
        if (queue.peek().left != null) {
          queue.offer(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.offer(queue.peek().right);
        }
        subList.add(queue.poll().val);
      }
      wrapList.add(subList);
    }
    return wrapList;
  }

}
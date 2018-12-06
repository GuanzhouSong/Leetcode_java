import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_297 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur != null) {
        res.add(cur.val);
        queue.offer(cur.left);
        queue.offer(cur.right);
      } else {
        res.add(null);
        continue;
      }
    }
    int i = res.size() - 1;
    while (i >= 0 && null == res.get(i)) {
      i--;
    }
    res = res.subList(0, i + 1);
    return res.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if ("[]".equals(data)) {
      return null;
    }
    String dataParse = data.substring(1, data.length() - 1);
    String[] values = dataParse.split(", ");
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    queue.add(root);
    for (int i = 1; i < values.length; i++) {
      TreeNode cur = queue.poll();
      if (!"null".equals(values[i])) {
        TreeNode left = new TreeNode(Integer.parseInt(values[i]));
        cur.left = left;
        queue.add(left);
      }
      if (++i < values.length && !"null".equals(values[i])) {
        TreeNode right = new TreeNode(Integer.parseInt(values[i]));
        cur.right = right;
        queue.add(right);
      }
    }

    return root;
  }
}

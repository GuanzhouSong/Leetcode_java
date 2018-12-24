import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_508 {

  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    helper(root, map);

    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0);
      }
    });
    q.addAll(map.keySet());
    int maxNum = map.getOrDefault(q.peek(), 0);
    List<Integer> l = new LinkedList<>();
    while (map.getOrDefault(q.peek(), 0) == maxNum) {
      l.add(q.poll());
    }

    int[] res = new int[l.size()];
    for (int i = 0; i < l.size(); i++) {
      res[i] = l.get(i);
    }
    return res;
  }

  private int helper(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }
    int sum = root.val + helper(root.left, map) + helper(root.right, map);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }


}

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_239 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null) {
      return null;
    }
    int len = nums.length;
    if (len == 0) {
      return new int[0];
    }
    int[] res = new int[len - k + 1];
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i = 0; i < k; i++) {
      queue.offer(nums[i]);
    }
    res[0] = queue.peek();
    for (int i = k; i < len; i++) {
      queue.remove(nums[i - k]);
      queue.offer(nums[i]);
      res[i - k + 1] = queue.peek();
    }
    return res;

  }
}

import java.util.HashMap;
import java.util.Map;

public class Solution_532 {

  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    int count = 0;
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    if (k == 0) {
      for (int n : map.keySet()) {
        if (map.get(n) >= 2) {
          count++;
        }
      }
    } else {
      for (int n : map.keySet()) {
        if (map.containsKey(n + k)) {
          count++;
        }
      }
    }
    return count;
  }
}

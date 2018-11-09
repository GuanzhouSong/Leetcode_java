import java.util.LinkedList;
import java.util.List;

public class Solution_78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    helper(res, new LinkedList<>(), nums, 0);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums,
      int start) {
    res.add(new LinkedList<>(temp));
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      helper(res, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_15 {

  /**
   * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
   *
   * Note:
   *
   * The solution set must not contain duplicate triplets.
   *
   * Example:
   *
   * Given array nums = [-1, 0, 1, 2, -1, -4],
   *
   * A solution set is:
   * [
   * [-1, 0, 1],
   * [-1, -1, 2]
   * ]
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    int len = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      // skip same result
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = len - 1;
      int target = - nums[i];
      while(j<k){
        if(nums[j]+nums[k]==target){
          res.add(Arrays.asList(nums[i],nums[j],nums[k]));
          j++;
          k--;
          while(nums[j-1]==nums[j]){
            j++;
          }
          while(nums[k+1]==nums[k]){
            k--;
          }
        }else if(nums[j]+nums[k]>target){
          k--;
        }else {
          j++;
        }
      }
    }
    return res;
  }
}

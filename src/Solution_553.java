public class Solution_553 {

  public String optimalDivision(int[] nums) {
    String ans = "";
    if (nums.length == 0) {
      return ans;
    }
    ans = String.valueOf(nums[0]);
    if (nums.length == 1) {
      return ans;
    }
    if (nums.length == 2) {
      return ans + "/" + nums[1];
    }
    ;
    ans += "/(" + nums[1];
    for (int i = 2; i < nums.length; ++i) {
      ans += "/" + nums[i];
    }
    ans += ")";
    return ans;
  }
}

public class LeetCode55 {

  public int jump(int[] nums) {
    int n = nums.length;
    int level = 0, currentMax = 0, nextMax = 0, i = 0;
    while (currentMax - i >= 0) {
      level++;
      for (; i <= currentMax; i++) {
        nextMax = Math.max(nextMax, nums[i] + i);
        if (nextMax > n) {
          return level;
        }
      }
      currentMax = nextMax;
    }
    return 0;
  }
}

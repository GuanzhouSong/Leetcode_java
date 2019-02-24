import java.util.Arrays;

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    int fast = 0, slow = 0;
    int n = nums.length;
    while (fast < n) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    System.out.println(Arrays.toString(nums));
    return 0;
  }
}

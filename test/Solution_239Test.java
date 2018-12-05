import java.util.Arrays;
import org.junit.Test;

public class Solution_239Test {

  @Test
  public void maxSlidingWindow() {
    Solution_239 s = new Solution_239();
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 3)));
  }
}
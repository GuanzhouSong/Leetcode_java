import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class Solution_1Test {

  @Test
  public void twoSum() {
    Solution_1 s = new Solution_1();
    int[] nums = {3,2,4};
    System.out.println(nums);
    System.out.println(Arrays.toString(s.twoSum(nums,6)));

  }
}
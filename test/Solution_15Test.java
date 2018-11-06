import static org.junit.Assert.*;

import org.junit.Test;

public class Solution_15Test {

  @Test
  public void threeSum() {
    Solution_15 s = new Solution_15();
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println(s.threeSum(nums));
  }
}
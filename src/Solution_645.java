import java.util.HashSet;
import java.util.Set;

public class Solution_645 {

  public int[] findErrorNums(int[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<>(n);
    int dup = 0;
    int sum = (n * (n + 1)) / 2;
    int sumNoDup = 0;
    for (int i : nums) {
      if (set.contains(i)) {
        dup = i;

      }
      set.add(i);
      sumNoDup += i;
    }
    sumNoDup -= dup;
    return new int[]{dup, sum - sumNoDup};
  }
}

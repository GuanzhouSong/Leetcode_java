import java.util.ArrayList;
import java.util.List;

public class Solution_121 {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 1) {
      return 0;
    }
    List<Integer> minBefore = new ArrayList<>();
    minBefore.add(Integer.MAX_VALUE);
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < minBefore.get(i - 1)) {
        minBefore.add(prices[i - 1]);
      } else {
        minBefore.add(minBefore.get(i - 1));
      }
    }
    int resMax = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] - minBefore.get(i) > resMax) {
        resMax = prices[i] - minBefore.get(i);
      }
    }
    return resMax < 0 ? 0 : resMax;
  }
}

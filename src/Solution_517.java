public class Solution_517 {

  public int findMinMoves(int[] machines) {
    int total = 0;
    for (int n : machines) {
      total += n;
    }
    if (total % machines.length != 0) {
      return -1;
    }
    int avg = total / machines.length;
    int max = 0, cnt = 0;
    for (int n : machines) {
      cnt += (n - avg);
      max = Math.max(max, Math.max(Math.abs(cnt), n - avg));
    }
    return max;
  }
}

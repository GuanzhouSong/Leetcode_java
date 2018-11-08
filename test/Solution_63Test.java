public class Solution_63Test {

  @org.junit.Test
  public void uniquePathsWithObstacles() {
    Solution_63 s = new Solution_63();
    int[][] res = {{0, 0, 1, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}};
    s.uniquePathsWithObstacles(res);
  }
}
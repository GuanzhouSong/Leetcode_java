public class Solution_200 {

  private int m;
  private int n;

  public int numIslands(char[][] grid) {
    n = grid.length;
    if (n == 0) {
      return 0;
    }
    int count = 0;
    m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          helper(i, j, grid);
          count++;
        }
      }
    }
    return count;
  }

  public void helper(int i, int j, char[][] grid) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = '0';
    helper(i - 1, j, grid);
    helper(i, j - 1, grid);
    helper(i + 1, j, grid);
    helper(i, j + 1, grid);
  }
}

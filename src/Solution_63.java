public class Solution_63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
    for (int i = 0; i < obstacleGrid.length; i++) {
      for (int j = 0; j < obstacleGrid[0].length; j++) {
        res[i][j] = 0;
      }
    }
    for (int i = 0; i < obstacleGrid.length; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      } else {
        res[i][0] = 1;
      }
    }
    for (int j = 0; j < obstacleGrid[0].length; j++) {
      if (obstacleGrid[0][j] == 1) {
        break;
      } else {
        res[0][j] = 1;
      }
    }
    for (int i = 1; i < obstacleGrid.length; i++) {
      for (int j = 1; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 0) {
          res[i][j] = res[i - 1][j] + res[i][j - 1];
        }
      }
    }
    return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }
}

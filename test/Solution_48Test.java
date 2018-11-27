import org.junit.Test;

public class Solution_48Test {

  @Test
  public void rotate() {
    int[][] matrix = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    Solution_48 s = new Solution_48();
    s.rotate(matrix);
    System.out.print(matrix);
  }
}
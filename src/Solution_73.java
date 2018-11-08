import java.util.HashSet;

public class Solution_73 {

  public void setZeroes(int[][] matrix) {
    HashSet<Integer> emptyCol = new HashSet<>();
    HashSet<Integer> emptyRow = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          emptyCol.add(i);
          emptyRow.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (emptyCol.contains(i)) {
        for (int j = 0; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int j = 0; j < matrix[0].length; j++) {
      if (emptyRow.contains(j)) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }

  }
}

import java.util.LinkedList;
import java.util.List;

public class Solution_119 {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new LinkedList<>();
    if (rowIndex < 0) {
      return res;
    }
    for (int i = 0; i <= rowIndex; i++) {
      res.add(1);
      for (int j = i - 1; j > 0; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }
    return res;
  }


}

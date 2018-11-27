import java.util.LinkedList;
import java.util.List;

public class Solution_89 {

  public List<Integer> grayCode(int n) {
    if (n < 0) {
      return new LinkedList<>();
    }
    if (n == 0) {
      List<Integer> l = new LinkedList<>();
      l.add(0);
      return l;
    }
    List<Integer> temp = grayCode(n - 1);
    List<Integer> res = new LinkedList<>(temp);
    int addOn = 1 << (n - 1);
    for (int i = temp.size() - 1; i >= 0; i--) {
      res.add(addOn + temp.get(i));
    }
    return res;
  }

  public void re() {
    String s = "Jimmy has an apple, it is on the table";
    String[] res = s.split("\\W+");
    System.out.println(res[1]);
  }

}

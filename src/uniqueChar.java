
import java.util.Arrays;

public class uniqueChar {

  public String getUniqueString(String s) {
    int[] countArray = new int[256];
    Arrays.fill(countArray, 0);
    StringBuffer sb = new StringBuffer();
    for (char c : s.toCharArray()) {
      if (countArray[c] == 0) {
        sb.append(c);
      }
      countArray[c]++;
    }
    return sb.toString();

  }
}

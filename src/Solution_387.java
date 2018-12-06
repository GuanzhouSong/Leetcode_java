import java.util.HashMap;
import java.util.Map;

public class Solution_387 {

  public int firstUniqChar(String s) {

    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      int count = map.getOrDefault(c, 0);
      map.put(c, ++count);
    }
    for (int i = 0; i < s.length(); i++) {
      if (map.get(chars[i]) == 1) {
        return i;
      }
    }
    return -1;
  }
}

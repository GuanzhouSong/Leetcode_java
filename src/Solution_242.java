import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_242 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      int count = map.getOrDefault(c, 0);
      map.put(c, --count);
    }
    for (char c : t.toCharArray()) {
      int count = map.getOrDefault(c, 0);
      map.put(c, --count);
    }
    for (Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() != 0) {
        return false;
      }
    }
    return true;
  }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution_451 {

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    List<Character>[] bucket = new List[s.length() + 1];
    for (char key : map.keySet()) {
      int freq = map.getOrDefault(key, 0);
      if (bucket[freq] == null) {
        bucket[freq] = new LinkedList<>();
      }
      bucket[freq].add(key);
    }
    StringBuilder sb = new StringBuilder();
    for (int pos = bucket.length - 1; pos >= 0; pos--) {
      if (bucket[pos] != null) {
        for (char c : bucket[pos]) {
          for (int i = 0; i < map.get(c); i++) {
            sb.append(c);
          }
        }
      }
    }
    return sb.toString();
  }
}

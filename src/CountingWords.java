import java.util.HashMap;
import java.util.Map;

public class CountingWords {

  public String countWorld(String s) {
    Map<String, Integer> countingMap = new HashMap();
    StringBuffer sb = new StringBuffer();
    s.trim();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        String word = sb.toString();
        int count = countingMap.getOrDefault(word, 0);
        countingMap.put(word, ++count);
        sb = new StringBuffer();
      } else if ((c - 'a' >= 0 && c - 'a' <= 26) || (c - 'A' >= 0 && c - 'A' <= 26)) {
        sb.append(c);
      }
    }
    String word = sb.toString();
    int count = countingMap.getOrDefault(word, 0);
    countingMap.put(word, ++count);
    return countingMap.toString();
  }
}

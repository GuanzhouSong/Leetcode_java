import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Solution_49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> answer = new ArrayList<>();

    HashMap<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      String string = strs[i];
      int[] array = new int[26];
      for (int j = 0; j < string.length(); j++) {
        array[string.charAt(j) - 'a']++;
      }
      String key = createString(array);
      List<String> l = map.getOrDefault(key, new LinkedList<>());
      l.add(string);
      map.put(key, l);
    }

    for (Entry<String, List<String>> entry : map.entrySet()) {
      answer.add(entry.getValue());
    }

    return answer;
  }

  private String createString(int[] array) {
    String s = "";
    for (int i = 0; i < array.length; i++) {
      int letter = array[i];
      for (int j = 0; j < letter; j++) {
        s = s + (char) ('a' + i);
      }
    }
    return s;
  }
}

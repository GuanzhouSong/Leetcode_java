import java.util.LinkedList;
import java.util.List;

public class Solution_17 {

  public List<String> letterCombinations(String digits) {
    List<String> res = new LinkedList<>();
    helper(digits, 0, "", res);
    return res;
  }

  private void helper(String digits, int index, String s, List<String> res) {
    if (index == digits.length() || s.length() == digits.length()) {
      if (s.length() > 0) {
        res.add(s);
      }
      return;
    }
    String[] array = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String num = array[digits.charAt(index) - '2'];
    for (int i = 0; i < num.length(); i++) {
      String new_word = s + num.charAt(i);
      helper(digits, index + 1, new_word, res);
    }
  }
}

import java.util.HashMap;

public class Solution_3 {
/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

  public int lengthOfLongestSubstring(String s) {
    int prev = 0;
    int maxLength = 0;
    HashMap<Character, Integer> h = new HashMap(s.length());
    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);
      if (h.containsKey(c)) {

        for (int j = prev; j < h.get(c); j++) {
          char t = s.charAt(j);
          h.remove(t);
        }
        prev = h.get(c) + 1;
        h.replace(c, i);
      } else {
        h.put(c, i);
      }
      if (i - prev + 1 > maxLength) {
        maxLength = i - prev + 1;
      }
    }
    return maxLength;
  }
}

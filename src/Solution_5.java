class Solution_5 {

  /*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/
  public String longestPalindrome(String s) {
    if (null == s || s.length() < 1) {
      return "";
    }
    int left = 0;
    int right = 0;
    for (int i = 0; i < s.length(); i++) {
      int t1 = findMaxPar(s, i, i);
      int t2 = findMaxPar(s, i, i + 1);
      int len = Math.max(t1, t2);
      if (len > right - left) {
        left = i - (len - 1) / 2;
        right = i + len / 2;
      }
    }
    return s.substring(left, right + 1);
  }

  public int findMaxPar(String s, int left, int right) {
    //check boundary first or will throw outofbond exception
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left -= 1;
      right += 1;
    }
    return right - left - 1;
  }
}
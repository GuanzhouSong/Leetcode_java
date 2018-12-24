public class Solution_516 {

  public int longestPalindromeSubseq(String s) {
    int len = s.length();
    int[][] opt = new int[len][len];
    for (int i = len - 1; i >= 0; i--) {
      opt[i][i] = 1;
      for (int j = i + 1; j < len; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          opt[i][j] = opt[i + 1][j - 1] + 2;
        } else {
          opt[i][j] = Math.max(opt[i + 1][j], opt[i][j - 1]);
        }
      }
    }
    return opt[0][len - 1];
  }
}

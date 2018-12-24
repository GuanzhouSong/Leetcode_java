public class Solution_459 {

  public boolean repeatedSubstringPattern(String s) {
    String ss = s + s;
    String ss2 = ss.substring(1, ss.length() - 1);
    return ss2.contains(s);
  }
}

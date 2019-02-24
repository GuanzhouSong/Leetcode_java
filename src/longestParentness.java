import java.util.Arrays;

public class longestParentness {

  public int find(String s) {
    if (null == s || s.length() < 1) {
      return 0;
    }
    int curMax = 0;
    int[] longest = new int[s.length()];
    Arrays.fill(longest, 0);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          longest[i] =
              (i >= 2) ? longest[i - 2] + 2 : 2;
          curMax = Math.max(longest[i], curMax);
        } else {
          if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
            longest[i] =
                longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1]
                    - 2] : 0);
            curMax = Math.max(longest[i], curMax);
          }
        }
      }
    }
    return curMax;
  }
}

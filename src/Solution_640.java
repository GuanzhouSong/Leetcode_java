public class Solution_640 {

  public String solveEquation(String equation) {
    if (equation == null || equation.length() < 3) {
      return "No solution";
    }
    String[] equations = equation.split("=");
    String[] l = equations[0].replaceAll("-", "+-").split("\\+");
    String[] r = equations[1].replaceAll("-", "+-").split("\\+");
    int[] sum = new int[2];
    for (String s : l) {
      if (s.length() < 1) {
        continue;
      } else if (s.equals("x")) {
        ++sum[0];
      } else if (s.equals("-x")) {
        --sum[0];
      } else if (s.charAt(s.length() - 1) == 'x') {
        sum[0] += Integer.parseInt(s.substring(0, s.length() - 1));
      } else {
        sum[1] += Integer.parseInt(s);
      }
    }
    for (String s : r) {
      if (s.length() < 1) {
        continue;
      } else if (s.equals("x")) {
        --sum[0];
      } else if (s.equals("-x")) {
        ++sum[0];
      } else if (s.charAt(s.length() - 1) == 'x') {
        sum[0] -= Integer.parseInt(s.substring(0, s.length() - 1));
      } else {
        sum[1] -= Integer.parseInt(s);
      }
    }
    return sum[0] == 0 ? (sum[1] == 0 ? "Infinite solutions" : "No solution")
        : "x=" + (-sum[1] / sum[0]);
  }
}

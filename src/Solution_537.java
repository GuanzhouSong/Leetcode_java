public class Solution_537 {

  public String complexNumberMultiply(String a, String b) {
    a = a.substring(0, a.length() - 1);
    b = b.substring(0, b.length() - 1);
    String[] A = a.split("\\+");
    String[] B = b.split("\\+");
    int a1 = Integer.parseInt(A[0]);
    int b1 = Integer.parseInt(A[1]);
    int a2 = Integer.parseInt(B[0]);
    int b2 = Integer.parseInt(B[1]);
    int a3 = a1 * a2 - b1 * b2;
    int b3 = a1 * b2 + a2 * b1;
    return String.valueOf(a3) + "+" + String.valueOf(b3);
  }
}

import java.util.Arrays;

public class Google_OA_1 {

  public static int[] findAncester(int D, int[] A) {
    int[] res = new int[0];
    for (int i = 0; i < A.length; i++) {
      int ans = A[i];
      int time = D - 1;
      while (ans >= 0 && time > 0) {
        ans = A[ans];
        time--;
      }
      res[i] = ans;

    }
    System.out.println(Arrays.toString(res));
    return res;
  }

  public static void main(String[] args) {
    int[] A = {-1, 0, 4, 2, 1};
    findAncester(3, A);
  }

}

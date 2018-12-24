public class Solution_396 {

  public int maxRotateFunction(int[] A) {

    int allSum = 0, F = 0;
    int length = A.length;
    for (int i = 0; i < length; i++) {
      F += i * A[i];
      allSum += A[i];
    }
    int max = F;
    for (int i = length - 1; i > 0; i--) {
      F = F + allSum - length * A[i];
      max = Math.max(max, F);
    }

    return max;
  }

}

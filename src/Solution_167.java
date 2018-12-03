public class Solution_167 {

  public int[] twoSum(int[] numbers, int target) {
    int lower = 0;
    int higher = numbers.length;
    int[] res = new int[2];
    while (lower < higher) {
      if (numbers[lower] + numbers[higher] == target) {
        res[0] = lower + 1;
        res[1] = higher + 1;
        return res;
      } else if (numbers[lower] + numbers[higher] < target) {
        lower++;

      } else {
        higher--;
      }
    }
    return null;
  }
}

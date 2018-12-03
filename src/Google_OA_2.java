import java.util.Arrays;

public class Google_OA_2 {

  public static int[] findCloest(int[] store, int[] house) {
    int[] res = new int[house.length];
    Arrays.sort(store);
    for (int i = 0; i < house.length; i++) {
      res[i] = findCloestnum(store, house[i]);
    }
    System.out.println(Arrays.toString(res));
    return res;
  }

  public static int findCloestnum(int[] store, int house) {
    int low = 0;
    int high = store.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (store[mid] == house) {
        low = mid;
        break;
      } else if (store[mid] > house) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (low == store.length) {
      return store[low - 1];
    }
    if (low == 0) {
      return store[0];
    }
    if ((house - store[low - 1]) > (store[low] - house)) {

      return store[low];
    } else {
      return store[low - 1];
    }

  }

  public static void main(String[] args) {
    int[] store = {1, 5, 20, 11, 16};
    int[] sortedArray = {1, 5, 11, 16, 20};
    int[] house = {5, 10, 17, 10, 17};
    findCloest(sortedArray, house);
  }

}

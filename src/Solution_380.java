import java.util.ArrayList;
import java.util.HashMap;

class Solution_380 {

  /**
   * Initialize your data structure here.
   */
  HashMap<Integer, Integer> locs;
  ArrayList<Integer> nums;
  java.util.Random rand = new java.util.Random();

  public Solution_380() {
    nums = new ArrayList<Integer>();
    locs = new HashMap<Integer, Integer>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (locs.containsKey(val)) {
      return false;
    }
    locs.put(val, nums.size());
    nums.add(val);
    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    if (!locs.containsKey(val)) {
      return false;
    }
    int loc = locs.get(val);
    if (loc < nums.size() - 1) {
      int last = nums.get(nums.size() - 1);
      nums.set(loc, last);
      locs.put(last, loc);
    }
    locs.remove(val);
    nums.remove(nums.size() - 1);
    return true;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    return nums.get(rand.nextInt(nums.size()));
  }
}

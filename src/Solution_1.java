import java.util.HashMap;

class Solution_1 {

  /*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.

  Example:

  Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].*/


  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> numMap = new HashMap(nums.length);
    for(int i = 0;i< nums.length;i++){
      numMap.put(nums[i],i);
    }
    for(int i = 0;i< nums.length;i++){
      if(numMap.containsKey(target-nums[i]) && numMap.get(target-nums[i])!=i){
        int[] res = {i,numMap.get(target-nums[i])};
        return res;
      }
    }
    return null;
  }
}
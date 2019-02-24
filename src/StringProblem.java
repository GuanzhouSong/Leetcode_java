import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringProblem {

  public static String findLongestUniqueSubstring(String s) {
    int[] index = new int[256];
    Arrays.fill(index, -1);
    int longest = 0, m = 0;
    int maxHead = 0;
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      m = Math.max(index[curChar] + 1, m);
      index[curChar] = i;
      if (i - m + 1 > longest) {
        longest = i - m + 1;
        maxHead = m;
      }
    }
    System.out.println(maxHead);
    return s.substring(maxHead, maxHead + longest);
  }

  public List<Integer> slidingWindowTemplate(String s, String t) {
    //init a collection or int value to save the result according the question.
    List<Integer> result = new LinkedList<>();
    if (t.length() > s.length()) {
      return result;
    }
    //create a hashmap to save the Characters of the target substring.
    //(K, V) = (Character, Frequence of the Characters)
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    //maintain a counter to check whether match the target string.
    int counter = map.size();
    //must be the map size, NOT the string size because the char may be duplicate.

    //Two Pointers: begin - left pointer of the window; end - right pointer of the window
    int begin = 0, end = 0;

    //the length of the substring which match the target string.
    int len = Integer.MAX_VALUE;

    //loop at the begining of the source string
    while (end < s.length()) {

      char c = s.charAt(end);
      //get a character
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        // plus or minus one
        if (map.get(c) == 0) {
          counter--;
          //modify the counter according the requirement(different condition).
        }
      }
      end++;

      //increase begin pointer to make it invalid/valid again
      while (counter
          == 0 /* counter condition. different question may have different condition */) {

        char tempc = s.charAt(
            begin);
        //***be careful here: choose the char at begin pointer, NOT the end pointer
        if (map.containsKey(tempc)) {
          map.put(tempc, map.get(tempc) + 1);
          //plus or minus one
          if (map.get(tempc) > 0) {
            counter++;
            //modify the counter according the requirement(different condition).
          }
        }

        /* save / update(min/max) the result if find a target*/
        // result collections or result int value

        begin++;
      }
    }
    return result;
  }


/*  Given a string, find the length of the longest substring without repeating characters.

  Example 1:

  Input: "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.*/

  /*Given a string S and a string T, find the minimum window in S
  which will contain all the characters in T in complexity O(n).
  Example:
  Input: S = "ADOBECODEBANC", T = "ABC"
  Output: "BANC"*/
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int counter = map.size();

    int begin = 0, end = 0;
    int head = 0;
    int len = Integer.MAX_VALUE;

    while (end < s.length()) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          counter--;
        }
      }
      end++;

      while (counter == 0) {
        char tempc = s.charAt(begin);
        if (map.containsKey(tempc)) {
          map.put(tempc, map.get(tempc) + 1);
          if (map.get(tempc) > 0) {
            counter++;
          }
        }
        if (end - begin < len) {
          len = end - begin;
          head = begin;
        }
        begin++;
      }

    }
    if (len == Integer.MAX_VALUE) {
      return "";
    }
    return s.substring(head, head + len);
  }

  public int lengthOfLongestUniqueSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int begin = 0, end = 0, counter = 0, d = 0;

    while (end < s.length()) {
      // > 0 means repeating character
      //if(map[s.charAt(end++)]-- > 0) counter++;
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) > 1) {
        counter++;
      }
      end++;

      while (counter > 0) {
        //if (map[s.charAt(begin++)]-- > 1) counter--;
        char charTemp = s.charAt(begin);
        if (map.get(charTemp) > 1) {
          counter--;
        }
        map.put(charTemp, map.get(charTemp) - 1);
        begin++;
      }
      d = Math.max(d, end - begin);
    }
    return d;
  }

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, end = 0, counter = 0, len = 0;
    while (end < s.length()) {
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) == 1) {
        counter++;//new char
      }
      end++;
      while (counter > 2) {
        char cTemp = s.charAt(start);
        map.put(cTemp, map.get(cTemp) - 1);
        if (map.get(cTemp) == 0) {
          counter--;
        }
        start++;
      }
      len = Math.max(len, end - start);
    }
    return len;
  }

  /*
    You are given a string, s, and a list of words, words,
    that are all of the same length. Find all starting indices of substring(s) in s that
     is a concatenation of each word in words exactly once and without any intervening characters.

    Example 1:

    Input:
    s = "barfoothefoobarman",
    words = ["foo","bar"]
    Output: [0,9]
    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    The output order does not matter, returning [9,0] is fine too.*/
  public List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new LinkedList<>();
    if (L.length == 0 || S.length() < L.length * L[0].length()) {
      return res;
    }
    int N = S.length();
    int M = L.length; // *** length
    int wl = L[0].length();
    Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
    for (String s : L) {
      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }
    String str = null, tmp = null;
    for (int i = 0; i < wl; i++) {
      int count = 0;  // remark: reset count
      int start = i;
      for (int r = i; r + wl <= N; r += wl) {
        str = S.substring(r, r + wl);
        if (map.containsKey(str)) {
          if (curMap.containsKey(str)) {
            curMap.put(str, curMap.get(str) + 1);
          } else {
            curMap.put(str, 1);
          }

          if (curMap.get(str) <= map.get(str)) {
            count++;
          }
          while (curMap.get(str) > map.get(str)) {
            tmp = S.substring(start, start + wl);
            curMap.put(tmp, curMap.get(tmp) - 1);
            start += wl;

            //the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
            if (curMap.get(tmp) < map.get(tmp)) {
              count--;
            }

          }
          if (count == M) {
            res.add(start);
            tmp = S.substring(start, start + wl);
            curMap.put(tmp, curMap.get(tmp) - 1);
            start += wl;
            count--;
          }
        } else {
          curMap.clear();
          count = 0;
          start = r + wl;//not contain, so move the start
        }
      }
      curMap.clear();
    }
    return res;
  }
}
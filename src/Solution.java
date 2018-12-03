import java.util.LinkedList;
import java.util.Stack;

class Solution {

  public static String solution(String S, int K) {
    // write your code in Java SE 8
    S = S.replaceAll("-", "").toUpperCase();
    LinkedList<Character> list = new LinkedList<>();
    char[] chararray = S.toCharArray();
    Stack<Character> stack = new Stack();
    int counter = K;
    for (int i = 0; i < S.length(); i++) {
      stack.push(chararray[i]);
    }
    while (!stack.isEmpty()) {
      counter--;
      list.addFirst(stack.pop());
      if (counter == 0) {
        list.addFirst('-');
        counter = K;
      }

    }
    StringBuilder builder = new StringBuilder(list.size());
    for (Character ch : list) {
      builder.append(ch);
    }
    String res = builder.toString();
    if (res.charAt(0) == '-') {
      res = res.substring(1);
    }
    return res;


  }

  public static void main(String[] args) {
    String S = "12ab";
    System.out.println(solution(S, 4));
  }
}
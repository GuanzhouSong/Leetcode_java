import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution_20 {

  public boolean isValid(String s) {
    HashMap<Character, Character> re = new HashMap();
    re.put('(', ')');
    re.put(')', '(');
    re.put('[', ']');
    re.put(']', '[');
    re.put('{', '}');
    re.put('}', '{');
    HashSet symbol = new HashSet();
    symbol.add('(');
    symbol.add('{');
    symbol.add('[');
    Stack<Character> stack = new Stack();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (symbol.contains(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char pop = stack.pop();
        if (pop != re.get(c)) {
          return false;
        }
      }
    }
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isValidv_2(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}

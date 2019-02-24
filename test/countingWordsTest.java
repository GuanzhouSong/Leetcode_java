import org.junit.Test;

public class countingWordsTest {

  uniqueChar p = new uniqueChar();

  @Test
  public void checkOrder() {
    String s = p.getUniqueString("I really really like you!");
    System.out.println(s);
  }
}
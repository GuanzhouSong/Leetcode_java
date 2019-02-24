
import org.junit.Test;

public class RemoveElementTest {

  ShortestPathIn2DArray r = new ShortestPathIn2DArray();

  @Test
  public void removeElement() {
    char grid[][] = {{'0', '*', '0', 's'},
        {'*', '0', '*', '*'},
        {'0', '*', '*', '*'},
        {'d', '0', '0', '0'}};
    System.out.println(r.findDist(grid));
  }
}
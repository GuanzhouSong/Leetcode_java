import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathIn2DArray {

  public int findDist(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    position source = new position(0, 0, 0);
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 's') {
          source.row = i;
          source.col = j;
        }
        if (grid[i][j] == '0') {
          visited[i][j] = true;
        } else {
          visited[i][j] = false;
        }
      }
    }

    Queue<position> q = new LinkedList<>();
    q.add(source);
    while (!q.isEmpty()) {
      position cur = q.poll();
      //Found it.
      if (grid[cur.row][cur.col] == 'd') {
        return cur.dist;
      }

      //Moving up.
      if (cur.row - 1 >= 0 && !visited[cur.row - 1][cur.col]) {
        q.offer(new position(cur.row - 1, cur.col, cur.dist + 1));
        visited[cur.row - 1][cur.col] = true;
      }

      //Moving down.
      if (cur.row + 1 < grid.length && !visited[cur.row + 1][cur.col]) {
        q.offer(new position(cur.row + 1, cur.col, cur.dist + 1));
        visited[cur.row + 1][cur.col] = true;
      }

      //Moving left.
      if (cur.col - 1 >= 0 && !visited[cur.row][cur.col - 1]) {
        q.offer(new position(cur.row, cur.col - 1, cur.dist + 1));
        visited[cur.row][cur.col - 1] = true;
      }

      //Moving right.
      if (cur.col + 1 < grid[0].length && !visited[cur.row][cur.col + 1]) {
        q.offer(new position(cur.row, cur.col + 1, cur.dist + 1));
        visited[cur.row][cur.col + 1] = true;
      }


    }
    return -1;
  }

  class position {

    int row;
    int col;
    int dist;

    public position(int r, int c, int d) {
      this.row = r;
      this.col = c;
      this.dist = d;
    }
  }

}

package kata;

import java.util.LinkedList;

public class Dioph {
  public String solEquaStr(long n) {
    // x2 - 4 * y2 = n
    LinkedList<String> results = new LinkedList<>();
    for (int i = 0; i < n/2+2; i++) {
      for (int j = 0; j < n/2+2; j++) {
        if (((long) i * i - 4L * j * j) == n) {
          results.addFirst(String.format("[%d, %d]", i, j));
        }
      }
    }
    if (results.isEmpty()) {
      return "[]";
    }
    return results.toString();
  }
}

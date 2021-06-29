package kata;

import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateChar {
  public  int duplicateCount(String text) {
    return (int) text
      .codePoints()
      .map(Character::toLowerCase)
      .mapToObj(c -> (char) c)
      .collect(Collectors
        .groupingBy(Function.identity(), Collectors.counting()))
      .values()
      .stream()
      .filter(aLong -> aLong > 1)
      .count();
  }

  public  int findIt(int[] a) {
    int xor = 0;
    for (int j : a) {
      xor ^= j;
    }
    return xor;
  }
}

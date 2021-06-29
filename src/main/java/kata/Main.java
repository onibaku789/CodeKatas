package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

  }

  public static String pigIt(String str) {
    String[] words = str.split(" ");
    List<String> resultWords = new ArrayList<>();
    for (String word : words) {
      String firstLetter = word.substring(0, 1);
      if (!(Pattern.matches("\\p{Punct}", firstLetter))) {
        String subString = word.substring(1);
        resultWords.add(subString + firstLetter + "ay");
      } else {
        resultWords.add(word);
      }
    }
    return String.join(" ", resultWords);
  }

  private static void mergeOp() {
    List<Integer> first = List.of(1, 2, 3, 4);
    List<Integer> second = List.of(5, 6, 7, 8);
    List<Integer> third = List.of(9, 10, 11, 12);
    MergeIterator<Integer> mergeIterator = new MergeIterator<>(first, second, third);
    while (mergeIterator.hasNext()) {
      System.out.println(mergeIterator.next());
    }
  }

  public static int digital_root(int n) {
    return (1 + (n - 1) % 9);
  }

  private static int digital_helper(int n) {
    if (n < 10) {
      return n;
    }
    return (n % 10) + digital_helper(n / 10);
  }
}

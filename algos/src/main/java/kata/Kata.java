package kata;

public class Kata {
  public static float tArea(String tStr) {
    String[] split = tStr.split("\n");
    int h = split.length - 2;
    System.out.println(h);
    int b = split[split.length - 1].split(" ").length - 1;
    System.out.println(b);
    return h * b * 0.5f;
  }
}

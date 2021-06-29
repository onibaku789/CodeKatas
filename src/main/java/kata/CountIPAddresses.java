package kata;

public class CountIPAddresses {

  public long ipsBetween(String start, String end) {
    int result = 0;
    String[] startArray = start.split("\\.");
    String[] endArray = end.split("\\.");
    for (int i = startArray.length - 1; i >= 0; i--) {
      result += (Integer.parseInt(endArray[i]) - Integer.parseInt(startArray[i])) * Math.pow(256, startArray.length - 1 - i);
    }
    return result;
  }
}

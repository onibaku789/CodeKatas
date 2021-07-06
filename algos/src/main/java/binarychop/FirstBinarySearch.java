package binarychop;

public class FirstBinarySearch implements BinarySearch {
  @Override
  public int search(int numberToSearch, int[] array) {
    int leftBound = 0;
    int rightBound = array.length - 1;
    while (leftBound <= rightBound) {
      int half = (int) Math.floor((double) (leftBound + rightBound) / 2d);
      if (array[half] < numberToSearch) {
        leftBound = half + 1;
      } else if (array[half] > numberToSearch) {
        rightBound = half - 1;
      } else {
        return half;
      }
    }
    return -1;
  }
}

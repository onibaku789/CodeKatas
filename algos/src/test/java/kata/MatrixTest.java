package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MatrixTest {

  //{ { 1, 3 }, { 2, 5 } },
  //{ { 2, 5, 3 }, { 1, -2, -1 }, { 1, 3, 4 } } };
  private static int[] expected = { 1, -1, -20 };
  private static String[] msg = { "Determinant of a 1 x 1 matrix yields the value of the one element",
    "Should return 1 * 5 - 3 * 2 == -1 ",
    "" };
  private Matrix underTest;

  @Test
  public void determinantShouldReturnOneIfOnlyOneElementContainsWhichIsOne() {
    int[][] matrix = { { 1 } };
    assertEquals(1, Matrix.determinant(matrix), "Determinant of a 1 x 1 matrix yields the value of the one element");
  }

  @Test
  public void determinantShouldReturnTwoIfOnlyOneElementContainsWhichIsTwo() {
    int[][] matrix = { { 2 } };
    assertEquals(2, Matrix.determinant(matrix), "Determinant of a 1 x 1 matrix yields the value of the one element");
  }

  @Test
  public void sampleTests() {
    int[][] matrix = { { 1, 3 },
      { 2, 5 } };
    assertEquals(-1, Matrix.determinant(matrix), "Determinant of a 1 x 1 matrix yields the value of the one element");
  }

  @Test
  public void determinantWithMoreThanTwoDMatrixShouldReturnZero() {
    int[][] matrix = { { 0, 0, 0 },
      { 0, 0, 0 },
      { 0, 0, 0 } };
    assertEquals(0, Matrix.determinant(matrix), "Determinant of a 1 x 1 matrix yields the value of the one element");
  }

  @Test
  public void determinantWithMoreThanTwoDMatrixShouldReturnMinusTwenty() {
    int[][] matrix = { { 2, 5, 3 },
      { 1, -2, -1 },
      { 1, 3, 4 } };
    assertEquals(-20, Matrix.determinant(matrix), "Determinant of a 1 x 1 matrix yields the value of the one element");
  }
}

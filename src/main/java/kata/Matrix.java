package kata;

public class Matrix {
  public static int determinant(int[][] matrix) {
    int[][] temporary;
    int result = 0;

    if (matrix.length == 1) {
      result = matrix[0][0];
      return (result);
    }

    if (matrix.length == 2) {
      result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
      return (result);
    }

    for (int i = 0; i < matrix[0].length; i++) {
      temporary = new int[matrix.length - 1][matrix[0].length - 1];

      for (int j = 1; j < matrix.length; j++) {
        for (int k = 0; k < matrix[0].length; k++) {
          if (k < i) {
            temporary[j - 1][k] = matrix[j][k];
          } else if (k > i) {
            temporary[j - 1][k - 1] = matrix[j][k];
          }
        }
      }
      result += matrix[0][i] * Math.pow(-1, i) * determinant(temporary);
    }
    return (result);
  }
}

package binarychop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FirstBinarySearchTest {

  private FirstBinarySearch underTest;

  private static Stream<Arguments> provideParameters() {
    return Stream.of(
      Arguments.of(-1, 3, new int[] {}),
      Arguments.of(-1, 3, new int[] { 1 }),
      Arguments.of(0, 1, new int[] { 1 }),
      Arguments.of(0, 1, new int[] { 1, 3, 5 }),
      Arguments.of(1, 3, new int[] { 1, 3, 5 }),
      Arguments.of(2, 5, new int[] { 1, 3, 5 }),
      Arguments.of(-1, 0, new int[] { 1, 3, 5 }),
      Arguments.of(-1, 2, new int[] { 1, 3, 5 }),
      Arguments.of(-1, 4, new int[] { 1, 3, 5 }),
      Arguments.of(-1, 6, new int[] { 1, 3, 5 }),
      Arguments.of(0, 1, new int[] { 1, 3, 5, 7 }),
      Arguments.of(1, 3, new int[] { 1, 3, 5, 7 }),
      Arguments.of(2, 5, new int[] { 1, 3, 5, 7 }),
      Arguments.of(3, 7, new int[] { 1, 3, 5, 7 }),
      Arguments.of(-1, 0, new int[] { 1, 3, 5, 7 }),
      Arguments.of(-1, 2, new int[] { 1, 3, 5, 7 }),
      Arguments.of(-1, 4, new int[] { 1, 3, 5, 7 }),
      Arguments.of(-1, 6, new int[] { 1, 3, 5, 7 }),
      Arguments.of(-1, 8, new int[] { 1, 3, 5, 7 })
    );
  }

  @BeforeEach
  void setUp() {
    underTest = new FirstBinarySearch();
  }

  @AfterEach
  void tearDown() {
    underTest = null;
  }

  @ParameterizedTest
  @MethodSource("provideParameters")
  void search(int expected, int numberToSearch, int[] array) {
    //GIVEN

    //WHEN
    int actual = underTest.search(numberToSearch, array);
    //THEN
    assertEquals(expected, actual);

  }
}

package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiophTest {

  private Dioph underTest;

  @BeforeEach
  void setup() {
    underTest = new Dioph();
  }

  @ParameterizedTest
  @MethodSource("provideParameters")
  public void test5(String expected, int number) {
    assertEquals(expected, underTest.solEquaStr(number));
  }

  private static Stream<Arguments> provideParameters() {
    return Stream.of(
      Arguments.of("[]", 90002),
      Arguments.of("[[3, 1]]", 5),
      Arguments.of("[[4, 1]]", 12),
      Arguments.of("[[7, 3]]", 13),
      Arguments.of("[[4, 0]]", 16),
      Arguments.of("[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]", 90005)
    );
  }

}

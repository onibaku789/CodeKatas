package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DinglemouseTest {

  private Dinglemouse underTest;

  @BeforeEach
  public void setUp() {
    underTest = new Dinglemouse();
  }

  @Test
  public void testSomeDots() {
    assertEquals("one-two-three", underTest.replaceDots("one.two.three"));
  }
}

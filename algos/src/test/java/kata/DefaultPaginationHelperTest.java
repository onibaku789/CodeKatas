package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultPaginationHelperTest {

  private DefaultPaginationHelper<Character> underTest;

  @BeforeEach
  void setUp() {
    underTest = new DefaultPaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
  }

  @AfterEach
  void tearDown() {
    underTest = null;
  }

  @Test
  void pageCount() {
    assertEquals(2, underTest.pageCount());
  }

  @Test
  void pageCountWithEmptyCollection() {
    underTest = new DefaultPaginationHelper<>(Collections.emptyList(), 0);
    assertEquals(0, underTest.pageCount());
  }

  @Test
  void itemCount() {
    assertEquals(6, underTest.itemCount());
  }

  @Test
  void pageIndex() {
    assertEquals(1, underTest.pageIndex(5));
  }

  @Test
  void pageIndexWithTwo() {
    assertEquals(0, underTest.pageIndex(2));
  }

  @Test
  void pageIndexWithTwenty() {
    assertEquals(-1, underTest.pageIndex(20));
  }

  @Test
  void pageIndexWithMinusTwenty() {
    assertEquals(-1, underTest.pageIndex(-20));
  }

  @Test
  public void pageItemCountWithZero() {
    assertEquals(4, underTest.pageItemCount(0));
  }

  @Test
  public void pageItemCountWithOne() {
    assertEquals(2, underTest.pageItemCount(1));
  }

  @Test
  public void pageItemCountWithInvalid() {
    assertEquals(-1, underTest.pageItemCount(2));
  }
}

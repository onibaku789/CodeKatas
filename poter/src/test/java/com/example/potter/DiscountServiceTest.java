package com.example.potter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

  private DiscountService underTest;

  @BeforeEach
  void setUp() {
    underTest = new DiscountService();
  }

  @AfterEach
  void tearDown() {
    underTest = null;
  }

  @Test
  void calculateOptimizedTotalPriceShouldReturnZeroWhenAnEmptyListGiven() {
    //GIVEN

    //WHEN
    double actual = underTest.calculateOptimizedTotalPrice(Collections.emptyList());
    //THEN
    assertEquals(0.0, actual);
  }

  @Test
  void calculateOptimizedTotalPriceShouldReturnSingleBookPriceWhenSingleBookGiven() {
    //GIVEN
    List<Book> books = Arrays.asList(new Book("asd"));
    //WHEN
    double actual = underTest.calculateOptimizedTotalPrice(books);
    //THEN
    assertEquals(8.0, actual);
  }

  @Test
  void asd2() {
    //GIVEN
    List<Book> books = Arrays
      .asList(new Book("asd"), new Book("asd"));
    //WHEN
    double actual = underTest.calculateOptimizedTotalPrice(books);
    //THEN
    assertEquals(16.0, actual);
  }

  @Test
  void asd3() {
    //GIVEN
    List<Book> books = Arrays
      .asList(new Book("asd"), new Book("dsa"));
    //WHEN
    double actual = underTest.calculateOptimizedTotalPrice(books);
    //THEN
    assertEquals(16 * 0.95,actual);
  }
}

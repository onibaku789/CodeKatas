package com.example.potter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscountService {
  public double calculateOptimizedTotalPrice(List<Book> books) {
    if (books.isEmpty()) {
      return 0.0;
    }
    double sum = 0;
    Map<String, Long> collect = books.stream()
      .collect(Collectors.groupingBy(Book::getTitle, Collectors.counting()));
    for (Map.Entry<String, Long> entry : collect.entrySet()) {
      sum += entry.getValue() * 8.0;
    }
    return sum;
  }
}

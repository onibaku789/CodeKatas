package com.example.potter;

import java.util.Objects;

public class Book {
  private final String title;
  private final double price;

  public Book(String title) {
    this.title = title;
    this.price = 8.0;
  }

  public double getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Book))
      return false;
    Book book = (Book) o;
    return Double.compare(book.price, price) == 0 && Objects.equals(title, book.title);
  }

  @Override public int hashCode() {
    return Objects.hash(title, price);
  }
}

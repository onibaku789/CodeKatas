package com.example.rpg;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
  private final double x;
  private final double y;

  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double calculateDifference(Position other) {
    return sqrt(pow(other.x - x, 2) + pow(other.y - y, 2));
  }
}

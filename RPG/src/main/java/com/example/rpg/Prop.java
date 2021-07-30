package com.example.rpg;

public class Prop implements Target {
  private final Position position;
  private double health;
  private boolean destroyed;
  private final String type;

  public Prop(String type, double health) {
    this.health = health;
    this.position = new Position(0.0, 0.0);
    this.destroyed = false;
    this.type = type;
  }

  @Override
  public double getHealth() {
    return health;
  }

  @Override
  public void setHealth(double health) {
    this.health = health;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public void receiveDamage(double damage) {
    if (damage > health) {
      destroyed = true;
    }
    health -= damage;
  }

  public String getType() {
    return type;
  }

  @Override public String toString() {
    return "Prop{" +
      "health=" + health +
      ", destroyed=" + destroyed +
      ", type='" + type + '\'' +
      '}';
  }
}

package com.example.rpg;

public interface Target {
  double getHealth();

  Position getPosition();

  void receiveDamage(double damage);

}

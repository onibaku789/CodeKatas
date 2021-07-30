package com.example.rpg;

public interface Character extends Target {
  double MAX_BASE_HEALTH_POINT = 1000.0;

  void move(Position position);

  void receiveHeal(double heal);

  String getName();

  void attack(Target target);

  void heal(Character friendly);

  boolean isDead();

  boolean isAlive();

  int getLevel();

  boolean equals(Object o);

  int hashCode();


  double getMaxRange();

  void joinFaction(Faction... factions);

  void leaveFaction(Faction... factions);
}

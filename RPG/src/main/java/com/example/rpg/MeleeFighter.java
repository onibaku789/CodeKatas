package com.example.rpg;

public class MeleeFighter implements Character {
  private final Fighter fighter;

  public MeleeFighter(String name) {
      fighter = new Fighter(name, 2);
  }

  @Override
  public void receiveDamage(double damage) {
    fighter.receiveDamage(damage);
  }

  @Override
  public void receiveHeal(double heal) {
    fighter.receiveHeal(heal);
  }

  @Override
  public String getName() {
    return fighter.getName();
  }

  @Override
  public void attack(Target target) {
    fighter.attack(target);
  }

  @Override
  public void heal(Character target) {
    fighter.heal(target);
  }

  @Override
  public boolean isDead() {
    return fighter.isDead();
  }

  @Override
  public boolean isAlive() {
    return fighter.isAlive();
  }

  @Override
  public int getLevel() {
    return fighter.getLevel();
  }

  @Override
  public double getMaxRange() {
    return fighter.getMaxRange();
  }

  @Override
  public void joinFaction(Faction... factions) {
    fighter.joinFaction(factions);

  }

  @Override
  public void leaveFaction(Faction... factions) {
    fighter.leaveFaction(factions);
  }

  @Override
  public double getHealth() {
    return fighter.getHealth();
  }

  @Override
  public Position getPosition() {
    return fighter.getPosition();
  }

  @Override
  public void move(Position position) {
    fighter.move(position);
  }

  @Override
  public String toString() {
    return fighter.toString();
  }

  @Override
  public boolean equals(Object o) {
    return fighter.equals(o);
  }

  @Override
  public int hashCode() {
    return fighter.hashCode();
  }
}

package com.example.rpg;

import java.util.Objects;

public class RangedFighter implements Character {
  private Fighter fighter;

  public RangedFighter(String name) {
    this.fighter = new Fighter(name, 20);
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
  public Position getPosition() {
    return fighter.getPosition();
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
  public void move(Position position) {
    fighter.move(position);
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
  public String toString() {
    return fighter.toString();
  }

  @Override public boolean equals(Object o) {
    return fighter.equals(o);
  }

  @Override public int hashCode() {
    return Objects.hash(fighter);
  }
}

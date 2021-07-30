package com.example.rpg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Fighter implements Character {
  private final String name;
  private final double maxRange;
  private final Set<Faction> factions;
  private final int baseDamage;
  private int level;
  private double health;
  private boolean alive;
  private Position position;

  public Fighter(String name, double maxRange) {
    this.name = name;
    this.health = MAX_BASE_HEALTH_POINT;
    this.level = 1;
    this.alive = true;
    this.maxRange = maxRange;
    this.factions = new HashSet<>();
    this.position = new Position(0.0, 0.0);
    this.baseDamage = 200;
  }

  @Override
  public void attack(Target target) {
    if (target instanceof Character) {
      Character characterTarget = (Character) target;
      if (isNotFriendly(characterTarget) && isInRange(characterTarget)) {
        System.out.println(name + " attacks " + characterTarget.getName());
        double damage = calculateDamageAmount(characterTarget);
        characterTarget.receiveDamage(damage);
      }
    } else if (target instanceof Prop) {
      Prop prop = (Prop) target;
      target.receiveDamage(calculateDamageAmount(prop));
      System.out.println(name + " attacks prop " + prop.getType());
    }
  }

  @Override
  public void heal(Character target) {
    if (target.isAlive() && isFriendly(target)) {
      System.out.println(name + " heals " + target.getName());
      double heal = calculateHealAmount(target);
      target.receiveHeal(heal);
    }
  }

  private boolean isNotFriendly(Character target) {
    return !isFriendly(target);
  }

  private boolean isAlly(Character target) {
    return factions.stream().anyMatch(faction -> faction.isMember(target));
  }

  private boolean isInRange(Character target) {
    return calculateRangeBetween(target) <= getMaxRange();
  }

  private double calculateRangeBetween(Character target) {
    return position.calculateDifference(target.getPosition());
  }

  private boolean isFriendly(Character target) {
    return isSelf(target) || isAlly(target);
  }

  private boolean isSelf(Character target) {
    return target.equals(this);
  }

  private double calculateHealAmount(Character target) {
    double healAmount = 200.0;
    int levelDifference = target.getLevel() - level;
    if (levelDifference >= 5) {
      return healAmount * 0.5;
    } else if (levelDifference <= -5) {
      return healAmount * 1.5;
    }
    return healAmount;
  }

  private double calculateDamageAmount(Target target) {
    if (target instanceof Character) {
      Character characterTarget = (Character) target;
      int levelDifference = characterTarget.getLevel() - level;
      if (levelDifference >= 5) {
        return baseDamage * 0.5;
      } else if (levelDifference <= -5) {
        return baseDamage * 1.5;
      }
    }
    return baseDamage;
  }

  @Override
  public double getMaxRange() {
    return maxRange;
  }

  @Override
  public void joinFaction(Faction... factions) {
    System.out.println(name + " joining faction(s): " + Arrays.toString(factions));
    Arrays.asList(factions).forEach(faction -> faction.addCharacter(this));
    this.factions.addAll(Arrays.asList(factions));

  }

  @Override
  public void leaveFaction(Faction... factions) {
    System.out.println(name + " leaving faction(s): " + Arrays.toString(factions));
    Arrays.asList(factions).forEach(faction -> faction.removeCharacter(this));
    Arrays.asList(factions).forEach(this.factions::remove);
  }

  @Override
  public double getHealth() {
    return health;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public boolean isDead() {
    return !alive;
  }

  @Override
  public boolean isAlive() {
    return alive;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public void receiveDamage(double damage) {
    if (damage > health) {
      alive = false;
    }
    health -= damage;
  }

  @Override
  public void move(Position position) {
    this.position = position;
  }

  @Override
  public void receiveHeal(double heal) {
    if (health + heal > MAX_BASE_HEALTH_POINT) {
      health = MAX_BASE_HEALTH_POINT;
    } else {
      health += heal;
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Fighter))
      return false;
    Fighter that = (Fighter) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name + " {" +
      " maxRange=" + maxRange +
      ", level=" + level +
      ", health=" + health +
      ", alive=" + alive +
      ", factions = " + factions.stream().map(Faction::getName).collect(Collectors.joining(", ")) +
      '}';
  }
}

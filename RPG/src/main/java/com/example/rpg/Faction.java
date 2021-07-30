package com.example.rpg;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Faction {
  private final String name;
  private final Set<Character> players;

  public Faction(String name) {
    this.name = name;
    this.players = new HashSet<>();
  }

  public boolean isMember(Character character) {
    return players.contains(character);
  }

  public void addCharacter(Character character) {
    System.out.println(character.getName() + " joins " + name);
    players.add(character);
  }

  public void removeCharacter(Character character) {
    System.out.println(character.getName() + " leaves " + name);
    players.remove(character);
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Faction))
      return false;
    Faction faction = (Faction) o;
    return Objects.equals(name, faction.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}

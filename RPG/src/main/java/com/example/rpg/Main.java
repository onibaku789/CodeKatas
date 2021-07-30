package com.example.rpg;

public class Main {

  public static void main(String[] args) {
    Faction BLSZK = new Faction("BLSZK");
    Character McLva = new MeleeFighter("Mclva");
    Character Hab = new MeleeFighter("Hab");
    Character Luca = new RangedFighter("Luca");

    McLva.joinFaction(BLSZK);
    Hab.joinFaction(BLSZK);

    Luca.attack(McLva);
    Luca.attack(McLva);
    Hab.heal(McLva);
    System.out.println("------------------");
    Luca.heal(Luca);
    Luca.heal(Luca);
    System.out.println("------------------");
    System.out.println(Luca);
    System.out.println(McLva);
    System.out.println(Hab);

    System.out.println("---------------------------- PROP WARS START ------------------------");
    Prop tree = new Prop("tree", 20000);
    McLva.attack(tree);
    System.out.println(tree);
    System.out.println("---------------------------- PROP WARS END ------------------------");
    Luca.joinFaction(BLSZK);
    Luca.heal(McLva);
  }
}

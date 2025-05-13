package io.github.ink_song.tools;

import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;
import io.github.ink_song.tools.util.RollParser;

public class Main {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static void main(String[] args) {
    Dice dice;
    dice = new Dice();
    dice.addDice(new Die(20));
    dice.addDice(new Die(10));
    dice.addDice(new Die(6));

    System.out.println("Hello world!");
    dice.roll();
    int[] rolls = dice.getRolls();
    for (int i = 0; i < rolls.length; i++) {
      System.out.println("Roll " + i + ": " + rolls[i]);
    }
    System.out.println("Total: " + dice.getTotal());
    System.out.println("This"
        + ANSI_YELLOW
        + " text "
        + ANSI_RESET
        + "is yellow");

    String roll = "2d10 + 5";
    String roll2 = "1d4 + 3";
    System.out.println("Roll: " + roll);
    System.out.println("Roll 1 Result: " + new RollParser().evaluate(roll));
    System.out.println("Roll 2: " + roll2);
    System.out.println("Roll 2 Result: " + new RollParser().evaluate(roll2));
  }

  private void setUp(){

  }
}
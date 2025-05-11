package io.github.ink_song.tools;

public class Main {


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

  }

  private void setUp(){

  }
}
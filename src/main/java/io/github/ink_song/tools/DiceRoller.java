package io.github.ink_song.tools;



public class DiceRoller {
  private Dice dice;
  private int[] rolls;
  private int total;

  public DiceRoller(Dice dice) {
    this.dice = dice;
    rolls = new int[dice.getAmount()];
  }

  public void roll() {

  }
}

package io.github.ink_song.tools.service;


import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;
import io.github.ink_song.tools.util.ArrayUtils;

public class DiceRoller {
  private final Dice dice;

  public DiceRoller() {
    dice = new Dice();
  }

  public DiceRoller(int diceAmount, int diceSides) {
    dice = new Dice();
    for (int i = 0; i < diceAmount; i++) {
      dice.addDice(new Die(diceSides));
    }
  }

  public void addDice(Die die){
    dice.addDice(die);
  }

  public Dice getDice() {
    return dice;
  }

  public int[] roll() {
    dice.roll();
    return dice.getRolls();
  }

  public int[] rollDropLowest() {
    dice.roll();
    int[] rolls = dice.getRolls();
    return ArrayUtils.sortAndDropLowest(rolls);
  }

  public int rollWithAdvantage(Dice dice) {
    int first = dice.roll();
    int second = dice.roll();
    return Math.max(first, second);
  }

  public int rollWithDisadvantage(Dice dice) {
    int first = dice.roll();
    int second = dice.roll();
    return Math.min(first, second);
  }

}

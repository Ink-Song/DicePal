package io.github.ink_song.tools;


import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;
import io.github.ink_song.tools.util.ArrayUtils;

public class DiceRoller {
  private final Dice dice;

  public DiceRoller(int diceAmount, int diceSides) {
    dice = new Dice();
    for (int i = 0; i < diceAmount; i++) {
      dice.addDice(new Die(diceSides));
    }
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
}

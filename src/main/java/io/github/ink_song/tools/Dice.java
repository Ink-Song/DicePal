package io.github.ink_song.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dice {
  private final List<Die> dice;
  private int[] rolls;
  private int total;

  public Dice() {
    dice = new ArrayList<Die>();
  }

  public void roll(){
    rolls = dice.stream().mapToInt(Die::roll).toArray();
  }

  public void addDice(Die d) {
    dice.add(d);
  }

  public void removeDice(Die d) {
    dice.remove(d);
  }

  public int getTotal() {
    total = calculateTotal();
    return total;
  }

  public List<Die> getDice() {
    return dice;
  }

  public int[] getRolls() {
    return rolls;
  }

  public int getAmount() {
    return dice.size();
  }

  private int calculateTotal() {
    return Arrays.stream(rolls).sum();
  }
}

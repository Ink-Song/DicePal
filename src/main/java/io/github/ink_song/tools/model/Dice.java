package io.github.ink_song.tools.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {
  private final List<Die> dice;
  private int[] rolls;
  private int total;

  public Dice() {
    dice = new ArrayList<Die>();
  }

  public void rollNoOutput(){
    rolls = dice.stream().mapToInt(Die::roll).toArray();
  }

  public int roll(){
    rollNoOutput();
    return getTotal();
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

  public void setRolls(int[] rolls) {
    this.rolls = rolls;
  }

  private int calculateTotal() {
    return Arrays.stream(rolls).sum();
  }
}

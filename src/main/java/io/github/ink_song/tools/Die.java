package io.github.ink_song.tools;

import java.util.Random;

public class Die {
  private final Random random = new Random();
  private int lastRoll;
  private int sides;

  public Die(int sides){
    this.sides = sides;
  }

  public int roll(){
    //random.setSeed(System.currentTimeMillis());
    lastRoll = random.nextInt(sides) + 1;
    return lastRoll;
  }

  public int getLastRoll(){
    return lastRoll;
  }

  public int getSides(){
    return sides;
  }
}

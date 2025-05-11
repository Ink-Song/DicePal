package io.github.ink_song.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
  private Die firstDie;
  private Die secondDie;
  private List<Die> dice;

  @BeforeEach
  void setUp() throws Exception {
    firstDie = new Die(6);
    secondDie = new Die(100);
    dice = new ArrayList<>();
    dice.add(firstDie);
    dice.add(secondDie);
  }

  @Test
  void roll() {
    // Roll each dice 1000 times and assert that the result of the roll is never greater
    // than the size of the dice.
    // Likewise, assert that they are never lower than 1.
    for(Die die : dice) {
      int sides = die.getSides();
      for (int i = 0; i < 1000; i++) {
        int roll = die.roll();
        System.out.println(roll);
        assertTrue(roll <= sides);
        assertTrue(roll >= 1);
      }
    }
  }

  @Test
  void getLastRoll() {
    for (int i = 0; i < 100; i++) {
      //Roll the dice and then get the last roll. Assert that they are always the same.
      //Note that we should technically check to ensure that if the dice has never been rolled
      //that we correctly handle what should happen when we try to get last rolls.
      int roll = firstDie.roll();
      int lastRoll = firstDie.getLastRoll();
      assertEquals(roll, lastRoll);
    }
  }

  @Test
  void getSides() {
    assertEquals(6, firstDie.getSides());
    assertEquals(100, secondDie.getSides());
  }
}
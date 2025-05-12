package io.github.ink_song.tools.util;

import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RollParser {
  private String rollString;
  private String parsedRoll;
  private List<String> parsedDiceGroups;

  public RollParser(String rollString) {
    this.rollString = rollString.trim();
  }

  public void evaluate(String input){
    String[] diceGroups = this.rollString.split("\\s*,\\s");
    List<String> evaluatedInputs = new ArrayList<>();
    for(String diceGroup : diceGroups){
      //We need to build from the ground up. Start by making a function that evaluates a full dice group
    }
  }

  private String parseValue(String input){
    List<String> parsedValues = new ArrayList<>();
    if (input.matches("\\\\d+d\\\\d+")) {
      return String.valueOf((parseDiceRoll(input)));
    }
    else return input;
  }

  private int parseDiceRoll(String input){
    String[] parts  = input.toLowerCase().split("d");
    int numberOfDice = Integer.parseInt(parts[0]);
    int sides = Integer.parseInt(parts[1]);
    Dice dice = new Dice();
    for (int i = 0; i < numberOfDice; i++) {
      dice.addDice(new Die(sides));
    }
    return dice.roll();
  }

  public void parseString() {
    // Try different input examples:
    // String input = "1d20 + 2d10 + 5";
    // String input = "2d10 + 7 + 1d10 + 2";
    // String input = "1d20 - 2 - 2d10";
    String input = "1d20 + 2d10 + 5";

    // Regex pattern with three alternatives:
    // 1. \d+d\d+  matches a dice roll like 1d20, 2d10, etc.
    // 2. [+-]    matches a plus or minus operator.
    // 3. \d+     matches a plain number.
    Pattern tokenPattern = Pattern.compile("\\d+d\\d+|[+-]|\\d+");
    Matcher matcher = tokenPattern.matcher(input);

    List<String> tokens = new ArrayList<>();
    while (matcher.find()) {
      tokens.add(matcher.group());
    }

    // Print out each token in order.
    System.out.println("Tokens:");
    for (String token : tokens) {
      System.out.println(token);
    }
  }
}

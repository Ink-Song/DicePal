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

  public String evaluate(String input){
    String[] diceGroups = input.split("\\s*,\\s");
    List<String> evaluatedInputs = new ArrayList<>();
    for(String diceGroup : diceGroups){
      System.out.println("Dice Group: " + diceGroup);
      evaluatedInputs.add(String.valueOf(parseValue(diceGroup)));
    }
    String[] val = evaluatedInputs.toArray(new String[0]);
    return String.join(", ", val);
  }

  private int parseValue(String input){
    String[] parsedFromInput = input.split("\\s");
    List<String> parsedValues = new ArrayList<>();
    for(String parsedValue : parsedFromInput){
      System.out.println("Paresed Value: " + parsedValue);
      if (parsedValue.matches("\\d+d\\d+")) {
        String convertedRoll = String.valueOf(parseDiceRoll(parsedValue));
        System.out.println("Converted Roll " + convertedRoll);
        parsedValues.add(convertedRoll);
      }
      else {
        parsedValues.add(input);
      }
    }
    return evaluateExpression(parsedValues);
  }

  private int evaluateExpression(List<String> input){
    for (String value : input) {
      System.out.println("Evaluated Value: " + value);
    }
    int result = Integer.parseInt(input.get(0));
    for (int i = 1; i < input.size(); i+=2) {
      String operator = input.get(i);
      int nextNumber = Integer.parseInt(input.get(i+1));
      result = switch (operator) {
        case "+" -> result + nextNumber;
        case "-" -> result - nextNumber;
        default -> result;
      };
    }
    return result;
  }

  private int parseDiceRoll(String input){
    System.out.println("Parsing Dice Roll: " + input);
    String[] parts  = input.toLowerCase().split("d");
    for (String string : parts) {
      System.out.println("Parts: " + string);
    }
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

package io.github.ink_song.tools.util;

import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;

import java.util.ArrayList;
import java.util.List;

public class RollParser {
  private String rollString;
  private String parsedRoll;
  private List<String> parsedDiceGroups;

  public String evaluate(String input){
    rollString = input;
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
      System.out.println("Parsed Value: " + parsedValue);
      if (parsedValue.matches("\\d+d\\d+")) {
        String convertedRoll = String.valueOf(parseDiceRoll(parsedValue));
        System.out.println("Converted Roll " + convertedRoll);
        parsedValues.add(convertedRoll);
      }
      else {
        parsedValues.add(parsedValue);
      }
    }
    return evaluateExpression(parsedValues);
  }

  private int evaluateExpression(List<String> input){
    for (String value : input) {
      System.out.println("Evaluated Value: " + value);
    }
    int result = Integer.parseInt(input.getFirst());
    for (int i = 1; i < input.size(); i+=2) {
      String operator = input.get(i);
      int nextNumber = Integer.parseInt(input.get(i+1));
      result = switch (operator) {
        case "+" -> result + nextNumber;
        case "-" -> result - nextNumber;
        default -> result;
      };
    }
    parsedRoll = String.valueOf(result);
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

  public String getLastInput(){
    return rollString;
  }

  public String getLastResult(){
    return parsedRoll;
  }

  public void setLastInput(String input) {
    rollString = input;
  }

  public void setLastResult(String input) {
    parsedRoll = input;
  }

}

package io.github.ink_song.tools.service.parser;

import java.util.ArrayList;
import java.util.List;
import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.model.Die;
import io.github.ink_song.tools.util.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RollParser {
  private static final Logger logger = LogManager.getLogger(RollParser.class);
  private final StringValidator validator = new StringValidator("\\d+d\\d+|[+\\-]|\\d+/");

  private String rollString;
  private String parsedRoll;
  private List<String> parsedDiceGroups;

  public String evaluate(String input) throws IllegalArgumentException {
    logger.info("Evaluating input {}", input);
    rollString = input;
    String[] diceGroups = input.split("\\s*,\\s");
    List<String> evaluatedInputs = new ArrayList<>();
    for(String diceGroup : diceGroups){
      System.out.println(diceGroup);
      if(validator.isValid(diceGroup)){
        evaluatedInputs.add(String.valueOf(parseValue(diceGroup)));
      } else {
        throw new IllegalArgumentException("Invalid roll expression: " + diceGroup);
      }

    }
    String[] val = evaluatedInputs.toArray(new String[0]);
    return String.join(", ", val);
  }

  private int parseValue(String input){
    logger.info("Parsing value for dice group: {}", input);
    String[] parsedFromInput = input.split("\\s");
    List<String> parsedValues = new ArrayList<>();
    for(String parsedValue : parsedFromInput){
      logger.info("Checking parsed Value: {}", parsedValue);
      if (parsedValue.matches("\\d+d\\d+")) {
        String convertedRoll = String.valueOf(parseDiceRoll(parsedValue));
        parsedValues.add(convertedRoll);
      }
      else {
        parsedValues.add(parsedValue);
      }
    }
    return evaluateExpression(parsedValues);
  }

  private int evaluateExpression(List<String> input){
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : input) {
      stringBuilder.append(string);
    }
    logger.info("Evaluating expression: {}", stringBuilder.toString());
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
    logger.info("Checking Dice Roll: {}", input);
    String[] parts  = input.toLowerCase().split("d");
    int numberOfDice = Integer.parseInt(parts[0]);
    int sides = Integer.parseInt(parts[1]);
    logger.info("Rolling [{}] dice with [{}] sides each", numberOfDice, sides);
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

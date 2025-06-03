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

  public List<String> parseRollStrings(String input) {
    logger.info("Evaluating input {}", input);
    String[] diceGroups = input.split("\\s*,\\s");
    List<String> parsedInputs = new ArrayList<>();
    for(String diceGroup : diceGroups){
      System.out.println(diceGroup);
      if(validator.isValid(diceGroup)){
        parsedInputs.add(diceGroup);
      } else {
        throw new IllegalArgumentException("Invalid roll expression: " + diceGroup);
      }
    }
    return parsedInputs;
  }

  public ParsedRoll parseRoll(String input) {
    logger.info("Parsing roll from {}", input);
    String[] parsedFromInput = input.split("\\s");
    ParsedRoll parsedRoll = new ParsedRoll();
    for(String parsedItem : parsedFromInput){
      if(parsedItem.equals("+")||parsedItem.equals("-")){
        char character = parsedItem.charAt(0);
        parsedRoll.addItem(new ParsedItem(character, ItemType.CHARACTER));
        continue;
      }
      if(parsedItem.matches("\\d+d\\d+")){
        Dice dice = parseDice(parsedItem);
        parsedRoll.addItem(new ParsedItem(dice, ItemType.DICE));
        continue;
      }
      if(parsedItem.matches("\\d+/\\d+")){
        int integer = Integer.parseInt(parsedItem);
        parsedRoll.addItem(new ParsedItem(integer, ItemType.INTEGER));
      }
    }
    return parsedRoll;
  }

  public List<ParsedRoll> parseRolls(String input) {
    logger.info("Parsing rolls from {}", input);
    List<ParsedRoll> parsedRolls = new ArrayList<>();
    List<String> parsedRollStrings = parseRollStrings(input);
    for (String parsedRollString : parsedRollStrings) {
      ParsedRoll parsedRoll = parseRoll(parsedRollString);
      parsedRolls.add(parsedRoll);
    }
    return parsedRolls;
  }

//  public String evaluate(String input) throws IllegalArgumentException {
//    logger.info("Evaluating input {}", input);
//    rollString = input;
//    String[] diceGroups = input.split("\\s*,\\s");
//    List<String> evaluatedInputs = new ArrayList<>();
//    for(String diceGroup : diceGroups){
//      System.out.println(diceGroup);
//      if(validator.isValid(diceGroup)){
//        evaluatedInputs.add(String.valueOf(parseValue(diceGroup)));
//      } else {
//        throw new IllegalArgumentException("Invalid roll expression: " + diceGroup);
//      }
//
//    }
//    String[] val = evaluatedInputs.toArray(new String[0]);
//    return String.join(", ", val);
//  }
//
//  private int parseValue(String input){
//    logger.info("Parsing value for dice group: {}", input);
//    String[] parsedFromInput = input.split("\\s");
//    List<String> parsedValues = new ArrayList<>();
//    for(String parsedValue : parsedFromInput){
//      logger.info("Checking parsed Value: {}", parsedValue);
//      if (parsedValue.matches("\\d+d\\d+")) {
//        String convertedRoll = String.valueOf(parseDiceRoll(parsedValue));
//        parsedValues.add(convertedRoll);
//      }
//      else {
//        parsedValues.add(parsedValue);
//      }
//    }
//    return evaluateExpression(parsedValues);
//  }
//
//  private int evaluateExpression(List<String> input){
//    StringBuilder stringBuilder = new StringBuilder();
//    for (String string : input) {
//      stringBuilder.append(string);
//    }
//    logger.info("Evaluating expression: {}", stringBuilder.toString());
//    int result = Integer.parseInt(input.getFirst());
//    for (int i = 1; i < input.size(); i+=2) {
//      String operator = input.get(i);
//      int nextNumber = Integer.parseInt(input.get(i+1));
//      result = switch (operator) {
//        case "+" -> result + nextNumber;
//        case "-" -> result - nextNumber;
//        default -> result;
//      };
//    }
//    parsedRoll = String.valueOf(result);
//    return result;
//  }

  private Dice parseDice(String input) {
    logger.info("Parsing Dice: {}", input);
    String[] parts  = input.toLowerCase().split("d");
    int numberOfDice = Integer.parseInt(parts[0]);
    int sides = Integer.parseInt(parts[1]);
    logger.info("Rolling [{}] dice with [{}] sides each", numberOfDice, sides);
    Dice dice = new Dice();
    for (int i = 0; i < numberOfDice; i++) {
      dice.addDice(new Die(sides));
    }
    return dice;
  }

  private int parseDiceRoll(String input){
    Dice dice = parseDice(input);
    return dice.roll();
  }

}

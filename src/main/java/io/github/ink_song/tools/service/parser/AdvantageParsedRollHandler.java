package io.github.ink_song.tools.service.parser;

import io.github.ink_song.tools.model.Dice;

import java.util.List;

public class AdvantageParsedRollHandler implements ParsedRollHandler {
  @Override
  public String handle(ParsedRoll parsedRoll) {
    List<ParsedItem> parsedItems = parsedRoll.getTokens();
    Operator operator = Operator.ADD;
    int currentResult = 0;
    for (ParsedItem parsedItem : parsedItems) {
      ItemType type = parsedItem.type();
      switch (type) {
        case DICE -> {
          int a = rollWithAdvantage(parsedItem.asDice());
          currentResult = evaluate(currentResult, a, operator);
        }
        case INTEGER -> {
          int a = parsedItem.asInt();
          currentResult = evaluate(currentResult, a, operator);
        }
        case CHARACTER -> {
          if (parsedItem.asChar() == '+'){
            operator = Operator.ADD;
          }
          else if (parsedItem.asChar() == '-'){
            operator = Operator.SUBTRACT;
          }
        }
      }
    }

    return "" + currentResult;
  }

  private int rollWithAdvantage(Dice dice){
    int roll1 = dice.roll();
    int roll2 = dice.roll();
    return Math.max(roll1, roll2);
  }
  private int evaluate(int a, int b, Operator operator) {
    int result = 0;
    switch (operator) {
      case ADD ->{ result =  a + b;}
      case SUBTRACT -> { result =  a - b; }
    }
    return result;
  }
}

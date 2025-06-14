package io.github.ink_song.tools.service.parser;

import io.github.ink_song.tools.service.color.AnsiColor;
import io.github.ink_song.tools.util.StringUtil;

import java.util.List;

public class AdvantageParsedRollHandler implements ParsedRollHandler {
  @Override
  public String handle(ParsedRoll parsedRoll) {
    List<ParsedItem> parsedItems = parsedRoll.getTokens();
    int[] results = new int[2];

    for (int i = 0; i < 2; i++) {
      results[i] = performRolls(parsedItems);
    }

    String highest = "" + Math.max(results[0], results[1]);
    String lowest = "" + Math.min(results[0], results[1]);


    return StringUtil.color(highest, AnsiColor.GREEN) + ", " + lowest;
  }

  private int performRolls(List<ParsedItem> parsedItems) {
    Operator operator = Operator.ADD;
    int currentResult = 0;

    for (ParsedItem parsedItem : parsedItems) {
      ItemType type = parsedItem.type();
      switch (type) {
        case DICE -> {
          int a = parsedItem.asDice().roll();
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
    return currentResult;
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

package io.github.ink_song.tools.service.parser;

import io.github.ink_song.tools.model.Dice;

import java.util.List;

public class AdvantageParsedRollHandler implements ParsedRollHandler {
  @Override
  public String handle(ParsedRoll parsedRoll) {
    List<ParsedItem> parsedItems = parsedRoll.getTokens();
    Operator operator = Operator.ADD;
    int lastInt = 0;
    for (ParsedItem parsedItem : parsedItems) {
      ItemType type = parsedItem.type();
      int a = 0;
      switch (type) {
        case DICE -> { a = rollWithAdvantage(parsedItem.asDice());}
        case INTEGER -> { a = parsedItem.asInt(); }
        case CHARACTER -> {
          if (parsedItem.asChar() == '+'){
            operator = Operator.ADD;
          }
          else if (parsedItem.asChar() == '-'){
            operator = Operator.SUBTRACT;
            continue;
          }
        }
      }
      switch (operator) {
        case ADD -> lastInt = lastInt + a;
        case SUBTRACT -> lastInt = lastInt - a;
      }
    }

    return "" + lastInt;
  }

  private int rollWithAdvantage(Dice dice){
    int roll1 = dice.roll();
    int roll2 = dice.roll();
    return Math.max(roll1, roll2);
  }
}

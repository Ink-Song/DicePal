package io.github.ink_song.tools.service.parser;

import io.github.ink_song.tools.model.Dice;
import io.github.ink_song.tools.util.MathUtil;

import java.util.List;

public class StandardParsedRollHandler implements ParsedRollHandler {

  @Override
  public String handle(ParsedRoll parsedRoll) {
    List<ParsedItem> parsedItems = parsedRoll.getTokens();
    Operator operator = Operator.ADD;
    int lastInt = 0;
    for (ParsedItem parsedItem : parsedItems) {
      ItemType type = parsedItem.type();
      int a = 0;
      switch (type) {
        case DICE -> { a = parsedItem.asDice().roll();}
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
}

package io.github.ink_song.tools.service.parser;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StandardParsedRollHandler implements ParsedRollHandler {
  private static final Logger logger = LogManager.getLogger(StandardParsedRollHandler.class);

  @Override
  public String handle(ParsedRoll parsedRoll) {
    logger.info("Handling Roll");
    List<ParsedItem> parsedItems = parsedRoll.getTokens();
    Operator operator = Operator.ADD;
    int currentResult = 0;
    for (ParsedItem parsedItem : parsedItems) {
      ItemType type = parsedItem.type();
      logger.info("Parsing an item of type {}", type);
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

    return "" + currentResult;
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

package io.github.ink_song.tools.controller;

import io.github.ink_song.tools.service.parser.ParsedRoll;
import io.github.ink_song.tools.service.parser.ParsedRollHandler;
import io.github.ink_song.tools.service.parser.RollParser;

import java.util.List;

public class RollController {
  private final RollParser rollParser = new RollParser();

  public String parseRoll(String string, ParsedRollHandler parsedRollHandler) {
    List<ParsedRoll> parsedRolls = rollParser.parseRolls(string);
    StringBuilder stringBuilder = new StringBuilder();
    for (ParsedRoll parsedRoll : parsedRolls) {
      stringBuilder.append(parsedRollHandler.handle(parsedRoll));
      stringBuilder.append(", ");
    }
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }


}

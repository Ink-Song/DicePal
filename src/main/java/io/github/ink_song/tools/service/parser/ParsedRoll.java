package io.github.ink_song.tools.service.parser;

import java.util.ArrayList;
import java.util.List;

public class ParsedRoll {
  private final List<ParsedItem> tokens = new ArrayList<ParsedItem>();

  public void addItem(ParsedItem item) {
    tokens.add(item);
  }

  public List<ParsedItem> getTokens() {
    return tokens;
  }
}

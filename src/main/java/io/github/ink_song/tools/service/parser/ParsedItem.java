package io.github.ink_song.tools.service.parser;

import io.github.ink_song.tools.model.Dice;

public record ParsedItem(Object value, ItemType type) {

  public Dice asDice() {
    return (Dice) value;
  }

  public String asString() {
    return (String) value;
  }

  public char asChar() {
    return (char) value;
  }

  public int asInt() {
    return (int) value;
  }


}

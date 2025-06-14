package io.github.ink_song.tools.model;

import io.github.ink_song.tools.service.color.AnsiColor;

public class ColoredString {
  private AnsiColor ansiColor;
  private String string;

  public ColoredString(AnsiColor ansiColor, String string) {
    this.ansiColor = ansiColor;
    this.string = string;
  }

  public AnsiColor getAnsiColor() {
    return ansiColor;
  }

  public void setAnsiColor(AnsiColor ansiColor) {
    this.ansiColor = ansiColor;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return ansiColor.open() + string + ansiColor.close();
  }
}

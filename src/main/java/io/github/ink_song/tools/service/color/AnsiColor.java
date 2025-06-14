package io.github.ink_song.tools.service.color;

public enum AnsiColor {
  BLACK("\u001B[30m"),
  RED("\u001B[31m"),
  YELLOW("\u001B[33m"),
  GREEN("\u001B[32m"),
  CYAN("\u001B[36m"),
  BLUE("\u001B[34m"),
  PURPLE("\u001B[35m"),
  WHITE("\u001B[37m"),
  RESET("\u001B[0m");

  private final String code;
  AnsiColor(String code) {
    this.code = code;
  }
  public String open() {return code; }
  public String close() {return RESET.code; }
}

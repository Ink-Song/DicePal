package io.github.ink_song.tools.service.output;

public class ConsoleOutput implements Output {

  @Override
  public void print(String text) {
    System.out.print(text);
  }

  @Override
  public void println(String text) {
    System.out.println(text);
  }

  @Override
  public void printf(String format, Object... args) {
    System.out.printf(format, args);
  }
}

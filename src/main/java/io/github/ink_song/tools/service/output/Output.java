package io.github.ink_song.tools.service.output;

public interface Output {
  void print(String text);
  void println(String text);
  void printf(String format, Object... args);
}

package io.github.ink_song.tools.util;

import io.github.ink_song.tools.service.color.AnsiColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

  private String input = "Chicken";
  private AnsiColor ansiColor = AnsiColor.RED;

  @Test
  void getFirstCharacter() {
    assertEquals('C', StringUtil.getFirstCharacter(input));
  }

  @Test
  void color() {
    String result = StringUtil.color(input, ansiColor);
    assertEquals("\u001B[31mChicken\u001B[0m", result);
    System.out.println(result);
  }
}
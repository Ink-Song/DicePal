package io.github.ink_song.tools.util;

import io.github.ink_song.tools.service.color.AnsiColor;

public class StringUtil {
  private static final String tabularFormat = "%-10s %s%n";
  public static char getFirstCharacter(String str) {
    return str.charAt(0);
  }

  public static String color(String input, AnsiColor color) {
    return color.open() + input + color.close();
  }

  public static String getTabularFormat(){
    return tabularFormat;
  }

//  public static String formatTable(String key, String value) {
//
//  }
}

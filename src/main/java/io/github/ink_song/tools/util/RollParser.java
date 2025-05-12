package io.github.ink_song.tools.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RollParser {
  private String rollString;
  private String parsedRoll;

  public RollParser(String rollString) {
    this.rollString = rollString.trim();
  }

  public void parseString() {
    Pattern pattern = Pattern.compile("(\\d+d\\d+(?:\\s*[+-]\\s*\\d+)?)");
    Matcher matcher = pattern.matcher(rollString);

    List<String> parsedComponents = new ArrayList<>();

    while (matcher.find()) {
      parsedComponents.add(matcher.group().trim());
    }

    // Print results
    System.out.println("Grouped Dice Rolls with Bonuses:");
    for (String component : parsedComponents) {
      System.out.println(component);
    }
  }
}

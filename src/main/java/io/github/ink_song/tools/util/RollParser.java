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
    // Try different input examples:
    // String input = "1d20 + 2d10 + 5";
    // String input = "2d10 + 7 + 1d10 + 2";
    // String input = "1d20 - 2 - 2d10";
    String input = "1d20 + 2d10 + 5";

    // Regex pattern with three alternatives:
    // 1. \d+d\d+  matches a dice roll like 1d20, 2d10, etc.
    // 2. [+-]    matches a plus or minus operator.
    // 3. \d+     matches a plain number.
    Pattern tokenPattern = Pattern.compile("\\d+d\\d+|[+-]|\\d+");
    Matcher matcher = tokenPattern.matcher(input);

    List<String> tokens = new ArrayList<>();
    while (matcher.find()) {
      tokens.add(matcher.group());
    }

    // Print out each token in order.
    System.out.println("Tokens:");
    for (String token : tokens) {
      System.out.println(token);
    }
  }
}

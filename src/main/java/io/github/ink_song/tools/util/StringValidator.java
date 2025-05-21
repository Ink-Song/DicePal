package io.github.ink_song.tools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility for validating that a String matches a given REGEX pattern.
 */
public class StringValidator implements Validator {
  Pattern validPattern;

  /**
   * Default constructor for String Validator.
   * @param key Takes in a REGEX key as a String.
   */
  public StringValidator(String key) {
    validPattern = Pattern.compile(key);
  }
  @Override
  public boolean isValid(Object input) {
    if(input == null) return false;
    if(!(input instanceof String)) return false;
    String trimmedInput = ((String) input).trim();
    Matcher matcher = validPattern.matcher(trimmedInput);
    return matcher.find();
  }
}

package io.github.ink_song.tools.util;

/**
 * A utility for validating that a String matches a given REGEX pattern.
 */
public class StringValidator implements Validator {
  private String key;

  /**
   * Default constructor for String Validator.
   * @param key Takes in a REGEX key as a String.
   */
  public StringValidator(String key) {
    this.key = key;
  }
  @Override
  public boolean isValid(Object input) {
    if(input == null) return false;
    if(!(input instanceof String)) return false;
    String trimmedInput = ((String) input).trim();
    return trimmedInput.matches(key);
  }
}

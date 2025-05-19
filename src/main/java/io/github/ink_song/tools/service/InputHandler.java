package io.github.ink_song.tools.service;

import io.github.ink_song.tools.exception.InvalidCommandException;
import io.github.ink_song.tools.util.StringUtil;

public class InputHandler {

  public void handle(String string) throws InvalidCommandException {
    if (StringUtil.getFirstCharacter(string) != '/' ){
      throw new InvalidCommandException("No Command character (/) found.");
    }
    System.out.println("Echo: " + string);
  }
}

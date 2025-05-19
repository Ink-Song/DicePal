package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.Command;
import io.github.ink_song.tools.exception.InvalidCommandException;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.util.StringUtil;

public class InputHandler {
  private final CommandRegistry registry;

  public InputHandler(CommandRegistry registry) {
    this.registry = registry;
  }

  public CommandResult handle(String string) throws InvalidCommandException {
    if (StringUtil.getFirstCharacter(string) != '/' ){
      throw new InvalidCommandException("No Command character (/) found.");
    }

    String[] tokens = string.split(" ", 2);

    try {
      Command command = registry.getCommand(tokens[0]);
      return command.execute(tokens);
    } catch (NullPointerException e) {
      throw new InvalidCommandException("Command '" + tokens[0] + "' not found.");
    }
  }

}

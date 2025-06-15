package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CustomCommandRegistry;

import java.io.IOException;
import java.security.InvalidParameterException;

public class DefineCustomCommand implements Command {
  private final CustomCommandRegistry customCommandRegistry;

  public DefineCustomCommand(CustomCommandRegistry customCommandRegistry) {
    this.customCommandRegistry = customCommandRegistry;
  }
  /**
   * Executes a given command.
   *
   * @param args the arguments for the command
   */
  @Override
  public CommandResult execute(String[] args) {
    String[] customCommand = args[1].split(" ", 2);
    if (customCommand.length != 2) {
      throw new InvalidParameterException("Custom command syntax is incorrect");
    }

    String commandName = customCommand[0].toLowerCase();
    String commandPair = customCommand[1];
    try {
      customCommandRegistry.register(commandName, commandPair);
    } catch (IOException e) {
      throw new InvalidParameterException(e.getMessage());
    }
    return new CommandResult(true, "Command " + commandName + " added to registry.");
  }
}

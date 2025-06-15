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
    String commandName = args[1].toLowerCase();
    StringBuilder customCommandArgs = new StringBuilder();
    for (int i = 2; i < args.length; i++) {
      customCommandArgs.append(args[i]).append(" ");
    }
    try {
      customCommandRegistry.register(commandName, customCommandArgs.toString());
    } catch (IOException e) {
      throw new InvalidParameterException(e.getMessage());
    }
    return new CommandResult(true, "Command " + commandName + " added to registry.");
  }
}

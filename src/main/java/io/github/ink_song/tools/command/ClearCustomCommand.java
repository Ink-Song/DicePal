package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CustomCommandRegistry;
import io.github.ink_song.tools.service.UserPrompter;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class ClearCustomCommand implements Command {
  private final CustomCommandRegistry customCommandRegistry;
  private final Scanner scanner;
  private final UserPrompter userPrompter = new UserPrompter();
  private final String question = "Clear all custom commands? This action cannot be undone.";

  public ClearCustomCommand(CustomCommandRegistry customCommandRegistry, Scanner scanner) {
    this.customCommandRegistry = customCommandRegistry;
    this.scanner = scanner;
  }

  /**
   * Executes a given command.
   *
   * @param args
   */
  @Override
  public CommandResult execute(String[] args) {
    CommandResult commandResult = null;
    if (!userPrompter.isConfirmed(scanner, customCommandRegistry, question)){
      commandResult = new CommandResult(false, "Custom Command Registry wipe cancelled.");
      return commandResult;
    }

    try {
      customCommandRegistry.clear();
      commandResult = new CommandResult(true, "Custom Command Registry cleared successfully!");
      return commandResult;
    }
    catch (IOException e){
      throw new RuntimeException("Something went wrong while clearing the custom commands!" + "\n" + e.getMessage());
    }

  }

}

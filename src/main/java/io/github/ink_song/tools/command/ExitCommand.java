package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;

public class ExitCommand implements Command {
  /**
   * Executes a given command.
   *
   * @param args
   */
  @Override
  public CommandResult execute(String[] args) {
    System.exit(0);
    return null;
  }
}

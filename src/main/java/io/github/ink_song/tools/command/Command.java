package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;

/**
 * Interface used to define the Command pattern
 */
public interface Command {
  /**
   * Executes a given command.
   */
  CommandResult execute(String[] args);
}

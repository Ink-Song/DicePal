package io.github.ink_song.tools.command;

/**
 * Interface used to define the Command pattern
 */
public interface Command {
  /**
   * Executes a given command.
   */
  void execute(String[] args);
}

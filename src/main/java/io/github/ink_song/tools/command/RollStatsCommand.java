package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.util.RollParser;

public class RollStatsCommand implements Command {

  /**
   * Executes a given command.
   *
   * @param args arguments to be used.
   */
  @Override
  public CommandResult execute(String[] args) {
    RollParser parser = new RollParser();
    if (args.length == 1) {
      String result = parser.evaluate("3d6, 3d6, 3d6, 3d6, 3d6, 3d6");
      return new CommandResult(true, result);
    }
    return new CommandResult(false, "");
  }
}

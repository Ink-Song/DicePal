package io.github.ink_song.tools.command;

import io.github.ink_song.tools.DiceRoller;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.util.MathUtil;
import io.github.ink_song.tools.util.RollParser;

import java.util.Arrays;

public class RollStatsCommand implements Command {

  /**
   * Executes a given command.
   *
   * @param args arguments to be used.
   */
  @Override
  public CommandResult execute(String[] args) {
    if (args.length > 1) {return new CommandResult(false, "");}

    DiceRoller diceRoller = new DiceRoller(4, 6);
    StringBuilder message = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      int[] rolls = diceRoller.rollDropLowest();
      int result = MathUtil.sum(rolls);
      if(i < 5){
        message.append(result).append(", ");
      } else {
        message.append(result);
      }
    }

    return new CommandResult(true, message.toString());
  }
}

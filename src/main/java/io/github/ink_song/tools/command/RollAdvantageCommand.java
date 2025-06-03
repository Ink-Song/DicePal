package io.github.ink_song.tools.command;

import io.github.ink_song.tools.controller.RollController;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.parser.AdvantageParsedRollHandler;

import java.security.InvalidParameterException;

public class RollAdvantageCommand implements Command {

  @Override
  public CommandResult execute(String[] args) {
    if (args.length != 2) {
      throw new InvalidParameterException("Illegal number of arguments");
    }
    String result = new RollController().parseRoll(args[1], new AdvantageParsedRollHandler());
    return new CommandResult(true, result);
  }
}

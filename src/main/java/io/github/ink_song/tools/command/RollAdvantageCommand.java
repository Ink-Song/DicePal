package io.github.ink_song.tools.command;

import io.github.ink_song.tools.controller.RollController;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CustomCommandRegistry;
import io.github.ink_song.tools.service.parser.AdvantageParsedRollHandler;

import java.security.InvalidParameterException;

public class RollAdvantageCommand implements Command {
  private final CustomCommandRegistry registry;

  public RollAdvantageCommand(CustomCommandRegistry registry) {
    this.registry = registry;
  }

  @Override
  public CommandResult execute(String[] args) {
    if (args.length != 2) {
      throw new InvalidParameterException("Illegal number of arguments");
    }
    String rollDate = args[1];
    if (registry.exists(rollDate)) {
      rollDate = registry.get(rollDate);
    }

    String result = new RollController().parseRoll(rollDate, new AdvantageParsedRollHandler());
    return new CommandResult(true, result);
  }
}

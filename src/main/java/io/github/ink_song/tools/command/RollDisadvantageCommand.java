package io.github.ink_song.tools.command;

import io.github.ink_song.tools.controller.RollController;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CustomCommandRegistry;
import io.github.ink_song.tools.service.parser.DisadvantageParsedRollHandler;

import java.security.InvalidParameterException;

public class RollDisadvantageCommand implements Command {
  private final CustomCommandRegistry registry;

  public RollDisadvantageCommand(CustomCommandRegistry registry) {
    this.registry = registry;
  }

  @Override
  public CommandResult execute(String[] args) {
    if (args.length != 2) {
      throw new InvalidParameterException("Illegal number of arguments");
    }
    String rollData = args[1];

    if(registry.exists(rollData)) {
      rollData = registry.get(rollData);
    }

    String result = new RollController().parseRoll(rollData, new DisadvantageParsedRollHandler());
    return new CommandResult(true, result);
  }
}

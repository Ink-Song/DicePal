package io.github.ink_song.tools.command;

import io.github.ink_song.tools.controller.RollController;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.parser.StandardParsedRollHandler;

import java.security.InvalidParameterException;

public class RollCommand implements Command {

  @Override
  public CommandResult execute(String[] args) {
    RollController rollController = new RollController();
    if(args.length != 2){
      throw new InvalidParameterException("Invalid number of arguments");
    }
    String rollData = args[1];
    String result = rollController.parseRoll(rollData, new StandardParsedRollHandler());
    return new CommandResult(true, result);
  }
}

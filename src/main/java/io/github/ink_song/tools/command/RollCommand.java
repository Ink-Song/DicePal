package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.util.RollParser;

import java.security.InvalidParameterException;

public class RollCommand implements Command {

  @Override
  public CommandResult execute(String[] args) {
    RollParser parser = new RollParser();
    if(args.length != 2){
      throw new InvalidParameterException("Invalid number of arguments");
    }
    String result = parser.evaluate(args[1]);
    return new CommandResult(true, result);
  }
}

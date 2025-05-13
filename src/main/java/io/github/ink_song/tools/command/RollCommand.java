package io.github.ink_song.tools.command;

import io.github.ink_song.tools.util.RollParser;

public class RollCommand implements Command {
  private final RollParser parser;
  private final String input;

  public RollCommand(String input) {
    parser = new RollParser();
    this.input = input;
  }

  @Override
  public void execute(){
    parser.evaluate(input);
  }
}

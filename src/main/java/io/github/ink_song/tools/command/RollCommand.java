package io.github.ink_song.tools.command;

public class RollCommand implements Command {
  //Format
  // roll 1d20 + 2d10 + 4;

  public RollCommand(String input) {
    //basically needs a roll parser to read the input and generate dice from it.
    //need to figure out program structure. Where are the dice objects stored? Do we make new ones each time?
    //Are we getting an existing set of dice or making one?
  }

  @Override
  public void execute(){

  }
}

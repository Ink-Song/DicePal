package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.RollCommand;

public class CommandFactory {

  public RollCommand rollCommand(){
    return new RollCommand();
  }
}

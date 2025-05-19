package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.RollCommand;
import io.github.ink_song.tools.command.RollStatsCommand;

public class CommandFactory {

  public RollCommand rollCommand(){
    return new RollCommand();
  }

  public RollStatsCommand rollStatsCommand(){
    return new RollStatsCommand();
  }
}

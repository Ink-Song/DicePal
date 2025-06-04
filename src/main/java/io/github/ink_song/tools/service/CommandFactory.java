package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.*;

public class CommandFactory {

  public RollCommand rollCommand(){
    return new RollCommand();
  }

  public RollStatsCommand rollStatsCommand(){
    return new RollStatsCommand();
  }

  public RollAdvantageCommand rollAdvantageCommand(){
    return new RollAdvantageCommand();
  }

  public Command rollDisadvantageCommand() {
    return new RollDisadvantageCommand();
  }
}

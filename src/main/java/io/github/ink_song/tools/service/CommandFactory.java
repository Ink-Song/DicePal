package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.*;

public class CommandFactory {

  private CustomCommandRegistry customCommandRegistry;
  public CommandFactory(CustomCommandRegistry customCommandRegistry) {
    this.customCommandRegistry = customCommandRegistry;
  }

  public RollCommand rollCommand(){
    return new RollCommand(customCommandRegistry);
  }

  public RollStatsCommand rollStatsCommand(){
    return new RollStatsCommand();
  }

  public RollAdvantageCommand rollAdvantageCommand(){
    return new RollAdvantageCommand(customCommandRegistry);
  }

  public Command rollDisadvantageCommand() {
    return new RollDisadvantageCommand(customCommandRegistry);
  }
}

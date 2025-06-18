package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.*;

import java.util.Scanner;

public class CommandFactory {

  private final CustomCommandRegistry customCommandRegistry;
  private final Scanner scanner;
  public CommandFactory(CustomCommandRegistry customCommandRegistry, Scanner scanner) {
    this.customCommandRegistry = customCommandRegistry;
    this.scanner = scanner;
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

  public Command defineCustomRollCommand() {
    return new DefineCustomCommand(customCommandRegistry);
  }

  public Command clearCustomRegistryCommand() {
    return new ClearCustomCommand(customCommandRegistry, scanner);
  }
}

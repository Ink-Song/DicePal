package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.*;
import io.github.ink_song.tools.service.output.Output;

import java.util.Scanner;

public class CommandFactory {

  private final CustomCommandRegistry customCommandRegistry;
  private final Scanner scanner;
  private final Output output;
  private final CommandRegistry commandRegistry;
  public CommandFactory(CustomCommandRegistry customCommandRegistry,
                        Scanner scanner, Output output,
                        CommandRegistry commandRegistry) {
    this.customCommandRegistry = customCommandRegistry;
    this.scanner = scanner;
    this.output = output;
    this.commandRegistry = commandRegistry;
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

  public Command helpCommand() {
    return new HelpCommand(output, commandRegistry);
  }
}

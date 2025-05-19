package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommandRegistry {
  private final Map<String, Supplier<Command>> commands = new HashMap<>();

  public void register(String commandName, Supplier<Command> command) {
    commands.put(commandName, command);
  }

  public void getCommands() {
    commands.forEach((commandName, commandSupplier) -> commandSupplier.get());
  }

  public Command getCommand(String commandName) {
    return commands.get(commandName).get();
  }
}

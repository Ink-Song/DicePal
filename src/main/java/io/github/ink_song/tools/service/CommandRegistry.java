package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.Command;
import io.github.ink_song.tools.command.CommandEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
  private final Map<String, CommandEntry> commands = new HashMap<>();

  public void register(CommandEntry entry) {
    commands.put(entry.getName(), entry);
  }

  public List<CommandEntry> getAllCommands() {
    List<CommandEntry> commandList = new ArrayList<>(commands.values());
    commandList.addAll(commands.values());
    return commandList;
  }

  public Command getCommand(String commandName) {
    return commands.get(commandName).getSupplier().get();
  }
}

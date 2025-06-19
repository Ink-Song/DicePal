package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CommandRegistry;
import io.github.ink_song.tools.service.output.Output;
import io.github.ink_song.tools.util.StringUtil;

import java.util.List;

public class HelpCommand implements Command {

  private final Output output;
  private final CommandRegistry registry;
  public HelpCommand(Output output, CommandRegistry registry) {
    this.output = output;
    this.registry = registry;
  }
  /**
   * Executes a given command.
   *
   * @param args
   */
  @Override
  public CommandResult execute(String[] args) {
    List<CommandEntry> commands = registry.getAllCommands();
    String format = StringUtil.getTabularFormat();
    output.printf(format, "Command", "Description");
    output.printf(format, "--------", "---------------------------------");

    for (CommandEntry command : commands) {
      output.printf(format, command.getName(), command.getDescription());
    }
    return null;
  }
}

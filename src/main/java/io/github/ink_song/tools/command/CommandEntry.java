package io.github.ink_song.tools.command;

import java.util.function.Supplier;

public class CommandEntry {
  private final String name;
  private final String description;
  private final Supplier<Command> supplier;

  public CommandEntry(String name, String description, Supplier<Command> command) {
    this.name = name;
    this.description = description;
    this.supplier = command;
  }

  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public Supplier<Command> getSupplier() {
    return supplier;
  }
}

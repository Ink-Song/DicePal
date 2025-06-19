package io.github.ink_song.tools.service;

import io.github.ink_song.tools.command.Command;
import io.github.ink_song.tools.command.CommandEntry;
import io.github.ink_song.tools.command.TestCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CommandRegistryTest {

  private static CommandRegistry registry;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    registry = new CommandRegistry();
    registry.register(new CommandEntry("/test", "Testing", new Supplier<Command>() {
      @Override
      public Command get() {
        return new TestCommand();
      }
    }));
  }

  @Test
  void register() {
    int listSize = registry.getAllCommands().size();
    assertEquals(1, listSize);
    registry.register(new CommandEntry("/test2", "Testing", new Supplier<Command>() {
      @Override
      public Command get() {
        return new TestCommand();
      }
    }));
    assertEquals(listSize + 1, registry.getAllCommands().size());

  }

  @Test
  void getAllCommands() {
  }

  @Test
  void getCommand() {
  }
}
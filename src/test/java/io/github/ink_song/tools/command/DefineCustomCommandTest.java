package io.github.ink_song.tools.command;

import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CustomCommandRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefineCustomCommandTest {

  private final CustomCommandRegistry customCommandRegistry = new CustomCommandRegistry("config", "test.properties");
  private DefineCustomCommand defineCustomCommand;
  private final String[] args = new String[]{
      "/def",
      "barbarian",
      "1d20 + 5, 1d10 + 2"
  };

  @BeforeEach
  void setUp() {
    try {
      customCommandRegistry.initialize();
      defineCustomCommand = new DefineCustomCommand(customCommandRegistry);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void execute() {
    CommandResult result = defineCustomCommand.execute(args);
    System.out.println(result.getMessage());
    System.out.println(customCommandRegistry.get("barbarian"));
  }
}
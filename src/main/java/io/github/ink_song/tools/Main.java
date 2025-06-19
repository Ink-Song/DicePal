package io.github.ink_song.tools;

import io.github.ink_song.tools.command.CommandEntry;
import io.github.ink_song.tools.exception.InvalidCommandException;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CommandFactory;
import io.github.ink_song.tools.service.CommandRegistry;
import io.github.ink_song.tools.service.CustomCommandRegistry;
import io.github.ink_song.tools.service.InputHandler;
import io.github.ink_song.tools.service.color.AnsiColor;
import io.github.ink_song.tools.service.output.ConsoleOutput;
import io.github.ink_song.tools.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BOLD = "\u001B[1m";


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ConsoleOutput output = new ConsoleOutput();
    CustomCommandRegistry customCommandRegistry = new CustomCommandRegistry("config","shortcuts.properties");
    try {
      customCommandRegistry.initialize();
    } catch (Exception e) {
      String errormessage = StringUtil.color("Failed to Initialize Custom Command Registry", AnsiColor.RED);
      output.println(errormessage);
      logger.error(e);
    }

    CommandRegistry commandRegistry = new CommandRegistry();
    CommandFactory commandFactory = new CommandFactory(customCommandRegistry, scanner, output, commandRegistry);
    InputHandler inputHandler = new InputHandler(commandRegistry);
    initializeCommands(commandRegistry, commandFactory);
    String input;

    displayWelcome();

    while(true) {
      output.print("> ");
      input = scanner.nextLine();
      if (input.equals("/quit")) {
        System.exit(0);
      }
      try {
        CommandResult result = inputHandler.handle(input);
        if (result == null) {
          continue;
        }
        output.println(ANSI_BOLD + "Result: " + ANSI_RESET + result.getMessage());
      } catch (InvalidCommandException e) {
        output.println("Invalid command: " + e.getMessage());
      }
    }
  }

  private static void initializeCommands(CommandRegistry commandRegistry, CommandFactory commandFactory) {
    commandRegistry.register(new CommandEntry("/roll",
        "Rolls dice and returns result. Separate rolls with a comma (1d20, 2d10 + 5, etc)",
        commandFactory::rollCommand));
    commandRegistry.register(new CommandEntry("/npc",
        "Roll 5e compatible stats using 4d6 drop lowest.",
        commandFactory::rollStatsCommand));
    commandRegistry.register(new CommandEntry("/adv",
        "Rolls twice. Prints both, highlights highest. Use like /roll",
        commandFactory::rollAdvantageCommand));
    commandRegistry.register(new CommandEntry("/dis",
        "Rolls twice. Prints both, highlights lowest. Use like /roll.",
        commandFactory::rollDisadvantageCommand));
    commandRegistry.register(new CommandEntry("/def",
        "Define custom rolls. Use <Name> <Roll(s)> format. Can be used in /roll, /adv, /dis",
        commandFactory::defineCustomRollCommand));
    commandRegistry.register(new CommandEntry("/clear",
        "Clears all custom commands. Cannot be undone.",
        commandFactory::clearCustomRegistryCommand));
    commandRegistry.register(new CommandEntry("/help",
        "Lists all commands and their descriptions.",
        commandFactory::helpCommand
        ));
  }

  private static void displayWelcome(){
    String[] welcome = new String[]{
        "______ _____ _____  ___________  ___   _",
        "|  _  \\_   _/  __ \\|  ___| ___ \\/ _ \\ | |    ",
        "| | | | | | | /  \\/| |__ | |_/ / /_\\ \\| |    ",
        "| | | | | | | |    |  __||  __/|  _  || |    ",
        "| |/ / _| |_| \\__/\\| |___| |   | | | || |____",
        "|___/  \\___/ \\____/\\____/\\_|   \\_| |_/\\_____/"
    };
    for (String string : welcome) {
      System.out.println(string);
    }
    System.out.println("Welcome and Happy Rolling!");
  }
}
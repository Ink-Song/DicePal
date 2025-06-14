package io.github.ink_song.tools;

import io.github.ink_song.tools.exception.InvalidCommandException;
import io.github.ink_song.tools.model.CommandResult;
import io.github.ink_song.tools.service.CommandFactory;
import io.github.ink_song.tools.service.CommandRegistry;
import io.github.ink_song.tools.service.InputHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BOLD = "\u001B[1m";
  private static final String WELCOME = "";


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CommandFactory commandFactory = new CommandFactory();
    CommandRegistry commandRegistry = new CommandRegistry();

    InputHandler inputHandler = new InputHandler(commandRegistry);
    initializeCommands(commandRegistry, commandFactory);
    String input;

    displayWelcome();

    while(true) {
      System.out.print("> ");
      input = scanner.nextLine();
      if (input.equals("/quit")) {
        System.exit(0);
      }
      try {
        CommandResult output = inputHandler.handle(input);
        if (output == null) {
          continue;
        }
        System.out.println(ANSI_BOLD + "Result: " + ANSI_RESET + output.getMessage());
      } catch (InvalidCommandException e) {
        System.out.println("Invalid command: " + e.getMessage());
      }
    }
  }

  private static void initializeCommands(CommandRegistry commandRegistry, CommandFactory commandFactory) {
    commandRegistry.register("/roll", commandFactory::rollCommand);
    commandRegistry.register("/npc", commandFactory::rollStatsCommand);
    commandRegistry.register("/adv", commandFactory::rollAdvantageCommand);
    commandRegistry.register("/dis", commandFactory::rollDisadvantageCommand);
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
    for (int i = 0; i < welcome.length; i++) {
      System.out.println(welcome[i]);
    }
    System.out.println("Welcome and Happy Rolling!");
  }
}
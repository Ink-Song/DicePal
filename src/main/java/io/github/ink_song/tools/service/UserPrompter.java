package io.github.ink_song.tools.service;

import java.util.Scanner;

public class UserPrompter {

  public boolean isConfirmed(Scanner scanner, CustomCommandRegistry customCommandRegistry, String question) {
    System.out.println(question);
    System.out.println("y/n");
    String input;

    while(true){
      System.out.print("> ");
      input = scanner.nextLine();
      switch(input){
        case "y": return true;
        case "n": return false;
        default:
          System.out.println("Input not Recognized. Please use y or n");
          break;
      }
    }

  }
}
